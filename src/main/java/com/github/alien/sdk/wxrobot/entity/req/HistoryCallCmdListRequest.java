package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsPageWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.res.HistoryCallCmdListResponse;

import java.util.Map;

/**
 * 指令消息查询请求
 * <br/>
 *
 * @author alien at 2024/3/19 15:44
 */
public class HistoryCallCmdListRequest extends AbsPageWorktoolRequest<HistoryCallCmdListResponse> {
    /**
     * 单聊/群聊名或备注名
     */
    private String messageId;

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String getRequestPath() {
        return "/wework/listRawMessage";
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> queryParams = super.getQueryParams();
        queryParams.put("messageId", messageId);
        return queryParams;
    }
}
