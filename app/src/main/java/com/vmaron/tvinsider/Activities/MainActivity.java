package com.vmaron.tvinsider.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vmaron.tvinsider.Data.Request.TvShowSearchRequest;
import com.vmaron.tvinsider.Data.Response.TvShowSearchResponse;
import com.vmaron.tvinsider.Data.TvShows;
import com.vmaron.tvinsider.Model.TvShow;
import com.vmaron.tvinsider.Model.TvShowPagedResults;
import com.vmaron.tvinsider.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getTvShows();
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
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<TvShow> getTvShows()
    {
        final List<TvShow> tvShows = new ArrayList<TvShow>();
        new TvShows().search(new TvShowSearchRequest("idol", 1), new TvShowSearchResponse()
        {
            @Override
            public void processResponse(TvShowPagedResults results)
            {
                tvShows.addAll(results.getResults());
            }
        });
        return tvShows;
    }
}
