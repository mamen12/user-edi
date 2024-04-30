package com.general.edi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.general.edi.beans.UserRequest;
import com.general.edi.beans.UserResponse;
import com.general.edi.entity.UserInfo;
import com.general.edi.repo.UserRepository;
import com.general.edi.security.BCrypt;
import com.general.edi.service.IUserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	@Transactional
	@Override
	public UserResponse saveUser(UserRequest user) {
		UserInfo userInfo = new UserInfo();
		userInfo = UserInfo.builder()
				.namaLengkap(user.getNamaLengkap())
				.username(user.getUsername())
				.password(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()))
				.status(user.getStatus())
				.build();
		
		userInfo = userRepo.save(userInfo);
		
		return UserResponse.builder()
				.userId(userInfo.getId())
				.namaLengkap(userInfo.getNamaLengkap())
				.username(userInfo.getUsername())
				.status(userInfo.getStatus())
				.build();
	}

	@Override
	public List<UserResponse> getAllUser() {
		List<UserInfo> userInfos = userRepo.findAll();
		
		List<UserResponse> userResponse = userInfos.stream().map(u -> 
					UserResponse.builder()
					.userId(u.getId())
					.namaLengkap(u.getNamaLengkap())
					.username(u.getUsername())
					.status(u.getStatus())
					.build()).collect(Collectors.toList());
		
		return userResponse;
	}
	
	@Override
	public UserResponse getDetailUser(UserRequest userRequest) {
		UserResponse userResponse = new UserResponse();
		try {
			UserInfo user = userRepo.findById(userRequest.getUserId()).orElseThrow();
			userResponse = UserResponse.builder()
			.userId(user.getId())
			.namaLengkap(user.getNamaLengkap())
			.username(user.getUsername())
			.status(user.getStatus())
			.build();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return userResponse;
	}

	@Override
	public UserResponse deleteUser(UserRequest user) {
		UserResponse userResponse = new UserResponse();
		try {
			userRepo.deleteById(user.getUserId());
			userResponse = UserResponse.builder().message("succesfuly delete").build();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return userResponse;
	}

	@Override
	public List<UserResponse> checkUserDetailOrGetAll(UserRequest user) {
		List<UserResponse> response = new ArrayList<>();
		if (ObjectUtils.isEmpty(user.getUserId())) {
			response = getAllUser();
		}else {
			UserResponse us = getDetailUser(user);
			response.add(us);
		}
		return response;
	}
	
	
	
	

}
