/*
SQLyog Community v13.0.1 (32 bit)
MySQL - 5.7.22-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `booking_doc` (
	`doc_booking_id` varchar (135),
	`doctor_id` varchar (135),
	`total_tokens_slot1` int (11),
	`total_tokens_slot2` int (11),
	`slot1_start_time` time ,
	`slot1_end_time` time ,
	`slot2_start_time` time ,
	`slot2_end_time` time ,
	`free_tokens_slot1` int (11),
	`free_tokens_slot2` int (11),
	`message` text 
); 
