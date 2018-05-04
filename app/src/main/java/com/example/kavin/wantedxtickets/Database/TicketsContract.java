package com.example.kavin.wantedxtickets.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class TicketsContract {
    public static final String AUTHORITY = "com.example.kavin.wantedxtickets";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_TICKETS_STORE_DB = "results";

    public static final class TicketsEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_TICKETS_STORE_DB).build();

        public static final String TICKETS_DB_TABLE_NAME = "results";
        public static final String KEY_ID = "id";
        public static final String KEY_ACCOUNT_NAME = "account_name";
        public static final String KEY_DATE = "date";
        public static final String KEY_PRICE = "price";
        public static final String KEY_LOCATION = "location";
        public static final String KEY_DESCRIPTION = "description";
        public static final String KEY_GENGRE = "genre";
        public static final String KEY_IMAGE = "image";
        public static final String KEY_PASSWORD = "password";
        public static final String KEY_REVIEWS_ACCT = "reviews_account";
        public static final String KEY_REVIEWS_DESCRIPTION = "reviews_description";
        public static final String KEY_RATING = "rating";
    }
}
