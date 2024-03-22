package com.github.alien.sdk.wxrobot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 指令消息请求积累
 * <br/>
 *
 * @author alien at 2024/3/20 10:24
 */
public abstract class AbsCmdWorktoolRequest<T extends IRobtCmd, R extends BaseCmdWorktoolResponse> extends AbsWorktoolRequest<R> {
    private final Integer socketType;
    private final List<T> list;

    public AbsCmdWorktoolRequest() {
        this(new ArrayList<>());
    }

    public AbsCmdWorktoolRequest(List<T> list) {
        this.socketType = 2;
        this.list = list;
    }

    public AbsCmdWorktoolRequest(Integer socketType, List<T> list) {
        this.socketType = socketType == null ? 2 : socketType;
        this.list = list;
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getRequestPath() {
        return "/wework/sendRawMessage";
    }

    @Override
    @JSONField(serialize = false)
    public Object getBody() {
        return this;
    }

    public Integer getSocketType() {
        return socketType;
    }

    public List<T> getList() {
        return list;
    }
}
