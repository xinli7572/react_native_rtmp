package com.react_tst.newarchitecture;


import android.graphics.Bitmap;

import com.example.videolibrary.VideoPresenter;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MyImageViewManager extends SimpleViewManager<MyImageView> {
    public static final String REACT_CLASS = "MyImageView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected MyImageView createViewInstance(ThemedReactContext reactContext) {
        return new MyImageView(reactContext);
    }

    @ReactProp(name = "imageUrls")
    public void setImageUrl(MyImageView view, String url) {
        view.setImageUrls(url);

    }

    @ReactProp(name = "param")
    public void setParam(MyImageView view, boolean param) {
        view.setParam(param);
    }


}

