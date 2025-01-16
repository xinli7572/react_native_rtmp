# React Native RTMP

This repository demonstrates how to integrate and use RTMP (Real-Time Messaging Protocol) streaming in React Native applications. The project enables streaming of audio and video to an RTMP server using React Native.

## Features

- **RTMP Streaming**: Stream video and audio to any RTMP server (e.g., YouTube, Twitch, custom RTMP servers).
- **React Native Integration**: Fully integrates RTMP functionality into React Native applications.
- **Cross-Platform**: Supports both Android and iOS platforms.

## Getting Started

### 1. Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/xinli7572/react_native_rtmp.git
```

### 2. Set Up React Native Environment
To start working with React Native, make sure that you have the following setup:

- Install Node.js: Download and install Node.js from here.
- Install React Native CLI: If you don't have React Native CLI installed, you can install it globally by running:
```bash
npm install -g react-native-cli
```

- Install Android Studio: For Android development, download and install Android Studio.

### 3. Install Dependencies
Install the necessary dependencies for the project:

```bash
npm install
```
### 4. Configure RTMP URL
Set the RTMP server URL in your React Native code where you want to stream the media. You can do this by adding the RTMP URL in your App.js or any other component that handles the stream:

```bash
const rtmpUrl = "rtmp://your.server.url/live/streamKey";
```
Replace your.server.url with the RTMP server address, and streamKey with your stream key.

### 5. Build and Run the Project
To build and run the project:

Connect Your Device: Connect an Android or iOS device (or use an emulator).
Build for Android:
```bash
react-native run-android
```

Once the app is launched, it will start capturing video from the camera and stream it to the RTMP server.


## Code Overview
### App.js
App.js is the entry point for the React Native application. It is responsible for:

- Initializing the RTMP stream.
- Setting up camera access to capture video and audio.
- Sending the captured media to the RTMP server.
### RTMP Integration
This project integrates RTMP streaming functionality using native modules in React Native. It provides an interface to start, stop, and manage the RTMP stream using the camera.
```
VideoPresenter.getInstance().startReadVideo(url_, 4, 2, WIDTH, HEIGHT);
```

### Android native Integration
### 1：react 
 react_native_rtmp/screens/WelcomeScreen.js
```
<MyImageViews style={styles.image} imageUrls={url} param={msg} />
```
### 2：android native
 react_native_rtmp/android/app/src/main/java/com/react_tst/newarchitecture/MyImageView.java
```
VideoPresenter.getInstance().startReadVideo(url_, 4, 2, WIDTH, HEIGHT);
```
### 3：registration
 react_native_rtmp/android/app/src/main/java/com/react_tst/MainApplication.java
```
 packages.add(new MyAppPackage());
```


### Example Usage
Here’s a basic example of how to stream video to an RTMP server:

```bash
import React, { useState } from 'react';
import { View, Button } from 'react-native';
import RtmpStream from 'react-native-rtmp-stream';

const App = () => {
  const [isStreaming, setIsStreaming] = useState(false);
  const rtmpUrl = "rtmp://your.server.url/live/streamKey";

  const startStreaming = () => {
    RtmpStream.start(rtmpUrl);
    setIsStreaming(true);
  };

  const stopStreaming = () => {
    RtmpStream.stop();
    setIsStreaming(false);
  };

  return (
    <View>
      <Button 
        title={isStreaming ? "Stop Streaming" : "Start Streaming"} 
        onPress={isStreaming ? stopStreaming : startStreaming} 
      />
    </View>
  );
};

export default App;

```
### In this example:

RtmpStream.start(rtmpUrl) starts the RTMP stream to the provided URL.
RtmpStream.stop() stops the stream.

### Customization
Use a Different RTMP Server
You can use any RTMP server for your stream. Some popular options include:

- YouTube: Use the RTMP URL provided by YouTube for live streaming.
- Twitch: Use the RTMP URL from your Twitch account.
- Custom RTMP Server: If you have a custom RTMP server, simply replace the rtmpUrl in the code with your server's URL and stream key.
### Modify Streaming Quality
You can adjust the streaming quality (e.g., resolution, bitrate) by modifying the settings in the RtmpStream module (refer to the module documentation for more details on supported parameters).

### Technologies Used
- React Native: A framework for building mobile apps using JavaScript and React.
- RTMP: A protocol for streaming audio and video in real time.
- react-native-rtmp-stream: A React Native library for integrating RTMP streaming functionality.
- Node.js: A JavaScript runtime used for managing dependencies and running build scripts.
Contributions
Feel free to fork this repository and contribute! You can:

Fix bugs or improve performance.
Add new features or enhancements.
Improve documentation or the user interface.


https://github.com/user-attachments/assets/aec61934-0f0f-4d8d-bad3-ef2f83c77291
