package com.github.alien.sdk.wxrobot.entity.res;

import com.github.alien.sdk.wxrobot.entity.AbsWorktoolResponse;

/**
 * 基础指令消息响应
 * <br/>
 *
 * @author alien at 2024/3/19 17:26
 */
public class BaseCmdWorktoolResponse extends AbsWorktoolResponse {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
