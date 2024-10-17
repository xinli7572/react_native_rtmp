package com.react_tst.newarchitecture;


import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class MyNativeModule extends ReactContextBaseJavaModule {
    MyNativeModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "MyNativeModule";
    }

    @ReactMethod
    public void show(String message, Callback callback) {
        // 这里你可以调用原生方法，例如显示一个 Toast
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
        callback.invoke("Message shown: " + message);
    }
}
