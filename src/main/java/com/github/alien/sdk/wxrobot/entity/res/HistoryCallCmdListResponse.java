package com.github.alien.sdk.wxrobot.entity.res;

import com.github.alien.sdk.wxrobot.entity.AbsWorktoolResponse;
import com.github.alien.sdk.wxrobot.entity.data.HistoryCallCmdData;
import com.github.alien.sdk.wxrobot.entity.page.PageInfo;

/**
 * 指令消息查询响应
 * <br/>
 *
 * @author alien at 2024/3/19 16:03
 */
public class HistoryCallCmdListResponse extends AbsWorktoolResponse {
    private PageInfo<HistoryCallCmdData> data;

    public PageInfo<HistoryCallCmdData> getData() {
        return data;
    }

    public void setData(PageInfo<HistoryCallCmdData> data) {
        this.data = data;
    }
}
