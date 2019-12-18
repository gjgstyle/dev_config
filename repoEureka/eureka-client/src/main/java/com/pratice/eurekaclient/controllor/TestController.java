package com.pratice.eurekaclient.controllor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${server.port}")
	String port;

	@RequestMapping(value="hi")
	public String hi() {
		return "my port is "+port;
	}
}
