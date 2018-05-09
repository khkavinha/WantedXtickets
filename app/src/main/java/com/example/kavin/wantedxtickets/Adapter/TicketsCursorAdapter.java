package com.example.kavin.wantedxtickets.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.kavin.wantedxtickets.R;


import butterknife.BindView;
import butterknife.ButterKnife;

public class TicketsCursorAdapter extends CursorRecyclerAdapter<TicketsCursorAdapter.ViewHolder> {
    private String[] mGenresLists;

    public TicketsCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        Resources resources = context.getResources();
        mGenresLists = resources.getStringArray(R.array.genres_lists);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, Cursor cursor) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.acct_name)
         TextView acctName;
         @BindView(R.id.threadTitle)
         TextView threadTitle;
         @BindView(R.id.Date)
         TextView dates;
         @BindView(R.id.Price)
         TextView prices;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
