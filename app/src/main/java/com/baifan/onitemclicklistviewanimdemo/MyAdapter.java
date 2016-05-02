package com.baifan.onitemclicklistviewanimdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baifan on 16/4/29.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> mList = new ArrayList<String>();

    private Context mContext;

    public MyAdapter(Context context) {
        mContext = context;
    }

    public void setList(List<String> photoList) {
        mList = photoList;
        this.notifyDataSetChanged();
    }

    public interface OnClickImageListener {
        void onImageClick();
    }

    private OnClickImageListener mListener;

    public void setOnClickImageListener(OnClickImageListener listener) {
        mListener = listener;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_show_pic, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(mList.get(position)).into(vh.mImg);
        vh.mTvPhotoPath.setText(mList.get(position));

        handleImageClick(vh, position);
        return convertView;
    }

    private void handleImageClick(ViewHolder vh, final int position) {
        vh.mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick();
                }
                lanuch(v, position);
            }
        });
    }

    private void lanuch(View v, int position) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, v, mContext.getString(R.string.transition));
        Intent intent = new Intent(mContext, SecondActivity.class);
        intent.putExtra("photoUrl", mList.get(position));
        ActivityCompat.startActivity((Activity) mContext, intent, compat.toBundle());
    }

    class ViewHolder {
        private ImageView mImg;
        private TextView mTvPhotoPath;

        public ViewHolder(View v) {
            mImg = (ImageView) v.findViewById(R.id.img);
            mTvPhotoPath = (TextView) v.findViewById(R.id.tv_photo_path);
        }
    }
}
