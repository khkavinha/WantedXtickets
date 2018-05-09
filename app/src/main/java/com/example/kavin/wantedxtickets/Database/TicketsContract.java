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
        public static final String KEY_THREAD_TITLE = "thread_title";
        public static final String KEY_DATE = "date";
        public static final String KEY_PRICE = "price";
        public static final String KEY_LOCATION = "location";
        public static final String KEY_DESCRIPTION = "description";
        public static final String KEY_GENRE = "genre";
        public static final String KEY_TICKET_IMAGE = "ticket_image";
    }
}
