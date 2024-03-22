package com.github.alien.sdk.wxrobot.entity.data;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史回调日志数据
 * <br/>
 *
 * @author alien at 2024/3/22 9:35
 */
public class HistoryQaLogData implements Serializable {
    private String answer;
    private Boolean atMe;
    private String groupName;
    private Long openThirdParty;
    private String question;
    private String rawSpoken;
    private String receivedName;
    private String robotId;
    private Long roomType;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    private Long textType;
    private Number timeCost;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getAtMe() {
        return atMe;
    }

    public void setAtMe(Boolean atMe) {
        this.atMe = atMe;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getOpenThirdParty() {
        return openThirdParty;
    }

    public void setOpenThirdParty(Long openThirdParty) {
        this.openThirdParty = openThirdParty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRawSpoken() {
        return rawSpoken;
    }

    public void setRawSpoken(String rawSpoken) {
        this.rawSpoken = rawSpoken;
    }

    public String getReceivedName() {
        return receivedName;
    }

    public void setReceivedName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public Long getRoomType() {
        return roomType;
    }

    public void setRoomType(Long roomType) {
        this.roomType = roomType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getTextType() {
        return textType;
    }

    public void setTextType(Long textType) {
        this.textType = textType;
    }

    public Number getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Number timeCost) {
        this.timeCost = timeCost;
    }
}
