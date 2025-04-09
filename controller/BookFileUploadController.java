package com.springboot.restapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.restapi.book.helper.FileUploadHelper;

@RestController
public class BookFileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> UploadFile(@PathVariable("file") MultipartFile file) {		
		try {
			// vaildation
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty!");
			}
			
			// check file is jpeg or not
			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content type allowed");
			}
	
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getName());
			System.out.println(file.getSize());
			System.out.println(file.getContentType());
			
			boolean b = fileUploadHelper.isUploadFile(file);
			if(b) {
				// return ResponseEntity.ok("File is Successfully uploaded...");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("image/").path(file.getOriginalFilename()).toUriString());
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	} 
	
}