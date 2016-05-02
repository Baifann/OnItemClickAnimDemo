package com.baifan.onitemclicklistviewanimdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by baifan on 16/5/2.
 */
public class SecondActivity extends Activity {
    private ImageView mImgSec;
    private String mPhotoWebUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        initEvents();
    }

    private void initViews() {
        mImgSec = (ImageView) findViewById(R.id.img_second);
    }

    private void initEvents() {
        getDataFromIntent();

        Glide.with(this).load(mPhotoWebUrl).into(mImgSec);
    }

    private void getDataFromIntent() {
        mPhotoWebUrl = getIntent().getStringExtra("photoUrl");
    }
}
