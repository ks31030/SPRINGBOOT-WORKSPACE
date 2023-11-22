package com.kh.springprojectchap1.web;


public class NewFileController {
	
	@GetMapping
	public String hello() {
		return "Hello, world";
	}
}
