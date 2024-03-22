package com.github.alien.sdk.wxrobot;

import com.github.alien.sdk.wxrobot.entity.AbsWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IWorktoolRequest;
import okhttp3.HttpUrl;

/**
 * 工具客户端接口
 * <br/>
 *
 * @author alien at 2024/3/22 12:20
 */
public interface IWorktoolClient {

    /**
     * 接口请求回应
     *
     * @param request
     * @param <T>
     * @return
     */
    public <T> T call(IWorktoolRequest request);

    /**
     * 接口请求回应
     *
     * @param request
     * @param <T>
     * @return
     */
    public <T> T call(AbsWorktoolRequest<T> request);

    /**
     * 获取机器人ID
     * @return
     */
    String getRobotId();

    /**
     * 构建请求URL: {baseUrl}{requestPath}?robotId={robotId}[&{queryParams}]
     * @param request
     * @return
     */
    default HttpUrl constructUrl(IWorktoolRequest request) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(request.getBaseUrl() + request.getRequestPath())
                .newBuilder()
                .addQueryParameter("robotId", getRobotId());
        if (request.getQueryParams() != null && !request.getQueryParams().isEmpty()) {
            request.getQueryParams()
                    .forEach((k, v) -> {
                        if (v != null) {
                            urlBuilder.addQueryParameter(k, v);
                        }
                    });
        }
        return urlBuilder.build();
    }
}
