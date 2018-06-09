/*
SQLyog Community v13.0.1 (32 bit)
MySQL - 5.7.22-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `booking_patient` (
	`booking_id` varchar (135),
	`doctor_id` varchar (135),
	`patient_id` varchar (135),
	`date` date ,
	`slot_no` int (11),
	`token_no` int (11),
	`comments` text 
); 
