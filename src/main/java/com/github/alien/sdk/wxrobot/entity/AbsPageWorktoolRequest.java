package com.github.alien.sdk.wxrobot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.alien.sdk.wxrobot.utils.DateUtil;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * 分页查询基类
 * <br/>
 *
 * @author alien at 2024/3/20 9:27
 */
public abstract class AbsPageWorktoolRequest<T> extends AbsWorktoolRequest<T> {
    /**
     * 分页页号
     */
    private Integer page;
    /**
     * 分页大小
     */
    private Integer size;
    /**
     * 排序 xxFieldName,[asc|desc]
     */
    private String sort;
    /**
     * 开始时间: yyyy-MM-dd HH:mm:ss
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间: yyyy-MM-dd HH:mm:ss
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> queryParams = super.getQueryParams();
        queryParams.put("page", Optional.ofNullable(page).map(String::valueOf).orElse(null));
        queryParams.put("size", Optional.ofNullable(size).map(String::valueOf).orElse(null));
        queryParams.put("sort", sort);
        queryParams.put("startTime", DateUtil.formatToDateTime(startTime));
        queryParams.put("endTime", DateUtil.formatToDateTime(endTime));
        return queryParams;
    }
}
