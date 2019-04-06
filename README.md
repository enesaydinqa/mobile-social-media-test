# mobile-social-media-test

-Dandroid.device.mobile.one=SAMSUNG_S7
-Dandroid.device.mobile.second=SAMSUNG_NOTE_4
-Dtest.app.prop=INSTAGRAM


appium --address 127.0.0.1 --port 5555 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5050 --session-override --command-timeout 6000000
