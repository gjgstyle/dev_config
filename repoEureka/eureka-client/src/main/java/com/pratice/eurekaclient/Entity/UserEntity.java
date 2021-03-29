package com.pratice.eurekaclient.Entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.Getter;

@Data
@TableName("ath_user")
public class UserEntity extends EntityBase {

	/*
	 * 用户Id
	 */
	@TableId(value="user_id",type=IdType.AUTO)
	private String id;
	/*
	 * 用户名、电话（电话注册）
	 */
	@TableField(value="user_name",exist = true)
	private String userName;
	/*
	 * 用户密码
	 */
	@TableField(value="user_password",exist = true)
	private String password;
	/*
	 * 安全令牌id
	 */
	@TableField(value="user_safe_id",exist = true)
	private String userSafeId;
	/*
	 * 是否删除（0,：未删除，1：删除）
	 */
	@TableField(value="is_delete",exist = true)
	private String isDeleteFlg;
}
