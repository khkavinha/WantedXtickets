package com.example.kavin.wantedxtickets.Database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.example.kavin.wantedxtickets.Database.TicketsContract.PATH_TICKETS_STORE_DB;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_ACCOUNT_NAME;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_DATE;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_DESCRIPTION;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_GENRE;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_ID;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_IMAGE;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_LOCATION;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_PASSWORD;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_PRICE;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_RATING;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_REVIEWS_ACCT;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.KEY_REVIEWS_DESCRIPTION;
import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.TICKETS_DB_TABLE_NAME;

public class TicketsContentProvider extends ContentProvider {

    private TicketsDBHelper mTicketsDBHelper;
    public static final int TASKS = 100;
    public static final int TASKS_WITH_ID = 101;

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(TicketsContract.AUTHORITY, PATH_TICKETS_STORE_DB, TASKS);
        uriMatcher.addURI(TicketsContract.AUTHORITY, PATH_TICKETS_STORE_DB + "/#", TASKS_WITH_ID);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mTicketsDBHelper = new TicketsDBHelper(context);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = mTicketsDBHelper.getReadableDatabase();

        Cursor retCursor;

        switch (sUriMatcher.match(uri)) {
            case TASKS_WITH_ID: {
                String normalizedTicketString = uri.getLastPathSegment();
                String[] selectionArguments = new String[]{normalizedTicketString};
                retCursor = mTicketsDBHelper.getReadableDatabase().query(
                        PATH_TICKETS_STORE_DB,
                        null,
                        KEY_ID + " = ? " +
                                KEY_ACCOUNT_NAME + " = ? " +
                                KEY_DATE + " = ? " +
                                KEY_PRICE + " = ? " +
                                KEY_LOCATION + " = ? " +
                                KEY_DESCRIPTION + " = ? " +
                                KEY_GENRE + " = ? " +
                                KEY_IMAGE + " = ? " +
                                KEY_PASSWORD + " = ? " +
                                KEY_REVIEWS_ACCT + " = ? " +
                                KEY_REVIEWS_DESCRIPTION + " = ? " +
                                KEY_RATING + " = ? ",
                        selectionArguments,
                        null,
                        null,
                        sortOrder);
                break;
            }

            case TASKS: {
                retCursor = db.query(
                        PATH_TICKETS_STORE_DB,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = mTicketsDBHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch (match) {
            case TASKS:
                long id = db.insertWithOnConflict(TICKETS_DB_TABLE_NAME, null, values,
                        SQLiteDatabase.CONFLICT_REPLACE);
                if (id > 0) {
                    returnUri = ContentUris.withAppendedId(TicketsContract.TicketsEntry.CONTENT_URI, id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mTicketsDBHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        int taskDeleted;

        switch (match) {
            case TASKS:
                taskDeleted = db.delete(TICKETS_DB_TABLE_NAME, "id=?", selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (taskDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return
                taskDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }
}
