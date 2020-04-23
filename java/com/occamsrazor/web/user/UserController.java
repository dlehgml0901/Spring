package com.occamsrazor.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping("/join")
	public Messenger join(@RequestBody User user) {
		int count = userService.count();
		userService.add(user);
		return (userService.count() == count + 1)? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user) {
		Map<String, Object> returnMap = new HashMap<>();
		User loginUser = userService.login(user);
		if (loginUser != null) {
			returnMap.put("user", loginUser);
			returnMap.put("messenger", Messenger.SUCCESS);		
		}else {
			returnMap.put("messenger", Messenger.FAIL);	
		}
		return returnMap;
	}
}
