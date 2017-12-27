package com.developerhaoz.androidtrainingdemo.download;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.developerhaoz.androidtrainingdemo.R;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

public class DownloadActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnStartDownload;
    private Button mBtnPauseDownload;
    private Button mBtnCancelDownload;

    private DownloadService.DownloadBinder mDownloadBinder;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (DownloadService.DownloadBinder)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        mBtnStartDownload = (Button) findViewById(R.id.download_start_download);
        mBtnPauseDownload = (Button) findViewById(R.id.download_pause_download);
        mBtnCancelDownload = (Button) findViewById(R.id.download_cancel_download);
        mBtnStartDownload.setOnClickListener(this);
        mBtnPauseDownload.setOnClickListener(this);
        mBtnCancelDownload.setOnClickListener(this);
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if(aBoolean){
                        }else{
                            Toast.makeText(DownloadActivity.this, "You Denity", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(mDownloadBinder == null){
            return;
        }
        switch (v.getId()){
            case R.id.download_start_download:
                String url = "https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe";
                mDownloadBinder.startDownload(url);
                break;
            case R.id.download_pause_download:
                System.exit(0);
                mDownloadBinder.pauseDownload();
                break;
            case R.id.download_cancel_download:
                mDownloadBinder.cancelDownload();
                break;
            default:break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
