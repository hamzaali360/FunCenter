package com.cs478.funcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    private final FunCenterService.Stub mBinder = new FunCenterService.Stub() {
//        @Override
//        public byte[] getPicture(int pictureNumber) throws RemoteException {
//            // TODO: Implement method to return the requested picture
//            return null;
//        }
//
//        @Override
//        public void playAudio(int audioNumber) throws RemoteException {
//            // TODO: Implement method to play the requested audio clip
//        }
//
//        @Override
//        public void pauseAudio() throws RemoteException {
//            // TODO: Implement method to pause the audio playback
//        }
//
//        @Override
//        public void resumeAudio() throws RemoteException {
//            // TODO: Implement method to resume the audio playback
//        }
//
//        @Override
//        public void stopAudio() throws RemoteException {
//            // TODO: Implement method to stop the audio playback
//        }
//    };
//    private boolean mBound;
//    private FunCenterService mService;
//
//    private ServiceConnection mConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            mService = FunCenterService.Stub.asInterface(service);
//            mBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            mService = null;
//            mBound = false;
//        }
//    };
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.example.funcenter", "com.example.funcenter.FunCenterService"));
//        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mBound) {
//            unbindService(mConnection);
//            mBound = false;
//        }
//    }
}