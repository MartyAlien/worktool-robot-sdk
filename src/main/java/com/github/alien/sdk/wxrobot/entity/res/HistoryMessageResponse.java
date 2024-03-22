package com.github.alien.sdk.wxrobot.entity.res;

import com.github.alien.sdk.wxrobot.entity.AbsWorktoolResponse;
import com.github.alien.sdk.wxrobot.entity.data.HistoryMessageData;
import com.github.alien.sdk.wxrobot.entity.page.PageInfo;

/**
 * 历史消息列表响应
 * <br/>
 *
 * @author alien at 2024/3/19 16:03
 */
public class HistoryMessageResponse extends AbsWorktoolResponse {
    private PageInfo<HistoryMessageData> data;

    public PageInfo<HistoryMessageData> getData() {
        return data;
    }

    public void setData(PageInfo<HistoryMessageData> data) {
        this.data = data;
    }
}
