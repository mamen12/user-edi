package com.general.edi.service;

import java.util.List;

import com.general.edi.beans.UserRequest;
import com.general.edi.beans.UserResponse;

public interface IUserService {

	//save
	public UserResponse saveUser(UserRequest user);
	//getAll
	public List<UserResponse> getAllUser();
	//detail
	public UserResponse getDetailUser(UserRequest user);
	//delete
	public UserResponse deleteUser(UserRequest user);
	
	
	//check getAll or getDetail
	public List<UserResponse> checkUserDetailOrGetAll(UserRequest user);
	
	
}
