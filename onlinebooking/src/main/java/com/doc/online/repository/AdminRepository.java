package com.doc.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doc.online.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query("SELECT a FROM Admin a WHERE a.adminId = ?1 ")
	public Admin getAdmin(String adminId ); 
	
}
