package com.vmaron.tvinsider.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vmaron.tvinsider.Model.TvShow;
import com.vmaron.tvinsider.R;

public class ShowDetailActivity extends AppCompatActivity
{
    private TvShow tvShow;

    private ImageView showPoster;
    private TextView showTitle;
    private TextView plot;
    private TextView rating;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        tvShow = (TvShow) getIntent().getSerializableExtra("show");
        setUpUI();
        setDetails();
    }

    private void setUpUI()
    {
        showPoster = findViewById(R.id.showImageIDDets);
        showTitle = findViewById(R.id.showTitleIDDets);
        rating = findViewById(R.id.movieRatingIDDet);
        plot = findViewById(R.id.plotDet);
    }

    private void setDetails()
    {
        showTitle.setText(this.tvShow.getName());

        String year = tvShow.getFirstAirYear();
        if (year.length() > 0)
            showTitle.setText(String.format("%s (%s)", tvShow.getName(), year));
        else
            showTitle.setText(tvShow.getName());

        this.rating.setText(String.format("%d/10", tvShow.getVoteAvg()));

        String posterlink = tvShow.getPoster();
        Picasso.with(getApplicationContext())
                .load(posterlink)
                .placeholder(R.drawable.tv_icon)
                .into(this.showPoster);

        plot.setText(tvShow.getOverview());
    }
}
