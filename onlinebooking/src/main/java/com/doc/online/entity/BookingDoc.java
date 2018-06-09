package com.doc.online.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BookingDoc {
	@Id
	@GenericGenerator(name = "seq_doc_bookingId", strategy = "com.doc.online.idgenerators.DocBookingIdGenerator")
	@GeneratedValue(generator = "seq_doc_bookingId")
	private String docBookingId;
	private String doctorId;
	private int totalTokensSlot1;
	private int totalTokensSlot2;
	private LocalTime slot1StartTime;
	private LocalTime slot1EndTime;
	private LocalTime slot2StartTime;
	private LocalTime slot2EndTime;
	private int freeTokensSlot1;
	private int freeTokensSlot2;
	private String message;

	public String getDocBookingId() {
		return docBookingId;
	}

	public void setDocBookingId(String docBookingId) {
		this.docBookingId = docBookingId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public int getTotalTokensSlot1() {
		return totalTokensSlot1;
	}

	public void setTotalTokensSlot1(int totalTokensSlot1) {
		this.totalTokensSlot1 = totalTokensSlot1;
	}

	public int getTotalTokensSlot2() {
		return totalTokensSlot2;
	}

	public void setTotalTokensSlot2(int totalTokensSlot2) {
		this.totalTokensSlot2 = totalTokensSlot2;
	}

	public LocalTime getSlot1StartTime() {
		return slot1StartTime;
	}

	public void setSlot1StartTime(LocalTime slot1StartTime) {
		this.slot1StartTime = slot1StartTime;
	}

	public LocalTime getSlot1EndTime() {
		return slot1EndTime;
	}

	public void setSlot1EndTime(LocalTime slot1EndTime) {
		this.slot1EndTime = slot1EndTime;
	}

	public LocalTime getSlot2StartTime() {
		return slot2StartTime;
	}

	public void setSlot2StartTime(LocalTime slot2StartTime) {
		this.slot2StartTime = slot2StartTime;
	}

	public LocalTime getSlot2EndTime() {
		return slot2EndTime;
	}

	public void setSlot2EndTime(LocalTime slot2EndTime) {
		this.slot2EndTime = slot2EndTime;
	}

	public int getFreeTokensSlot1() {
		return freeTokensSlot1;
	}

	public void setFreeTokensSlot1(int freeTokensSlot1) {
		this.freeTokensSlot1 = freeTokensSlot1;
	}

	public int getFreeTokensSlot2() {
		return freeTokensSlot2;
	}

	public void setFreeTokensSlot2(int freeTokensSlot2) {
		this.freeTokensSlot2 = freeTokensSlot2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
