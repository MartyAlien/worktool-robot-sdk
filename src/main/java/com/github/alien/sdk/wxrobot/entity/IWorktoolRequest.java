package com.github.alien.sdk.wxrobot.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础请求类
 * <br/>
 *
 * @author alien at 2024/3/19 13:59
 */
public interface IWorktoolRequest extends Serializable {
    /**
     * 获取请求地址
     *
     * @return
     */
    default String getBaseUrl() {
        return "https://api.worktool.ymdyes.cn";
    }

    /**
     * 获取请求路径
     *
     * @return
     */
    String getRequestPath();

    /**
     * 获取QUERY请求参数
     *
     * @return
     */
    default Map<String, String> getQueryParams() {
        return new HashMap<>();
    }

    /**
     * 获取请求体
     *
     * @return
     */
    default Object getBody() {
        return null;
    }

    /**
     * 获取请求方式
     *
     * @return
     */
    Method getMethod();

    /**
     * 获取返回类型
     *
     * @param <T>
     * @return
     */
    <T> Class<T> getResponseType();

    enum Method {
        GET, POST, PUT, DELETE
    }
}
