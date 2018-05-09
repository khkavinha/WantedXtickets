package com.example.kavin.wantedxtickets.Database;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class QueryHandler extends AsyncQueryHandler {
    private WeakReference<AsyncQueryListener> mListener;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({OperationToken.TOKEN_QUERY, OperationToken.TOKEN_INSERT, OperationToken.TOKEN_UPDATE,
    OperationToken.TOKEN_DELETE})

    public @interface OperationToken
    {
        int TOKEN_QUERY = 0;
        int TOKEN_INSERT = 1;
        int TOKEN_UPDATE = 2;
        int TOKEN_DELETE = 3;
    }
    public interface AsyncQueryListener {
        void onQueryComplete(int token, Object cookie, Cursor cursor);
    }

    public QueryHandler(Context context,AsyncQueryListener listener) {
        super(context.getContentResolver());
        setQueryListener(listener);
    }

    public void setQueryListener(AsyncQueryListener listener) {
        mListener = new WeakReference<>(listener);
    }


    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor)
    {
        final AsyncQueryListener listener = mListener.get();
        if (listener != null)
        {
            listener.onQueryComplete(token, cookie, cursor);
        }
        else if (cursor != null)
        {
            cursor.close();
        }
    }
}
