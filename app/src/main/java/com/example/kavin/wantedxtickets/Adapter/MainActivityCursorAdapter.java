package com.example.kavin.wantedxtickets.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavin.wantedxtickets.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
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
        ImageView imageView = (ImageView) view.findViewById(R.id.imagePost);

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("folderName/file.jps");
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //Got the download URL for
                //pass it to Picasso to download, show in ImageView and caching
                Picasso.with(context).load(uri.toString()).into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("Failure", e.toString());
            }
        });

    }
}
