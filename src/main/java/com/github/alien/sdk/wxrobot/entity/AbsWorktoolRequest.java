package com.github.alien.sdk.wxrobot.entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象请求
 * <br/>
 *
 * @author alien at 2024/3/19 14:12
 */
public abstract class AbsWorktoolRequest<T> implements IWorktoolRequest {
    private final Map<String, String> queryParams;

    protected AbsWorktoolRequest() {
        this.queryParams = new HashMap<>();
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Class<T> getResponseType() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass == null) {
            throw new IllegalStateException("Super class must not be null");
        }
        if (!(superClass instanceof ParameterizedType)) {
            throw new IllegalStateException("Super class must be a parameterized type");
        }
        // 获取最后一个泛型参数
        Type[] actualTypeArguments = ((ParameterizedType) superClass).getActualTypeArguments();
        if (actualTypeArguments == null || actualTypeArguments.length == 0) {
            throw new IllegalStateException("Type argument must not be null");
        }
        Type type = actualTypeArguments[actualTypeArguments.length-1];
        if (type == null) {
            throw new IllegalStateException("Type argument must not be null");
        }
        if (!(type instanceof Class)) {
            throw new IllegalStateException("Type argument must be a class");
        }
        return (Class<T>) type;
    }

    @Override
    public Map<String, String> getQueryParams() {
        return queryParams;
    }
}
