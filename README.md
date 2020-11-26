# AutoRestarter
Auto Server Restart Plugin. Worked with **[[theo5970](https://github.com/theo5970)]**

# CURRENT TODO LIST :

- Making config.yml
 
# KO

## 이 플러그인에 대하여

이 플러그인은 오전 12마다 자동으로 서버를 **꺼주는** 플러그인입니다. GCP와 같은 24시간 구동이 필요한 서버를 위해 제작을 하였습니다.

플러그인 이름은 자동 재시작해주는 플러그인이지만, 사실 코드 내부에도 `Bukkit.shutdown()`이 사용되어 있습니다. (그 이유는 잠시 후에 설명할게요~)

## 플러그인 사용법

1. [[Releases](https://github.com/qogusdn1017/AutoRestarter/releases)]에 가서 AutoRestarter 최신버전을 받아주세요.

2. Bukkit을 사용하셔도 좋으나, 가급적 [[Paper](https://papermc.io/downloads)]서버를 다운받아주세요. (개발된 버전은 1.16.4 기준입니다.)

---

Windows 사용자들은 이 부분을 봐주세요! :

Win - 3. 서버 디렉터리 안에서 오른쪽 마우스 클릭 (우클릭)후 새 텍스트 문서를 만들어주세요.

Win - 4. 새 텍스트 문서를 Start.bat으로 바꾸어주세요. **(확장명까지 바꾸어 주셔야 합니다!)**

Win - 5. Start.bat을 우클릭하여 편집을 눌러주세요.

Win - 6. 아래 내용과 같이 명령을 적어주세요.

```bat
@echo off
java -jar -Xms1024M -Xmx1024M filename.jar --nogui
.\Start.bat
```

Win - 7. 파일을 저장하시고 서버를 구동하시어 파일들이 생성 될 때 까지 기다려주세요.

Win - 8. 플러그인을 서버 디렉터리 내부의 `plugins`폴더에 넣어주세요.

Win - 9. 서버를 다시 구동하시면 자동으로 적용됩니다.

---

Linux (Debian, Ubuntu) 사용자들은 이 부분을 봐주세요! :

**CLI 기준으로 작성되었습니다.**

Lin - 3. 서버 디렉터리 내에서 원하시는 에디터를 열어주세요. (개인적으로는 vim이 편하게 느껴집니다.)

Lin - 4. 아래 내용과 같이 명령을 적어주세요.

```shell
java -jar -Xms1024M -Xmx1024M filename.jar --nogui
.\Start.sh
```

Lin - 5. Start.sh로 파일을 저장하시고 서버를 구동하시어 파일들이 생성 될 때 까지 기다려주세요.

Lin - 6. 플러그인을 서버 디렉터리 내부의 `plugins`폴더에 넣어주세요.

Lin - 7. 서버를 다시 구동하시면 자동으로 적용됩니다.

## 주의 사항

이 플러그인의 코드에 의하여 재시작 되는 시간은 **컴퓨터 자체에 설정된 시간대로 재시작됩니다.**

Windows의 경우, `설정 -> 시간 및 언어`에 들어가 설정이 가능합니다.

Linux (Debian, Ubuntu)의 경우, `dpkg-reconfigure tzdata`를 사용해 시간대를 원하시는대로 바꿔주시면 됩니다.

### 완전히 자동 재시작을 사용 안한 이유 :

완전히 자동 재시작을 설정하면 Windows는 아무 문제 없이 잘 작동이 될겁니다.

하지만 GCP와 같은 Linux CLI환경에서는 버그가 발생합니다. (서버는 재시작하는데 콘솔은 안보임)

따라서 이러한 버그를 최대한 방지하고자 이렇게 만들었습니다.

---

# EN

## ABOUT THIS PLUGIN

This plugin is a plugin that automatically **turns off** the server every 12 am. It was created for servers that require 24-hour operation such as GCP.

The name of the plugin is a plugin that automatically restarts, but actually `Bukkit.shutdown()` is used inside the code. (I'll explain the reason in a moment~)

## HOW TO USE THIS PLUGIN

1. Download the Latest version of AutoRestarter at [[Releases](https://github.com/qogusdn1017/AutoRestarter/releases)].

2. You can use bukkit, but I recommend using [[Paper](https://papermc.io/downloads)] Server. (Developed version is 1.16.4.)

---

If you're a Windows user, please see this guide! :

Win - 3. Right click in the server directory and make a new text file.

Win - 4. Change the new text file to Start.bat. **(You also need to change the extension!)**

Win - 5. Right click the Start.bat and click Edit.

Win - 6. Write the command like this :

```bat
@echo off
java -jar -Xms1024M -Xmx1024M filename.jar --nogui
.\Start.bat
```

Win - 7. Save the file, start the server, and wait for the files to be created.

Win - 8. Put the plugin in the `plugins` folder in the server directory.

Win - 9. Restart the server and you're good to go.

---

If you're a Linux user(Debian, Ubuntu), please see this guide! :

**BASED ON THE CLI.**

Lin - 3. Open the editor what you use. (Personally, vim feels comfortable.)

Lin - 4. Write the command like this :

```shell
java -jar -Xms1024M -Xmx1024M filename.jar --nogui
.\Start.sh
```

Lin - 5. Save the file as Start.sh, start the server, and wait for the files to be created.

Lin - 6. Put the plugin in the `plugins` folder in the server directory.

Lin - 7. Restart the server and you're good to go.

## Precautions

The time which plugin restarts is on **your computer's time config.**

On Windows, you can change it from `Settings -> Time and Language`.

On Linux (Debian, Ubuntu), you can change it by typing `dpkg-reconfigure tzdata` and select your timezone.

### Why I didn't configured full restart :

If I configured full restart, Windows will works fine with no problems.

However, on Linux CLI Environments such as GCP has some problems. (Server restarts but you cannot use console.)

So, to avoid these bugs as much as possible, I made it like this.

---

## BUILD

> Please use `./gradlew clean shadowJar` to build.

---

#### Contacts

Normal : qogusdn1017@naver.com

Works : qogusdn1017@baehyeonwoo.works
