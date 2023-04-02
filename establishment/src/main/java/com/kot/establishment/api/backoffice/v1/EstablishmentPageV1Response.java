package com.kot.establishment.api.backoffice.v1;

import com.kot.establishment.api.ResponsePage;

import java.util.List;

public class EstablishmentPageV1Response extends ResponsePage<EstablishmentV1Response> {

    private Integer pageIndex;
    private Integer pageSize;

    public EstablishmentPageV1Response(List<EstablishmentV1Response> items, long count, Integer pageIndex, Integer pageSize) {
        super(items, count);
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
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
