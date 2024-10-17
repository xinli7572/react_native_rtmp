


### Custom native Android component “MyImageViews" for displaying dynamic video live streams, using the OpenCV Android dynamic library to achieve a playback delay of less than 1 second.

### 1：react 
> react_native_rtmp/screens/WelcomeScreen.js
```
<MyImageViews style={styles.image} imageUrls={url} param={msg} />
```
### 2：android
> react_native_rtmp/android/app/src/main/java/com/react_tst/newarchitecture/MyImageView.java
```
VideoPresenter.getInstance().startReadVideo(url_, 4, 2, WIDTH, HEIGHT);
```

### 3：registration
> react_native_rtmp/android/app/src/main/java/com/react_tst/MainApplication.java
```
 packages.add(new MyAppPackage());
```

https://github.com/user-attachments/assets/aec61934-0f0f-4d8d-bad3-ef2f83c77291

