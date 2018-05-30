package com.example.kavin.wantedxtickets.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.kavin.wantedxtickets.Database.TicketsContract.TicketsEntry.TICKETS_DB_TABLE_NAME;

public class TicketsDBHelper extends SQLiteOpenHelper {

    public static final String TICKETS_DATABASE = "ticketDB.db";

    private static final int DATABASE_VERSION_NUMBERS = 3;

    //Tables Names
    private static final String postsDetails = "posts_details";
    private static final String accountDetails = "account_details";
    private static final String reviews = "reviews";

    //Common column names


    //Post Details column names
    private static final String KEY_TITLE = "title";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DATE = "date";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_LOCATION = "location";

    //Account info column names
    private static final String KEY_ACCT_NAME = "account_name";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_LOCATION_HOME = "location_home";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";

    //Reviews column names
    private static final String KEY_DESCRIPTIONS_REVIEWS = "reviews_description";
    private static final String KEY_RATINGS = "ratings";

    public TicketsDBHelper(Context context) {
        super(context, TICKETS_DATABASE, null, DATABASE_VERSION_NUMBERS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TICKETS_DATABASE =
                "CREATE TABLE " + TICKETS_DB_TABLE_NAME + " (" +
                        TicketsContract.TicketsEntry.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TicketsContract.TicketsEntry.KEY_THREAD_TITLE + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_DATE + " INTEGER NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_PRICE + " INTEGER NOT NULL, " +
                        TicketsContract.TicketsEntry.KEY_LOCATION + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_DESCRIPTION + " TEXT NOT NULL," +
                        TicketsContract.TicketsEntry.KEY_GENRE + " INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TICKETS_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TICKETS_DB_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
