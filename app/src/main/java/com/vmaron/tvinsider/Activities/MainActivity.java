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
import android.widget.Toast;

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

    private LinearLayoutManager layoutManager;
    private boolean isLoading;
    private boolean isLastPage;
    private int pageSize;
    private int page = 1;


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
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final Prefs prefs = new Prefs(MainActivity.this);
        String search = prefs.getSearch();

        movieList = new ArrayList<TvShow>();

        getTvShows(search, page);

        movieRecyclerViewAdapter = new TvShowRecyclerViewAdapter(this, movieList);
        recyclerView.setAdapter(movieRecyclerViewAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= pageSize)
                    {
                        String search = prefs.getSearch();
                        getTvShows(search, page + 1);
                    }
                }
            }
        });

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

                    getTvShows(search, 1);
                }
                dialog.dismiss();
            }
        });
    }

    private void getTvShows(String query, int pageNum)
    {
        isLoading = true;

        new TvShows().search(new TvShowSearchRequest(query, pageNum), new TvShowSearchResponse()
        {
            @Override
            public void processResponse(TvShowPagedResults results)
            {
                movieList.addAll(results.getResults());
                pageSize = results.getResults().size();
                page = results.getPage();
                isLastPage = page == results.getTotalPages();
                movieRecyclerViewAdapter.notifyDataSetChanged();
                isLoading = false;

                Toast.makeText(getApplicationContext(),"Displaying " + String.valueOf(movieList.size()) + " out of " + results.getTotalResults(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
