package com.vmaron.tvinsider.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.vmaron.tvinsider.Data.Request.TvShowSearchRequest;
import com.vmaron.tvinsider.Data.Response.TvShowSearchResponse;
import com.vmaron.tvinsider.Data.TvShowRecyclerViewAdapter;
import com.vmaron.tvinsider.Data.TvShows;
import com.vmaron.tvinsider.Model.TvShow;
import com.vmaron.tvinsider.Model.TvShowPagedResults;
import com.vmaron.tvinsider.R;
import com.vmaron.tvinsider.Util.Prefs;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private TvShowRecyclerViewAdapter movieRecyclerViewAdapter;
    private List<TvShow> movieList;

    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showInputDialog();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Prefs prefs = new Prefs(MainActivity.this);
        String search = prefs.getSearch();

        movieList = new ArrayList<TvShow>();

        getTvShows(search);

        movieRecyclerViewAdapter = new TvShowRecyclerViewAdapter(this, movieList);
        recyclerView.setAdapter(movieRecyclerViewAdapter);
        movieRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_search)
        {
            showInputDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showInputDialog()
    {
        alertDialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_view, null);
        final EditText newSearchEdt = (EditText) view.findViewById(R.id.searchEdt);
        Button submitButton = (Button) view.findViewById(R.id.submitButton);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Prefs prefs = new Prefs(MainActivity.this);

                if (!newSearchEdt.getText().toString().isEmpty())
                {

                    String search = newSearchEdt.getText().toString();
                    prefs.setSearch(search);
                    movieList.clear();

                    getTvShows(search);

                }
                dialog.dismiss();
            }
        });
    }

    private void getTvShows(String query)
    {
        movieList.clear();
        new TvShows().search(new TvShowSearchRequest(query, 1), new TvShowSearchResponse()
        {
            @Override
            public void processResponse(TvShowPagedResults results)
            {
                movieList.addAll(results.getResults());
                movieRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }
}
