# mobile-social-media-test

# Operator
- Mobily
- STC
- Zain

# App Name
- INSTAGRAM

# Profiles
- STC_INSTAGRAM
- Mobily_INSTAGRAM
- Zain_INSTAGRAM

<--------------------------------------->

-Dtest.app.prop=APP_NAME
-Doperator=OPERATOR_NAME

appium --address 127.0.0.1 --port 5555 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5556 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5557 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5558 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5559 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5560 --session-override --command-timeout 6000000


#Example

mvn clean install site -Dtest.app.prop=INSTAGRAM -Doperator=STC -P "STC_INSTAGRAM"