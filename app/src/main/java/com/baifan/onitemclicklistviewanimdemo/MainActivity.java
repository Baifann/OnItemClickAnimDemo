package com.baifan.onitemclicklistviewanimdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnClickImageListener{
    private ListView mLv;

    private List<String> mPhotoList = new ArrayList<>();

    private MyAdapter mAdapter;

    private ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initEvents() {
        getResourceToSetPhtotoList();

        mAdapter = new MyAdapter(this);
        mLv.setAdapter(mAdapter);
        mAdapter.setList(mPhotoList);
        mAdapter.setOnClickImageListener(this);
    }

    private void initViews() {
        mLv = (ListView) findViewById(R.id.lv);
    }

    private void getResourceToSetPhtotoList() {
        String[] photosArray = getResources().getStringArray(R.array.photos);
        mPhotoList = Arrays.asList(photosArray);
        Log.i("hehehe", "list:" + mPhotoList.toString());
    }

    @Override
    public void onImageClick() {

    }
}
