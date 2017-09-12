package com.developerhaoz.androidtrainingdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

/**
 * 有关绘制基础的 Activity
 *
 * Created by developerHaoz on 2017/9/12.
 */

public class DrawBaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_base);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.draw_base_ll);
        MyView myView = new MyView(this);
        linearLayout.addView(myView, 800, 800);
    }
}



























