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
-Dtest.result.path=REPORT_PATH
-Dmultiple.device.test=true/false (opsional) 


# Appium Server
appium --address 127.0.0.1 --port 4723 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5556 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5557 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5558 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5559 --session-override --command-timeout 6000000
appium --address 127.0.0.1 --port 5560 --session-override --command-timeout 6000000

#GIT
- git checkout master (son kodun bulunduğu branch e geçer)
- git pull origin master (git deki güncel kodu local a çeker)
- git checkout YOUR_BRANCH (ilgili branch e geçer)

# KOD YAZILDIKTAN SONRA
- git commit -am "YOUR_COMMIT_MESSAGE"
- git push origin


#SNAPCHAT
-Her girişte login olunur
-Her çıkışta resetlenir

#LINE
-Log in ve log off işlemlerini yapmaz
-Önceden kullanıcılar her iki hesapta da eklenmelidir