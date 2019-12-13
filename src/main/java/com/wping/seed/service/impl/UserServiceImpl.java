package com.wping.seed.service.impl;

import com.wping.seed.service.UserService;
import com.wping.seed.vo.response.UserDetailRespVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDetailRespVo getUserDetail(String name) {

        UserDetailRespVo userDetailRespVo = new UserDetailRespVo();
        userDetailRespVo.setName(name);


        return userDetailRespVo;
    }



}
