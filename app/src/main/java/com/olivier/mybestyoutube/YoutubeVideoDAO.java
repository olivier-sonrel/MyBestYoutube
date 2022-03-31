package com.olivier.mybestyoutube;

import android.content.Context;

public class YoutubeVideoDAO extends DAO{
    public YoutubeVideoDAO(Context context){ super(new YoutubeVideoDBHelper(context)); }
}
