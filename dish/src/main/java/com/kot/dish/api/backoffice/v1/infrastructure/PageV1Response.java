package com.kot.dish.api.backoffice.v1.infrastructure;

import java.util.List;

public class PageV1Response<T> {

    private List<T> items;
    private long count;
    private Integer pageIndex;
    private Integer pageSize;

    public PageV1Response(List<T> items, long count, Integer pageIndex, Integer pageSize) {
        this.items = items;
        this.count = count;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
