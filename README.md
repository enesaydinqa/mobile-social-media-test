# com.appium.mobile-social-media-test

# Operator
- MOBILY
- STC
- ZAIN_KSA

# App Name
- INSTAGRAM
- TWITTER
- SNAPCHAT

# VM Options
-Dfirst.device.uid=DEVICE_UID
-Dsecond.device.uid=DEVICE_UID (optional)
-Doperator=OPERATOR_NAME
-Dtest.app.prop=WHATSAPP
-Dtest.result.path=REPORT_PATH
-Dmultiple.device.test=true/false
-Dtest.app.prop=TWITTER

-- For Snapchat
-Dsnaphat.story.timeout=60 (optional)

-- For LINE
-Dline.sender.display.name=DATA
-Dline.receiver.display.name=DATA


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
-iki hesaptada yalnızca bir arkadas/user ekli olmalıdır
-Önceden kullanıcılar her iki hesapta da eklenmelidir

#WHATSAPP
-Log in ve logout işlemleri yapmaz
-iki hesaptada yalnızca bir arkadas/user ekli olmalıdır