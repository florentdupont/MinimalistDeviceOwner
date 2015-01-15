# Minimalist Device Owner for Android 5 (API 21)

An Android sample app used to validate the strange behavior explained at [StackOverflow](http://stackoverflow.com/questions/27931008) where restricted profiles cannot be created once a device owner app is set.

Steps to reproduce : 

* compile the app
* upload the application to your device
* set the application as device owner using dpm command line tool ([more information on this tool...](http://florent-dupont.blogspot.fr/2015/01/android-shell-command-dpm-device-policy.html)).

```
adb shell dpm set-device-owner com.mytest.minimalistdeviceowner/.DeviceAdminRcvr
```

* check that the creation of profile is not available in Settings>Users
* unset the application as device owner by clicking, in the app, on "Unset Device Owner".
* Check that the creation is now available in Settings>Users


