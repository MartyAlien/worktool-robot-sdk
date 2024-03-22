# Worktool 机器人Java SDK
## 1. 简介
[请跳转详情](https://worktool.apifox.cn/)

## 2. 快速使用

### 2.1 添加Maven坐标

```xml
<dependency>
    <groupId>com.github.alien.sdk.wxrobot</groupId>
    <artifactId>worktool-robot-sdk</artifactId>
    <version>1.0.0</version>
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
