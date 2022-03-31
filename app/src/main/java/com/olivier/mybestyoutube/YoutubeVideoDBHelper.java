package com.olivier.mybestyoutube;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

public class YoutubeVideoDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "youtube_video.db";

    public static final String YOUTUBE_VIDEO_KEY = "id";
    public static final String YOUTUBE_VIDEO_TITLE = "title";
    public static final String YOUTUBE_VIDEO_DESCRIPTION = "description";
    public static final String YOUTUBE_VIDEO_URL = "url";
    public static final String YOUTUBE_VIDEO_CATEGORY = "category";

    public static final String YOUTUBE_VIDEO_TABLE_NAME = "Youtube_video";

    public static final int YOUTUBE_VIDEO_KEY_COLUMN_INDEX = 0;
    public static final int YOUTUBE_VIDEO_TITLE_COLUMN_INDEX = 1;
    public static final int YOUTUBE_VIDEO_DESCRIPTION_COLUMN_INDEX = 2;
    public static final int YOUTUBE_VIDEO_URL_COLUMN_INDEX = 3;
    public static final int YOUTUBE_VIDEO_CATEGORY_COLUMN_INDEX = 4;

    private static final String YOUTUBE_VIDEO_TABLE_CREATE =
            "CREATE TABLE " + YOUTUBE_VIDEO_TABLE_NAME + " (" +
                    YOUTUBE_VIDEO_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    YOUTUBE_VIDEO_TITLE + " TEXT, " +
                    YOUTUBE_VIDEO_DESCRIPTION + " TEXT, " +
                    YOUTUBE_VIDEO_URL + " TEXT, " +
                    YOUTUBE_VIDEO_CATEGORY + " TEXT) ;";

    private static final String YOUTUBE_VIDEO_TABLE_DROP = " DROP TABLE IF EXISTS " + YOUTUBE_VIDEO_TABLE_NAME + ";";

    public YoutubeVideoDBHelper(Context context){ super(context, DATABASE_NAME, null, VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(YOUTUBE_VIDEO_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(YOUTUBE_VIDEO_TABLE_DROP);
        onCreate(db);
    }
}
