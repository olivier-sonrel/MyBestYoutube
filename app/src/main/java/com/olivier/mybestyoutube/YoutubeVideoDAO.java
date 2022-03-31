package com.olivier.mybestyoutube;

import android.content.ContentValues;
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

    public void add(YoutubeVideo youtubeVideo){
        open();

        ContentValues value = new ContentValues();

        value.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TITLE, youtubeVideo.getTitle());
        value.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_DESCRIPTION, youtubeVideo.getDescription());
        value.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_URL, youtubeVideo.getUrl());
        value.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_CATEGORY, youtubeVideo.getCategory());

        db.insert(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TABLE_NAME, null, value);
    }

    public void update(YoutubeVideo youtubeVideo) {
        open();

        ContentValues values = new ContentValues();

        values.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TITLE, youtubeVideo.getTitle());
        values.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_DESCRIPTION, youtubeVideo.getDescription());
        values.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_URL, youtubeVideo.getUrl());
        values.put(YoutubeVideoDBHelper.YOUTUBE_VIDEO_CATEGORY, youtubeVideo.getCategory());

        db.update(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TABLE_NAME, values, YoutubeVideoDBHelper.YOUTUBE_VIDEO_KEY + " = ?",
                new String[] { String.valueOf(youtubeVideo.getId())});

        close();
    }

    public void delete(YoutubeVideo youtubeVideo) {
        open();

        db.delete(YoutubeVideoDBHelper.YOUTUBE_VIDEO_TABLE_NAME, YoutubeVideoDBHelper.YOUTUBE_VIDEO_KEY + " = ?",
                new String[] { String.valueOf(youtubeVideo.getId())});

        close();
    }

}
