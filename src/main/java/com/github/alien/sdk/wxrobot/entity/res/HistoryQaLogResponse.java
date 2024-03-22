package com.github.alien.sdk.wxrobot.entity.res;

import com.github.alien.sdk.wxrobot.entity.AbsWorktoolResponse;
import com.github.alien.sdk.wxrobot.entity.data.HistoryQaLogData;
import com.github.alien.sdk.wxrobot.entity.page.PageInfo;

/**
 * 历史回调日志响应
 * <br/>
 *
 * @author alien at 2024/3/22 9:34
 */
public class HistoryQaLogResponse extends AbsWorktoolResponse {
    private PageInfo<HistoryQaLogData> data;

    public PageInfo<HistoryQaLogData> getData() {
        return data;
    }

    public void setData(PageInfo<HistoryQaLogData> data) {
        this.data = data;
    }
}
