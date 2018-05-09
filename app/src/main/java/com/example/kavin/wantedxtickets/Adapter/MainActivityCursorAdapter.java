package com.example.kavin.wantedxtickets.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavin.wantedxtickets.R;
import com.squareup.picasso.Picasso;


public class MainActivityCursorAdapter extends CursorAdapter {

    public MainActivityCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
       return LayoutInflater.from(context).inflate(R.layout.activity_main_recylcerview, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView acctName = (TextView) view.findViewById(R.id.acct_name);
        TextView threadTitle = (TextView) view.findViewById(R.id.acct_title);
        TextView dates = (TextView) view.findViewById(R.id.Date);
        TextView prices = (TextView) view.findViewById(R.id.Price);
        ImageView imagePost = (ImageView) view.findViewById(R.id.imagePost);

        Picasso.with(context).load(cursor.getString(cursor.getColumnIndexOrThrow("ticket_image")))
                .error(R.drawable.ic_error_code_bl)
                .into(imagePost);
    }
}
