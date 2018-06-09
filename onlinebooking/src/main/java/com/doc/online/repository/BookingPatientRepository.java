package com.doc.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.online.entity.BookingPatient;

public interface BookingPatientRepository extends JpaRepository<BookingPatient, Long> {

}
