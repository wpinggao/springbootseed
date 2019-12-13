package com.wping.seed.controller;

import com.wping.component.base.context.UserContextHolder;
import com.wping.component.base.vo.Result;
import com.wping.seed.service.UserService;
import com.wping.seed.vo.response.UserDetailRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "user", description = "用户")
@RestController
@RequestMapping("/user")
public class UserBaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserBaseController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户明细", httpMethod = "GET")
    public Result<UserDetailRespVo> getUserDetai(HttpServletRequest request) {

        return Result.success(userService.getUserDetail(UserContextHolder.getUserName()));

    }



}
