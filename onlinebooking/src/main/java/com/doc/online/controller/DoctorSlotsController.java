package com.doc.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.online.entity.BookingDoc;
import com.doc.online.repository.BookingDocRepository;

@RestController
public class DoctorSlotsController {
	@Autowired
	private BookingDocRepository bookingDocRepository;

	public ResponseEntity<Object> addSlotsAndTokens(@RequestBody BookingDoc bookingDoc) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		BookingDoc saved = bookingDocRepository.save(bookingDoc);
		if (saved != null) {
			responseEntity = ResponseEntity.ok().build();
		}
		return responseEntity;
	}

}
