package com.springboot.restapi.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	 public final String UPLOAD_DIR = "E:\\BCA SEM 5\\Spring\\springboot\\springboot\\src\\main\\resources\\static\\image";
//	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws Exception{
	}

	
	public boolean isUploadFile(MultipartFile file) {
		boolean f = false;
		
		try {
		
		// First Way :-
			// Read
			/*
			InputStream is = file.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);

			// Write
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			f = true;
			*/
			
		// Second Way :-
			Files.copy(file.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
