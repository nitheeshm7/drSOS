package com.doc.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.online.entity.BookingDoc;

public interface BookingDocRepository extends JpaRepository<BookingDoc, Long> {

}
