<H1 align="center">
    <a href="./">WorkTool Java SDK</a>
</H1>

<p align="center">
<a href="https://github.com/MartyAlien/worktool-robot-sdk/releases"><img alt="GitHub release" src="https://img.shields.io/github/release/MartyAlien/worktool-robot-sdk.svg?style=flat-square&include_prereleases" /></a>
<a href="https://github.com/MartyAlien/worktool-robot-sdk/commits"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/MartyAlien/worktool-robot-sdk.svg?style=flat-square" /></a>
<a href="https://github.com/MartyAlien/worktool-robot-sdk/actions/workflows/workflow.yml"><img alt="Build JAR File" src="https://github.com/MartyAlien/worktool-robot-sdk/actions/workflows/workflow.yml/badge.svg?style=flat-square" /></a>
<br />
<a href="/"><img src="https://img.shields.io/github/downloads/MartyAlien/worktool-robot-sdk/total?color=1f6feb&label=Downloads" /></a>
<a href="/"><img src="https://img.shields.io/github/stars/MartyAlien/worktool-robot-sdk?color=#219241" /></a>
<br />
<a href="https://github.com/MartyAlien/worktool-robot-sdk/issues">Issues</a>
<a href="mailto:libai.ace@gmail.com">邮箱</a>
<br />
<span style="font-weight: bolder;color: orange;border-bottom: 1px solid"> 特别说明：非官方出版，纯属个人开发，欢迎MR </span>
</p>
<hr/>

## 1. 简介
[请跳转详情](https://worktool.apifox.cn/)

## 2. 快速使用

### 2.1 添加Maven坐标
> 暂未发布至Maven中央仓库，可自行下载源码编译

```xml
<dependency>
    <groupId>com.github.alien.sdk.wxrobot</groupId>
    <artifactId>worktool-robot-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
```
### 2.2 实例化一个机器人

```java
// import ...
public class Test {
    public static void main(String[] args) throws IOException {
        WorktoolClient worktoolClient = new WorktoolClient("xxxxx");
    }
}
```

### 2.3 使用机器人

#### 2.3.1 发送文本消息

```java
// import ...
public class Test {
    public static void main(String[] args) throws IOException {
        WorktoolClient worktoolClient = new WorktoolClient("xxxxx");
        testSendMsg(worktoolClient);
    }

    private static void testSendMsg(WorktoolClient worktoolClient) {
        SendMessageCmdRequest sendMessageCmdRequest = new SendMessageCmdRequest();
        List<SendMessageCmdRequest.Detail> list = new ArrayList<>();
        SendMessageCmdRequest.Detail detail = new SendMessageCmdRequest.Detail();
        detail.setTitleList("XX群","XX好友");
        detail.setReceivedContent("hello world");
        detail.setAtList(SendMessageCmdRequest.Detail.AT_ALL);
        sendMessageCmdRequest.getList().add(detail);

        BaseCmdWorktoolResponse callback = worktoolClient.callback(sendMessageCmdRequest);
        System.out.println(JSON.toJSONString(sendMessageCmdRequest.getBody()));
        System.out.println(JSON.toJSONString(callback));
    }
}
```

#### 2.3.2 清空指令

```java
// import ...
public class Test {
    public static void main(String[] args) throws IOException {
        WorktoolClient worktoolClient = new WorktoolClient("xxxxx");
        testClearCmd(worktoolClient);
    }

    private static void testClearCmd(WorktoolClient worktoolClient) {
        BaseCmdWorktoolResponse callback = worktoolClient.callback(new ClearCmdRequest());
        System.out.println(JSON.toJSONString(new ClearCmdRequest()));
        System.out.println(JSON.toJSONString(callback));
    }
}
```

> 持续更新中...
> 具体调用方式，参考：`src/test/java/WorktoolTest.java`
