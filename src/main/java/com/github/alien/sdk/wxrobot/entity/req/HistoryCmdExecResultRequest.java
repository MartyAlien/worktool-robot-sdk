package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsPageWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.res.HistoryCmdExecResultResponse;

import java.util.Map;

/**
 * 历史指令执行结果请求
 * <br/>
 *
 * @author alien at 2024/3/21 9:38
 */
public class HistoryCmdExecResultRequest extends AbsPageWorktoolRequest<HistoryCmdExecResultResponse> {
    /**
     * 指令类型
     */
    private String type;
    /**
     * 指令消息id
     */
    private String messageId;

    @Override
    public String getRequestPath() {
        return "/robot/rawMsg/list";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> queryParams = super.getQueryParams();
        queryParams.put("type", type);
        queryParams.put("messageId", messageId);
        return queryParams;
    }
}
