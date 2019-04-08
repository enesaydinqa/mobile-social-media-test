# com.appium.mobile-social-media-test

# Operator
- Mobily
- STC
- Zain

# App Name
- INSTAGRAM

# Profiles
- STCInstagram
- MobilyInstagram
- ZainInstagram

<--------------------------------------->

# VM Options
-Dtest.app.prop=APP_NAME
-Doperator=OPERATOR_NAME
-DtestResultPath=REPORT_PATH

# Appium Server
appium --address 127.0.0.1 --port 5555 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5556 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5557 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5558 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5559 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5560 --session-override --command-timeout 6000000


# Example

mvn clean install site -Dtest.app.prop="INSTAGRAM" -Doperator="STC" -P "STCInstagram"
mvn clean install site -Dtest.app.prop="INSTAGRAM" -Doperator="Mobily" -P "MobilyInstagram"
mvn clean install site -Dtest.app.prop="INSTAGRAM" -Doperator="Zain" -P "ZainInstagram"