package com.developerhaoz.androidtrainingdemo;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import rx.functions.Action1;

public class ContentProviderActivity extends AppCompatActivity {

    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        final RxPermissions rxPermissions = new RxPermissions(this);
//        mBtnTest = (Button) findViewById(R.id.content_btn_test);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Action1<Boolean>() {
                            @Override
                            public void call(Boolean aBoolean) {
                                if(aBoolean){
                                    Matisse.from(ContentProviderActivity.this)
                                            .choose(MimeType.allOf())
                                            .countable(true)
                                            .maxSelectable(9)
                                            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                            .thumbnailScale(0.85f)
                                            .imageEngine(new GlideEngine())
                                            .forResult(1);
                                }else{
                                    Toast.makeText(ContentProviderActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });




    }

}












