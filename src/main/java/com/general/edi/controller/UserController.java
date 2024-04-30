package com.general.edi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.general.edi.beans.UserRequest;
import com.general.edi.beans.UserResponse;
import com.general.edi.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	IUserService userService;

	@PostMapping("/user/save")
	public UserResponse addNewUser(@RequestBody UserRequest rq) {
		UserResponse response = userService.saveUser(rq);
		return response;
	}
	
	@PostMapping("/users")
	public List<UserResponse> getUsers(@RequestBody UserRequest rq){
		return userService.checkUserDetailOrGetAll(rq);
	}
	
	@PostMapping("/user/delete")
	public UserResponse deleteUser(@RequestBody UserRequest rq){
		return userService.deleteUser(rq);
	}
}
