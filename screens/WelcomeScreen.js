import React, {useState} from 'react';
import {
  requireNativeComponent,
  NativeModules,
  View,
  Text,
  TextInput,
  Button,
  StyleSheet,
  Dimensions,
  Pressable,
} from 'react-native';

const {width: screenWidth} = Dimensions.get('window'); // 获取设备宽度

const MyImageViews = requireNativeComponent('MyImageView');

const {MyNativeModule} = NativeModules;

const WelcomeScreen = ({navigation}) => {
  // Add welcome screen code here.

  const showMessage = flag => {
    onChangeMsg(flag);
    if (flag) {
      MyNativeModule.show('start video, please wait!', message => {
        console.log(message);
      });
    } else {
      MyNativeModule.show('stop video now!', message => {
        console.log(message);
      });
    }
  };

  const [msg, onChangeMsg] = useState(false);
  const [url, onChangeUrl] = useState(
    'rtmp://ns8.indexforce.com/home/mystream',
  );
  return (
    <View style={styles.container}>
      <View>
        <MyImageViews style={styles.image} imageUrls={url} param={msg} />
      </View>
      <View>
        <TextInput
          style={styles.input}
          value={url}
          onChangeText={onChangeUrl}
        />
      </View>
      <View style={styles.buttons}>
        <Pressable onPress={() => showMessage(true)} style={styles.button}>
          <Text style={styles.buttonText}>start</Text>
        </Pressable>

        <Pressable onPress={() => showMessage(false)} style={styles.button}>
          <Text style={styles.buttonText}>stop</Text>
        </Pressable>
      </View>
    </View>
  );
};

//adb logcat | grep MyNativeModule
const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
  },
  image: {
    width: screenWidth,
    height: 300,
  },
  input: {
    height: 40,
    margin: 12,
    width: screenWidth * 0.7,
    borderWidth: 1,
    padding: 10,
    fontSize: 16,
    borderColor: '#2f65d4',
    backgroundColor: '#fdfdfb',
  },
  text: {
    flex: 0.4,
    width: '60%',
    textAlign: 'center',
    fontWeight: 'bold',
    fontSize: 20,
  },
  button: {
    fontSize: 26,
    padding: 10,
    width: 100,
    backgroundColor: '#2f65d4',
    borderRadius: 5,
    marginLeft: 20,
  },
  buttons: {
    flexDirection: 'row', // 水平放置
    justifyContent: 'space-around', // 在按钮之间分配空间
    alignItems: 'center', // 垂直居中
    padding: 20, // 内边距
  },
  buttonText: {
    color: 'white',
    textAlign: 'center',
    fontSize: 15,
  },
});

export default WelcomeScreen;
