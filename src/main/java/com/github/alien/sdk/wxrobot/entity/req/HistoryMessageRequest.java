package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsPageWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.res.HistoryMessageResponse;

import java.util.Map;

/**
 * 历史消息列表查询
 * <br/>
 *
 * @author alien at 2024/3/19 15:44
 */
public class HistoryMessageRequest extends AbsPageWorktoolRequest<HistoryMessageResponse> {
    /**
     * 单聊/群聊名或备注名
     */
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getRequestPath() {
        return "/robot/wework/message";
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> queryParams = super.getQueryParams();
        queryParams.put("title", title);
        return queryParams;
    }
}
