package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsPageWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.res.HistoryQaLogResponse;

import java.util.Map;

/**
 * 历史回调日志请求
 * <br/>
 *
 * @author alien at 2024/3/22 9:27
 */
public class HistoryQaLogRequest extends AbsPageWorktoolRequest<HistoryQaLogResponse> {
    private String name;

    @Override
    public String getRequestPath() {
        return "/robot/qaLog/list";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> queryParams = super.getQueryParams();
        queryParams.put("name", name);
        return queryParams;
    }
}
