package com.pratice.eurekaclient.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.eurekaclient.Entity.ResponseBodyEntity;
import com.pratice.eurekaclient.Entity.UserEntity;
import com.pratice.eurekaclient.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/reigst")
	public void reigst() {

	}

	@PostMapping("/login")
	public ResponseBodyEntity<Void> Login(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		UserEntity user = userService.getUserInfo(userName);


		ResponseBodyEntity<Void> result = new  ResponseBodyEntity<Void> ();
		if(user.getPassword().equals(password)) {
			result.setState("200");
			result.setMessage("登陸成功！");
		}

		return result;
	}

}
