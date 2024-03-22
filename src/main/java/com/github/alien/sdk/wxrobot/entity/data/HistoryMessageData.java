package com.github.alien.sdk.wxrobot.entity.data;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史消息数据
 * <br/>
 *
 * @author alien at 2024/3/19 16:05
 */
public class HistoryMessageData implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 消息内容
     */
    private String itemMsgList;
    /**
     * 消息发送人
     */
    private String nameList;
    /**
     * 唯一标识符
     */
    private String robotId;
    /**
     * 发送方
     */
    private Number sender;
    /**
     * 消息所在群聊或私聊
     */
    private String titleList;
    /**
     * 消息类型
     */
    private Number type;
    /**
     * 工作类型
     */
    private String workType;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getItemMsgList() {
        return itemMsgList;
    }

    public void setItemMsgList(String itemMsgList) {
        this.itemMsgList = itemMsgList;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public Number getSender() {
        return sender;
    }

    public void setSender(Number sender) {
        this.sender = sender;
    }

    public String getTitleList() {
        return titleList;
    }

    public void setTitleList(String titleList) {
        this.titleList = titleList;
    }

    public Number getType() {
        return type;
    }

    public void setType(Number type) {
        this.type = type;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
