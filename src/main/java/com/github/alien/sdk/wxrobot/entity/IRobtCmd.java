package com.github.alien.sdk.wxrobot.entity;

import java.io.Serializable;

/**
 * 基础指令
 * <br/>
 *
 * @author alien at 2024/3/20 15:56
 */
public interface IRobtCmd extends Serializable {
    /**
     * 指令集
     */
    long[] INSTRUCTION_ARR = {203, 206, 219, 304, 213, 220, 207, 218, 205, 208, 211, 209};
    /**
     * 指令类型
     * @return
     */
    long getType();
}
