package com.developerhaoz.androidtrainingdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_TAKE_PHOTO = 0;
    private String mCurrentPhotoPath;
    private VideoView mVvShowPhoto;
    private ImageView mIvShowPhoto;
    private static final String TAG = "MainActivity";
    private static final int TAKE_PHOTO_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVvShowPhoto = (VideoView) findViewById(R.id.main_vv_show_photo);
        mIvShowPhoto = (ImageView) findViewById(R.id.main_iv_show_photo);

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        LayoutInflater layoutInflater1 = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        findViewById(R.id.main_btn_start_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeVideoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takeVideoIntent, REQUEST_CODE_TAKE_PHOTO);
                }
            }
        });

    }

    private void getPhotoWithCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            String filename = System.currentTimeMillis() + ".png";
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            mCurrentPhotoPath = file.getAbsolutePath();
            Uri fileUri = FileProvider.getUriForFile(MainActivity.this, "com.developerhaoz.androidtrainingdemo.fileprovider", file);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(takePictureIntent, REQUEST_CODE_TAKE_PHOTO);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_TAKE_PHOTO) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            mIvShowPhoto.setImageBitmap(bitmap);
        }
    }
}



























