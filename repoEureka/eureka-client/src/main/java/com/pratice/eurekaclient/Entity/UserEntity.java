package com.pratice.eurekaclient.Entity;

import lombok.Data;
import lombok.Getter;

@Data
public class UserEntity extends EntityBase {

	/*
	 * 用户Id
	 */
	private String id;
	/*
	 * 用户名、电话（电话注册）
	 */
	private String userName;
	/*
	 * 用户密码
	 */
	private String password;
	/*
	 * 安全令牌id
	 */
	private String userSafeId;
	/*
	 * 是否删除（0,：未删除，1：删除）
	 */
	private String isDeleteFlg;
}
