package com.developerhaoz.androidtrainingdemo.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developerhaoz.androidtrainingdemo.R;

public class DownloadActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnStartDownload;
    private Button mBtnPauseDownload;
    private Button mBtnCancelDownload;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.download_start_download:
                break;
            case R.id.download_pause_download:
                break;
            case R.id.download_cancel_download:
                break;
            default:break;
        }
    }
}
