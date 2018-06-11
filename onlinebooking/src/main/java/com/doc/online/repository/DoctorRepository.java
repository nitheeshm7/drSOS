package com.doc.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.doc.online.entity.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {
	@Modifying
	@Query("UPDATE Doctors d SET d.active = ?1 WHERE d.doctorId = ?2")
	public int setDoctorStatus(boolean active, String doctorId);

}
