package com.pratice.eurekaclient.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.eurekaclient.Entity.ResponseBodyEntity;
import com.pratice.eurekaclient.Entity.UserEntity;
import com.pratice.eurekaclient.common.utils.EncryPasswordUtil;
import com.pratice.eurekaclient.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/regist")
	public ResponseBodyEntity<Void> reigst(@RequestBody UserEntity user) {
		ResponseBodyEntity<Void> result = new  ResponseBodyEntity<Void> ();

		UserEntity userEntity = userService.getUserInfo(user.getUserName());
		//判断当前用户名是否已注册
		if(userEntity != null) {
			result.setResponseInfo("202", "当前用户已存在！", null);
			return result;
		}

		try {
			//获取随机安全指令
			String salt = EncryPasswordUtil.getRandomSalt();
			//获取加密密码
			String password = EncryPasswordUtil.getEncrpyPassword(user.getPassword(), salt);
			user.setPassword(password);
			user.setUserSafeId(salt);
			userService.regist(user);
			result.setResponseInfo("200", "注测成功！", null);
		}catch(Exception e) {
			result.setResponseInfo("500", "系统错误，请联系管理员！", null);
		}
		return result;
	}

	@PostMapping("/login")
	public ResponseBodyEntity<Void> Login(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		UserEntity user = userService.getUserInfo(userName);

		ResponseBodyEntity<Void> result = new  ResponseBodyEntity<Void> ();

		if(user == null) {
			result.setResponseInfo("201", "请确认账户密码！", null);
			return result;
		}

		boolean encry = EncryPasswordUtil.isCorrect(password, user.getPassword(), user.getUserSafeId());

		if(encry) {
			result.setResponseInfo("200", "登陆成功！", null);
		}else {
			result.setResponseInfo("201", "请确认账户密码！", null);
		}

		return result;
	}

}
