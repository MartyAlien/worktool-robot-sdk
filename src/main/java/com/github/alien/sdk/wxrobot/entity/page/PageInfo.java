package com.github.alien.sdk.wxrobot.entity.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息
 * <br/>
 *
 * @author alien at 2024/3/19 16:23
 */
public class PageInfo<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    private List<? extends E> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<? extends E> getList() {
        return list;
    }

    public void setList(List<? extends E> list) {
        this.list = list;
    }
}