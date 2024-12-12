module sesi11 {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	opens main;
	opens views;
	opens controller;
	opens database;
	opens model;
}