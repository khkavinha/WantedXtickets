package com.example.kavin.wantedxtickets.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.TICKETS_DB_TABLE_NAME;

public class TicketsDBHelper extends SQLiteOpenHelper {

    public static final String TICKETS_DATABASE = "ticketDB.db";

    private static final int DATABASE_VERSION_NUMBERS = 3;

    public TicketsDBHelper(Context context) {
        super(context, TICKETS_DATABASE, null, DATABASE_VERSION_NUMBERS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TICKETS_DATABASE =
                "CREATE TABLE " + TICKETS_DB_TABLE_NAME + " (" +

                        TicketsContract.TicketsEntry.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TicketsContract.TicketsEntry.KEY_ACCOUNT_NAME + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_DATE + " INTEGER NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_PRICE + " INTEGER NOT NULL, " +
                        TicketsContract.TicketsEntry.KEY_LOCATION + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_DESCRIPTION + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_GENRE + " INTEGER NOT NULL, " +
                        TicketsContract.TicketsEntry.KEY_IMAGE + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_PASSWORD + " INTEGER NOT NULL, " +
                        TicketsContract.TicketsEntry.KEY_REVIEWS_ACCT + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_REVIEWS_DESCRIPTION + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_RATING + " TEXT NOT NULL," +
                        " UNIQUE (" + TicketsContract.TicketsEntry.KEY_REVIEWS_DESCRIPTION + ") ON CONFLICT REPLACE);";
        sqLiteDatabase.execSQL(SQL_CREATE_TICKETS_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TICKETS_DB_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
