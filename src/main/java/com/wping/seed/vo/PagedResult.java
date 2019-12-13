package com.wping.seed.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class PagedResult<T> implements Serializable {

    private static final long serialVersionUID = 2816004234472531843L;

    @ApiModelProperty(value = "对象列表数据", name = "dataList")
    private List<T> dataList;

    @ApiModelProperty(value = "当前页号", name = "pageNo", required = true, example = "1")
    private long pageNo;

    @ApiModelProperty(value = "页条数", name = "pageSize", required = true, example = "10")
    private long pageSize;

    @ApiModelProperty(value = "总条数", name = "total", required = true, example = "100")
    private long total;

    @ApiModelProperty(value = "总页面数目", name = "pages", required = true, example = "10")
    private long pages;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

}
