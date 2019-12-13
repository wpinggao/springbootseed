package com.wping.seed.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * describe:
 *
 * @author Wping.gao
 * @date 2019/5/24 18:25
 */
@ApiModel(value = "登陆VO")
public class LoginReqVo implements Serializable {
    private static final long serialVersionUID = -4329148563946129389L;

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message = "设备号不能为空")
    @ApiModelProperty(value = "设备号")
    private String device;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
