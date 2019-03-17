package com.vmaron.tvinsider.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vmaron.tvinsider.Model.TvShow;
import com.vmaron.tvinsider.R;

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
        TvShow movie = this.tvShowList.get(position);
        String posterlink = movie.getPoster();

        viewHolder.title.setText(movie.getName());

        Picasso.with(context)
                .load(posterlink)
                .placeholder(R.drawable.tv_icon)
                .into(viewHolder.poster);
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

        public ViewHolder(@NonNull View itemView, final Context ctx)
        {
            super(itemView);
            context = ctx;

            title = (TextView) itemView.findViewById(R.id.showTitleID);
            poster = (ImageView) itemView.findViewById(R.id.showImageID);
        }

        @Override
        public void onClick(View view)
        {

        }
    }
}
