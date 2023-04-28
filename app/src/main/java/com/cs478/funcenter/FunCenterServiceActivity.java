package com.cs478.funcenter;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.cs478.KeyComon.FunCenterService;

import java.security.Provider;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class FunCenterServiceActivity extends Service {
    List<Bitmap> pictures = new ArrayList<Bitmap>();
    private boolean isPlaying = false;
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Images", "Servive was created!") ;
        pictures.add(BitmapFactory.decodeResource(getResources(), R.raw.hsr));
        pictures.add(BitmapFactory.decodeResource(getResources(), R.raw.hsrtl));
        pictures.add(BitmapFactory.decodeResource(getResources(), R.raw.zelda));

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }



    private final FunCenterService.Stub mBinder = new FunCenterService.Stub() {

        @Override
        public Bitmap getPicture(int pictureNumber) throws RemoteException {
            Bitmap pic;
            synchronized (pictures) {
                pic = pictures.get(pictureNumber);
            }
            return pic;
        }

        @Override
        public void playAudio(int audioNumber) throws RemoteException {
            if(isPlaying == true) {
                Log.i("player", "music is already playing");
                return;
            }
            switch(audioNumber) {
                case 0:
                    mediaPlayer = MediaPlayer.create(FunCenterServiceActivity.this, R.raw.hsrtrain);
                    break;
                case 1:
                    mediaPlayer = MediaPlayer.create(FunCenterServiceActivity.this, R.raw.hsrtrailer);
                    break;
                case 2:
                    mediaPlayer = MediaPlayer.create(FunCenterServiceActivity.this, R.raw.zeldasong);
                    break;
                default:
                    break;
            }
            mediaPlayer.start();
            if(mediaPlayer != null) {
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.setLooping(true);
            }
            isPlaying = true;
            return;

        }

        @Override
        public void pauseAudio() throws RemoteException {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                isPlaying = false;
                return;
            }
        }

        @Override
        public void resumeAudio() throws RemoteException {
            if(!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                isPlaying = true;
                return;
            }
        }

        @Override
        public void stopAudio() throws RemoteException {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                isPlaying = false;
                return;
            }
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

    };
//    @Override
//    public IBinder onBind(Intent intent) {
//        return new FunCenterService.Stub() {
//            @Override
//            public int getPicture(int number) throws RemoteException {
//                // TODO: Implement getPicture method
//                return 0;
//            }
//
//            @Override
//            public void playAudio(int number) throws RemoteException {
//                if (mediaPlayer == null) {
//                    mediaPlayer = MediaPlayer.create(FunCenterService.this, getAudioResourceId(number));
//                }
//                mediaPlayer.start();
//            }
//
//            @Override
//            public void pauseAudio() throws RemoteException {
//                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//                    mediaPlayer.pause();
//                }
//            }
//
//            @Override
//            public void resumeAudio() throws RemoteException {
//                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
//                    mediaPlayer.start();
//                }
//            }
//
//            @Override
//            public void stopAudio() throws RemoteException {
//                if (mediaPlayer != null) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                    mediaPlayer = null;
//                }
//            }
//        };
//    }
//
//    private int getAudioResourceId(int number) {
//        switch (number) {
//            case 1:
//                return R.raw.audio1;
//            case 2:
//                return R.raw.audio2;
//            case 3:
//                return R.raw.audio3;
//            default:
//                return 0;
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (mediaPlayer != null) {
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }
//    }
}
