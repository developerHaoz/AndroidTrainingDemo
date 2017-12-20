package com.developerhaoz.androidtrainingdemo.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.developerhaoz.androidtrainingdemo.R;

public class DownloadActivity extends AppCompatActivity {

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

    }
}
