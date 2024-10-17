package com.react_tst.newarchitecture;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.react_tst.R;

import com.example.videolibrary.VideoPresenter;
import com.squareup.picasso.Picasso;

@SuppressLint("AppCompatCustomView")
public class MyImageView extends ImageView {

    private boolean start = false;
    private String url_ = "";
    private boolean video_status = false; //false: video not start; true: video start

    Bitmap bitmap_png;

    public MyImageView(Context context) {
        super(context);

        bitmap_png = getBitmapFromDrawable(context);
        this.setImageBitmap(bitmap_png);
    }

    public void setImageUrls(String url) {
        url_ = url;
        Log.d("MyNativeModule", "img url = " + url);
    }


    private int WIDTH = 720;
    private int HEIGHT = 400;
    private Bitmap mBitmap = null;

    private void initView() {
        VideoPresenter.getInstance().startReadVideo(url_, 4, 2, WIDTH, HEIGHT);
    }

    private void regVideoCallback(MyImageView view) {
        mBitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_4444);

        VideoPresenter.getInstance().regVideoCallback(new VideoPresenter.IVideoCallback() {
            @Override
            public void onImageShow() {
                showImage(view);
            }
        }, mBitmap);

    }

    private void showImage(MyImageView view) {

        video_status = true;
        runOnUiThread(() -> {
            if (mBitmap != null) {
                view.setImageBitmap(mBitmap);

            }
        });
    }


    public void setParam(boolean param) {

        Log.d("MyNativeModule", "============================" + param);
        start = param;


        if (start == true) {
            if (video_status == false) {
                Log.d("MyNativeModule", "press video start  " + param);

                initView();
                regVideoCallback(this);
            }
        } else {
            if (video_status == true) {

                Log.d("MyNativeModule", "press video stop  " + param);
                VideoPresenter.getInstance().stopReadVideo();
                video_status = false;
            }
        }
    }

    public static Bitmap getBitmapFromDrawable(Context context) {
        // 从资源中获取 Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.page_photo);
        return bitmap;
    }
}
