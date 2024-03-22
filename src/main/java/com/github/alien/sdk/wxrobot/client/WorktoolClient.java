package com.github.alien.sdk.wxrobot.client;

import com.alibaba.fastjson.JSON;
import com.github.alien.sdk.wxrobot.IWorktoolClient;
import com.github.alien.sdk.wxrobot.entity.AbsWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IWorktoolRequest;
import okhttp3.*;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Worktool客户端
 * <br/>
 *
 * @author alien at 2024/3/19 14:26
 */
public class WorktoolClient implements IWorktoolClient {
    private final String robotId;
    private final OkHttpClient httpClient;

    public WorktoolClient(String robotId) {
        this(robotId, 10, TimeUnit.SECONDS);
    }

    public WorktoolClient(String robotId, long timeout, TimeUnit unit) {
        this(robotId
                , new OkHttpClient()
                        .newBuilder()
                        .connectTimeout(timeout, unit)
                        .readTimeout(timeout, unit)
                        .writeTimeout(timeout, unit)
                        .build()
        );
    }

    public WorktoolClient(String robotId, OkHttpClient httpClient) {
        this.robotId = robotId;
        this.httpClient = httpClient;
    }

    @Override
    public String getRobotId() {
        return this.robotId;
    }

    @Override
    public <T> T call(AbsWorktoolRequest<T> request) {
        return call((IWorktoolRequest) request);
    }

    @Override
    public <T> T call(IWorktoolRequest request) {
        if (request == null) {
            throw new NullPointerException("request is null");
        }
        if (request.getMethod() == null) {
            throw new IllegalArgumentException("request method is required");
        }

        // 构建请求
        Request httpRequest = new Request.Builder()
                .url(constructUrl(request))
                .method(request.getMethod().name()
                        , Optional.ofNullable(request.getBody())
                                .map(b -> RequestBody.create(JSON.toJSONString(b), MediaType.parse("application/json")))
                                .orElse(null)
                )
                .build();

        // 发送请求并处理响应
        try (Response response = httpClient.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new UnexpectedException("Unexpected response code: " + response);
            }
            if (response.body() == null) {
                return null;
            }
            return JSON.parseObject(response.body().string(), request.getResponseType());
        } catch (IOException e) {
            throw new RuntimeException("http call error", e);
        }
    }
}
