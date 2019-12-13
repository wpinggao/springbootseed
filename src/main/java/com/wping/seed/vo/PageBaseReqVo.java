package com.wping.seed.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * describe:分页请求基本VO
 *
 * @author Wping.gao
 * @date 2018/12/04
 */
public class PageBaseReqVo implements Serializable {
    private static final long serialVersionUID = -3729415833938089668L;

    @ApiModelProperty(value = "页号", required = false, example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "页数", required = false, example = "5")
    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
