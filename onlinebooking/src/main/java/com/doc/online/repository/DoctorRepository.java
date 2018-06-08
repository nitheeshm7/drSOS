package com.doc.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.online.entity.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {

}
