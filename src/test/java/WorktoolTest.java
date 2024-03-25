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

    @After
    public void tearDown() {
        worktoolClient = null;
    }
}
