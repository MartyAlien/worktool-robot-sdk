import com.alibaba.fastjson.JSON;
import com.github.alien.sdk.wxrobot.IWorktoolClient;
import com.github.alien.sdk.wxrobot.client.WorktoolClient;
import com.github.alien.sdk.wxrobot.entity.req.*;
import com.github.alien.sdk.wxrobot.entity.res.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TEST
 * <br/>
 *
 * @author alien at 2024/3/21 9:51
 */
public class WorktoolTest {
    public static final Logger log = Logger.getLogger(WorktoolTest.class.getName());

    private IWorktoolClient worktoolClient;

    @Before
    public void setUp() {
        worktoolClient = new WorktoolClient("worktool1");
    }

    @Test
    public void testHistoryCmdExecResult() {
        HistoryCmdExecResultRequest request = new HistoryCmdExecResultRequest();
        HistoryCmdExecResultResponse response = worktoolClient.call(request);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testHistoryMessage() {
        HistoryMessageRequest historyMessageRequest = new HistoryMessageRequest();
        historyMessageRequest.setPage(1);
        historyMessageRequest.setSize(20);
        historyMessageRequest.setSort("create_time,desc");
        HistoryMessageResponse response = worktoolClient.call(historyMessageRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testSendMsg() {
        SendMessageCmdRequest sendMessageCmdRequest = new SendMessageCmdRequest();
        List<SendMessageCmdRequest.Detail> list = new ArrayList<>();
        SendMessageCmdRequest.Detail detail = new SendMessageCmdRequest.Detail();
        detail.setTitleList("Test01");
        detail.setReceivedContent("hello world!");
        detail.setAtList(SendMessageCmdRequest.Detail.AT_ALL);
        sendMessageCmdRequest.getList().add(detail);
        BaseCmdWorktoolResponse response = worktoolClient.call(sendMessageCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testCreateGroup() {
        CreateCustomerGroupCmdRequest createCustomerGroupCmdRequest = new CreateCustomerGroupCmdRequest();
        CreateCustomerGroupCmdRequest.Detail detail = new CreateCustomerGroupCmdRequest.Detail("Test01");
        detail.setSelectList("小明");
        createCustomerGroupCmdRequest.getList().add(detail);
        BaseCmdWorktoolResponse response = worktoolClient.call(createCustomerGroupCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testDissolveGroup() {
        BaseCmdWorktoolResponse response = worktoolClient.call(new DissolveGroupCmdRequest("Test01"));
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testListCallCmd() {
        HistoryCallCmdListRequest historyCallCmdListRequest = new HistoryCallCmdListRequest();
        HistoryCallCmdListResponse response = worktoolClient.call(historyCallCmdListRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testClearCmd() {
        BaseCmdWorktoolResponse response = worktoolClient.call(new ClearCmdRequest());
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testHistoryQaLog() {
        HistoryQaLogRequest historyQaLogRequest = new HistoryQaLogRequest();
        historyQaLogRequest.setPage(1);
        historyQaLogRequest.setSize(20);
        HistoryQaLogResponse response = worktoolClient.call(historyQaLogRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testBatchCallCmd(){
        // 清空所有指令
        ClearCmdRequest.Detail clearCmd = new ClearCmdRequest.Detail();
        // 创建群
        CreateCustomerGroupCmdRequest.Detail createGroupCmd = new CreateCustomerGroupCmdRequest.Detail("Test001");
        createGroupCmd.setSelectList("小明");
        createGroupCmd.setGroupRemark("Test001");
        // 群内发送消息
        SendMessageCmdRequest.Detail sendMsgCmd = new SendMessageCmdRequest.Detail();
        sendMsgCmd.setTitleList("Test001");
        sendMsgCmd.setReceivedContent("hello world!");
        sendMsgCmd.setAtList(SendMessageCmdRequest.Detail.AT_ALL);

        BatchCallCmdRequest batchCallCmdRequest = new BatchCallCmdRequest(clearCmd, createGroupCmd, sendMsgCmd);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(batchCallCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(batchCallCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testAddFriendByPhone(){
        AddFriendByPhoneCmdRequest addFriendByPhoneCmdRequest = new AddFriendByPhoneCmdRequest("10089");
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(addFriendByPhoneCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(addFriendByPhoneCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }
    
    @Test
    public void testAddFriendFromCustomerGroup(){
        AddFriendFromCustomerGroupCmdRequest addFriendFromCustomerGroupCmdRequest = 
                new AddFriendFromCustomerGroupCmdRequest("Test001", "小明","小李");
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(addFriendFromCustomerGroupCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(addFriendFromCustomerGroupCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testModifyCustomGroup(){
        ModifyCustomGroupCmdRequest.Detail detail = new ModifyCustomGroupCmdRequest.Detail("Test001");
        detail.setNewGroupAnnouncement("今天大促，满300减100");
        detail.setRemoveList("小明");
        detail.setSelectList("小李");
        detail.setShowMessageHistory(Boolean.TRUE);

        ModifyCustomGroupCmdRequest modifyCustomGroupCmdRequest = new ModifyCustomGroupCmdRequest(detail);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(modifyCustomGroupCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(modifyCustomGroupCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testSendAttachmentCmd(){
        SendAttachmentCmdRequest.Detail detail = new SendAttachmentCmdRequest.Detail(SendAttachmentCmdRequest.FileType.IMAGE
                , "https://cdn.asrtts.cn/static/image/logo3_180_raw.png"
                , "test.png"
                , "小明");
        detail.setExtraText("给你发了一个图片");
        SendAttachmentCmdRequest sendAttachmentCmdRequest = new SendAttachmentCmdRequest(detail);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(sendAttachmentCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(sendAttachmentCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testRelayMessageCmd(){
        RelayMessageCmdRequest.Detail detail = new RelayMessageCmdRequest.Detail();
        // 附加留言
        detail.setExtraText("来自一条转发消息");
        // 转发消息的接收方
        detail.setNameList("小明");
        // 转发前的消息内容
        detail.setOriginalContent("1");
        // 转发前的消息发送方
        detail.setReceivedName("路人甲");
        // 转发群名称
        detail.setTitleList("美团吃货群");
        // 消息类型
        detail.setTextType(RelayMessageCmdRequest.TextType.TEXT);

        RelayMessageCmdRequest relayMessageCmdRequest = new RelayMessageCmdRequest(detail);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(relayMessageCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(relayMessageCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testPushWepanImgCmd(){
        PushWepanImgCmdRequest.Detail detail = new PushWepanImgCmdRequest.Detail("logo2", "小明", "小李");
        PushWepanImgCmdRequest.Detail detail2 = new PushWepanImgCmdRequest.Detail("logo2x", "小明x", "小李x");
        PushWepanImgCmdRequest pushWepanImgCmdRequest = new PushWepanImgCmdRequest(detail,detail2);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(pushWepanImgCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(pushWepanImgCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testPushTencentDocCmd(){
        PushTencentDocCmdRequest.Detail detail = new PushTencentDocCmdRequest.Detail("WorkTool用户信息收集表", "小明", "小李");
        PushTencentDocCmdRequest.Detail detail2 = new PushTencentDocCmdRequest.Detail("WorkTool用户信息收集表2", "小明x", "小李x");
        PushTencentDocCmdRequest pushTencentDocCmdRequest = new PushTencentDocCmdRequest(detail,detail2);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(pushTencentDocCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(pushTencentDocCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testPushWepanAttachmentCmd(){
        PushWepanAttachmentCmdRequest.Detail detail = new PushWepanAttachmentCmdRequest.Detail("1", "小明", "小李");
        PushWepanAttachmentCmdRequest.Detail detail2 = new PushWepanAttachmentCmdRequest.Detail("2", "小明x", "小李x");
        PushWepanAttachmentCmdRequest pushTencentDocCmdRequest = new PushWepanAttachmentCmdRequest(detail,detail2);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(pushTencentDocCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(pushTencentDocCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testModifyGroupMember(){
        ModifyGroupMemberMarkCmdRequest.Detail detail = new ModifyGroupMemberMarkCmdRequest.Detail("Test001", "小明", "小李");
        ModifyGroupMemberMarkCmdRequest modifyGroupMemberMarkCmdRequest = new ModifyGroupMemberMarkCmdRequest(detail);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(modifyGroupMemberMarkCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(modifyGroupMemberMarkCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @Test
    public void testAddTodoCmd(){
        AddTodoCmdRequest.Detail detail = new AddTodoCmdRequest.Detail("今天需要打卡", "小李", "小红");
        AddTodoCmdRequest addTodoCmdRequest = new AddTodoCmdRequest(detail);
        log.log(Level.INFO, "request: {0}", JSON.toJSONString(addTodoCmdRequest));
        BaseCmdWorktoolResponse response = worktoolClient.call(addTodoCmdRequest);
        log.log(Level.INFO, "response: {0}", JSON.toJSONString(response));
        Assert.assertNotNull(response);
        Assert.assertEquals("接口未请求成功", Long.valueOf(200), response.getCode());
    }

    @After
    public void tearDown() {
        worktoolClient = null;
    }
}
