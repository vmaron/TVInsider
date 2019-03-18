package com.vmaron.tvinsider.Data;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vmaron.tvinsider.Activities.ShowDetailActivity;
import com.vmaron.tvinsider.Model.TvShow;
import com.vmaron.tvinsider.R;
import com.vmaron.tvinsider.Util.StringExtension;

import java.util.List;

public class TvShowRecyclerViewAdapter extends RecyclerView.Adapter<TvShowRecyclerViewAdapter.ViewHolder>
{
    private Context context;
    private List<TvShow> tvShowList;

    public TvShowRecyclerViewAdapter(Context context, List<TvShow> tvShowList)
    {
        this.context = context;
        this.tvShowList = tvShowList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tv_show_row, viewGroup, false);

        return new ViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(@NonNull TvShowRecyclerViewAdapter.ViewHolder viewHolder, int position)
    {
        TvShow tvShow = this.tvShowList.get(position);
        String posterlink = tvShow.getPoster();

        String year = tvShow.getFirstAirYear();
        if (year.length() > 0)
            viewHolder.title.setText(String.format("%s (%s)", tvShow.getName(), year));
        else
            viewHolder.title.setText(tvShow.getName());

        Picasso.with(context)
                .load(posterlink)
                .placeholder(R.drawable.tv_icon)
                .into(viewHolder.poster);


        viewHolder.voteAvg.setText(String.format("%d/10", tvShow.getVoteAvg()));
        viewHolder.overview.setText(StringExtension.truncate(tvShow.getOverview(), 80));
    }

    @Override
    public int getItemCount()
    {
        return tvShowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView title;
        public ImageView poster;
        public TextView voteAvg;
        public TextView overview;

        public ViewHolder(@NonNull View itemView, final Context ctx)
        {
            super(itemView);
            context = ctx;

            title = (TextView) itemView.findViewById(R.id.showTitleID);
            poster = (ImageView) itemView.findViewById(R.id.showImageID);
            voteAvg = (TextView) itemView.findViewById(R.id.voteAvgID);
            overview = (TextView) itemView.findViewById(R.id.showOverviewID);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    TvShow tvShow = tvShowList.get(getAdapterPosition());
                    Intent intent = new Intent(context, ShowDetailActivity.class);
                    intent.putExtra("show", tvShow);
                    context.startActivity(intent);

                    //Toast.makeText(context, "Row Tapped", Toast.LENGTH_LONG).show(); test if working.
                }
            });
        }

        @Override
        public void onClick(View view)
        {

        }
    }
}
