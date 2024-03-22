package com.github.alien.sdk.wxrobot.entity.data;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 调用指令消息数据
 * <br/>
 *
 * @author alien at 2024/3/19 16:05
 */
public class HistoryCallCmdData implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 机器人ID
     */
    private String robotId;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 指令集
     */
    private String typeList;
    /**
     * 消息发送方IP
     */
    private String ip;
    /**
     * 消息ID
     */
    private String messageId;
    /**
     * apiSend
     */
    private Number apiSend;
    /**
     * body
     */
    private String body;

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Number getApiSend() {
        return apiSend;
    }

    public void setApiSend(Number apiSend) {
        this.apiSend = apiSend;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
