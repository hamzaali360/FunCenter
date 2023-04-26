package com.cs478.funcenter;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class FunCenterServiceActivity extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("KeyGeneratorService", "Servive was created!") ;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private MediaPlayer mediaPlayer;
    private final static Set<UUID> mIDs = new HashSet<UUID>();

    private final FunCenterService.Stub mBinder = new FunCenterService.Stub() {

        // Implement the remote method
        public String[] getKey() {

            UUID id;

            // Acquire lock to ensure exclusive access to mIDs
            // Then examine and modify mIDs

            //enforceCallingPermission("course.examples.Services.KeyService.GEN_ID", "TODO: message if thrown") ;
            synchronized (mIDs) {

                do {

                    id = UUID.randomUUID();

                } while (mIDs.contains(id));

                mIDs.add(id);
            }
            String[] s;
            s = new String[]{ id.toString()};
            Log.i("Ugo says", "String is: " + s[0]) ;
            return s;
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
