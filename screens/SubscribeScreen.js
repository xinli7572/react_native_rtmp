import React from 'react';
import {useState} from 'react';
import {
  Image,
  Pressable,
  StyleSheet,
  Text,
  KeyboardAvoidingView,
  TextInput,
  Alert,
  View,
} from 'react-native';

const SubscribeScreen = () => {
  return (
    <View style={styles.container}>
      <Text>Subscribe to our newsletter for our latest delicious recipes</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
  },
  image: {
    flex: 0.55,
    width: 100,
    height: 100,
  },
  text: {
    width: '80%',
    textAlign: 'center',
    fontWeight: 'bold',
    fontSize: 20,
  },
  inputBox: {
    width: '80%',
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
    fontSize: 16,
    borderRadius: 10,
  },

  activeButton: {
    fontSize: 22,
    padding: 10,
    width: '80%',
    backgroundColor: '#365d32',
    borderRadius: 10,
  },

  inactiveButton: {
    fontSize: 22,
    padding: 10,
    width: '80%',
    backgroundColor: '#aeb0ad',
    borderRadius: 10,
  },
  buttonText: {
    color: 'white',
    textAlign: 'center',
    fontSize: 15,
  },
});
export default SubscribeScreen;
