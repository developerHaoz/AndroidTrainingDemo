package com.developerhaoz.androidtrainingdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by developerHaoz on 2017/9/11.
 */

public class TestViewActivity extends AppCompatActivity {

    private static final String TAG = "TestViewActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.test_view_ll);
        Log.d(TAG, "onCreate:666 " + linearLayout.getParent());
        Set<Integer> set = new HashSet<>();
        int[] a = new int[12];
        a[1] = 9;
    }
}
