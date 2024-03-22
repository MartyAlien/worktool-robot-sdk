package com.github.alien.sdk.wxrobot.entity;

import java.io.Serializable;

/**
 * 基础响应类
 * <br/>
 *
 * @author alien at 2024/3/19 16:00
 */
public abstract class AbsWorktoolResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long code;
    private String message;

    public Long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
