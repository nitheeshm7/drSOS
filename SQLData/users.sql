/*
SQLyog Community v13.0.1 (32 bit)
MySQL - 5.7.22-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `users` (
	`user_id` varchar (135),
	`user_name` varchar (135),
	`password` varchar (135),
	`email_id` varchar (135),
	`phone_no` varchar (135),
	`active` varchar (135),
	`date_of_birth` date ,
	`gender` varchar (135),
	`blood_group` varchar (135),
	`married` varchar (135),
	`height` int (11),
	`weight` int (11),
	`emergency_contact` varchar (135),
	`address_line1` varchar (135),
	`address_line2` varchar (135),
	`city` varchar (135),
	`state` varchar (135),
	`country` varchar (135),
	`old_password1` varchar (135),
	`old_password2` varchar (135)
); 
