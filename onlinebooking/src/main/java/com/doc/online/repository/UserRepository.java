package com.doc.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doc.online.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE u.emailId = ?1 ")
	public Users findByEmailId(String email);
	
	@Query("SELECT u FROM Users u WHERE u.emailId = ?1 ")
	public Users loginWithEmail(String emailId);
	@Query("SELECT u FROM Users u WHERE u.phoneNo = ?1 ")
	public Users loginWithPhoneNo(String phoneNo);

}
