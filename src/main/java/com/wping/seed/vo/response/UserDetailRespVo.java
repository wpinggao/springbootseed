package com.wping.seed.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户明细")
public class UserDetailRespVo implements Serializable {
    private static final long serialVersionUID = 4924252618391241216L;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "登陆名")
    private String loginName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
