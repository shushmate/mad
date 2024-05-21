package com.example.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {

    MediaPlayer m;

    public MyService(){}

    @Override
    public void onCreate() {
        super.onCreate();
        m=MediaPlayer.create(this,R.raw.song);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        m.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        m.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not implemented");
    }


}
