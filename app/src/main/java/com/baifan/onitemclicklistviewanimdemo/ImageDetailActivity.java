package com.baifan.onitemclicklistviewanimdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by baifan on 16/4/29.
 */
public class ImageDetailActivity extends Activity {
    private ImageView mImgDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_detail);
        initViews();
        initEvents();
    }

    private void initViews(){
        mImgDetail = (ImageView) findViewById(R.id.img_detail);
    }

    private void initEvents(){

    }

    private void getDataFromIntent(){
        String photoUrlFromIntent = getIntent().getStringExtra("photoUrl");

    }

    private void handleImgDetail(String photoUrl){
        Glide.with(this).load(photoUrl).into(mImgDetail);
    }
}
