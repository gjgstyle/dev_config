package com.pratice.eurekaclient.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.pratice.eurekaclient.Entity.UserEntity;
import com.pratice.eurekaclient.mapper.UserMapper;
import com.pratice.eurekaclient.service.UserService;

public class ImpUserService implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public void regist(UserEntity user) {
		userMapper.reigst(user);
	}

	@Override
	public UserEntity getUserInfo(String userName) {
		return userMapper.getPwdByUserName(userName);
	}

}
