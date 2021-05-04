# AutoRestarter
Auto Server Restart Plugin. Worked with **[[theo5970](https://github.com/theo5970)]**

# CURRENT TODO LIST :

- Making config.yml (Current ongoing progress on private repo!)
 
# KO

## 이 플러그인에 대하여

이 플러그인은 오전 12마다 자동으로 서버를 **꺼주는** 플러그인입니다. GCP와 같은 24시간 구동이 필요한 서버를 위해 제작을 하였습니다.

플러그인 이름은 자동 재시작해주는 플러그인이지만, 사실 코드 내부에도 `Bukkit.shutdown()`이 사용되어 있습니다. (그 이유는 잠시 후에 설명할게요~)

## 플러그인 사용법

1. [[Releases](https://github.com/qogusdn1017/AutoRestarter/releases)]에 가서 AutoRestarter 최신버전을 받아주세요.

2. [[Paper](https://papermc.io/downloads)]서버를 다운받아 적어도 한번 이상은 실행해주세요. (1.13.2 - 1.16.4)

3. 플러그인을 서버 디렉터리 내부의 `plugins`폴더에 넣어주세요.

4. 서버를 다시 구동하시면 자동으로 적용됩니다.

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

2. Download [[Paper](https://papermc.io/downloads)] Server and run at least once. (1.13.2 - 1.16.4.)

3. Put the plugin in the `plugins` folder in the server directory.

4. Restart the server and you're good to go.

## Precautions

The time which plugin restarts is on **your computer's time config.**

On Windows, you can change it from `Settings -> Time and Language`.

On Linux (Debian, Ubuntu), you can change it by typing `dpkg-reconfigure tzdata` and select your timezone.

### Why I didn't configured full restart :

If I configured full restart, Windows will works fine with no problems.

However, on Linux CLI Environments such as GCP has some problems. (Server restarts but you cannot use console.)

So, to avoid these bugs as much as possible, I made it like this.

---

## 빌드 / BUILD

> `./gradlew clean shadowjar`

---

#### Contacts

Normal : qogusdn1017@naver.com

Works : qogusdn1017@baehyeonwoo.works
