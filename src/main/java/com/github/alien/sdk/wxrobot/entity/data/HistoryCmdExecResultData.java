package com.github.alien.sdk.wxrobot.entity.data;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史指令执行结果数据
 * <br/>
 *
 * @author alien at 2024/3/21 9:47
 */
public class HistoryCmdExecResultData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long apiSend;
    private String errorReason;
    private String failList;
    private String messageId;
    private String rawMsg;
    private Long rawSuccess;
    private String robotId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date runTime;
    private String successList;
    private Number timeCost;
    private Long type;

    public Long getApiSend() {
        return apiSend;
    }

    public void setApiSend(Long apiSend) {
        this.apiSend = apiSend;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public String getFailList() {
        return failList;
    }

    public void setFailList(String failList) {
        this.failList = failList;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRawMsg() {
        return rawMsg;
    }

    public void setRawMsg(String rawMsg) {
        this.rawMsg = rawMsg;
    }

    public Long getRawSuccess() {
        return rawSuccess;
    }

    public void setRawSuccess(Long rawSuccess) {
        this.rawSuccess = rawSuccess;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    public String getSuccessList() {
        return successList;
    }

    public void setSuccessList(String successList) {
        this.successList = successList;
    }

    public Number getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Number timeCost) {
        this.timeCost = timeCost;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
