package com.pratice.eurekaclient.service;

import org.springframework.stereotype.Service;

import com.pratice.eurekaclient.Entity.UserEntity;

@Service
public interface UserService {

	public void regist(UserEntity user);

	public UserEntity getUserInfo(String username);

}
