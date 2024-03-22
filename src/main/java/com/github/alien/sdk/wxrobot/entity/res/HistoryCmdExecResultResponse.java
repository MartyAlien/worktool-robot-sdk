package com.github.alien.sdk.wxrobot.entity.res;

import com.github.alien.sdk.wxrobot.entity.AbsWorktoolResponse;
import com.github.alien.sdk.wxrobot.entity.data.HistoryCmdExecResultData;

import java.util.List;

/**
 * 历史指令执行结果响应
 * <br/>
 *
 * @author alien at 2024/3/21 9:40
 */
public class HistoryCmdExecResultResponse extends AbsWorktoolResponse {
    private List<HistoryCmdExecResultData> data;

    public List<HistoryCmdExecResultData> getData() {
        return data;
    }

    public void setData(List<HistoryCmdExecResultData> data) {
        this.data = data;
    }
}
