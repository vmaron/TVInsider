package com.vmaron.tvinsider.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.vmaron.tvinsider.Model.TvShow;

import java.util.List;

public class TvShowRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(@NonNull View itemView, final Context ctx)
        {
            super(itemView);
            context = ctx;
        }
    }
}
