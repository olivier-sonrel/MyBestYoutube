package com.olivier.mybestyoutube;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class YoutubeVideoDAO extends DAO{
    public YoutubeVideoDAO(Context context){ super(new YoutubeVideoDBHelper(context)); }

    public YoutubeVideo find(Long id){
        YoutubeVideo youtubeVideo = null;

        Cursor cursor = db.rawQuery("select * from " + YoutubeVideoDBHelper.YOUTUBE_VIDEO_TABLE_NAME +
                        " where " + YoutubeVideoDBHelper.YOUTUBE_VIDEO_KEY_COLUMN_INDEX + " = ?",
                new String[] { String.valueOf(id)}
        );

        if(cursor != null && cursor.moveToFirst()){
            youtubeVideo = new YoutubeVideo();
            youtubeVideo.setId(cursor.getLong(YoutubeVideoDBHelper.YOUTUBE_VIDEO_KEY_COLUMN_INDEX));
            youtubeVideo.setTitle(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TITLE_COLUMN_INDEX));
            youtubeVideo.setDescription(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_DESCRIPTION_COLUMN_INDEX));
            youtubeVideo.setUrl(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_URL_COLUMN_INDEX));
            youtubeVideo.setCategory(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_CATEGORY_COLUMN_INDEX));

            cursor.close();
        }
        return youtubeVideo;
    }

    public List<YoutubeVideo> list(){
        open();

        List<YoutubeVideo> youtubeVideos = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + YoutubeVideoDBHelper.YOUTUBE_VIDEO_TABLE_NAME, null);

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                YoutubeVideo youtubeVideo = new YoutubeVideo();

                youtubeVideo.setId(cursor.getLong(YoutubeVideoDBHelper.YOUTUBE_VIDEO_KEY_COLUMN_INDEX));
                youtubeVideo.setTitle(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TITLE_COLUMN_INDEX));
                youtubeVideo.setDescription(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_DESCRIPTION_COLUMN_INDEX));
                youtubeVideo.setUrl(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_URL_COLUMN_INDEX));
                youtubeVideo.setCategory(cursor.getString(YoutubeVideoDBHelper.YOUTUBE_VIDEO_CATEGORY_COLUMN_INDEX));

                youtubeVideos.add(youtubeVideo);

                cursor.moveToNext();
            }
        }

        cursor.close();

        return youtubeVideos;
    }
}
