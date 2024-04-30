package com.general.edi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.general.edi.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{

	
}
