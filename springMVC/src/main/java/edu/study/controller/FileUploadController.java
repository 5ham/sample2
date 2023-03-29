package edu.study.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value="/upload")
@Controller
public class FileUploadController {

	@RequestMapping(value="/ex01.do")
	public String ex01() {
		return "upload/uploadEx";
	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public String upload(MultipartFile file1,MultipartFile file2,MultipartFile file3) throws IllegalStateException, IOException {
		
		String path = "D:\\ohmSpring\\springMVC\\src\\main\\webapp\\resources\\uploadFile";
		
		//위치 폴더가 존재하는지 확인
		File dir = new File(path);
		if(!dir.exists()) { //폴더가 없을 경우
			dir.mkdirs();
		}
		String newFileName = "";
		if(!file1.getOriginalFilename().isEmpty()) { //파라미터 파일이 존재하는 경우
			String FileName = System.currentTimeMillis()+file1.getOriginalFilename();
			newFileName = new String(FileName.getBytes("UTF-8"),"8859_1"); //파일명 한글 오류 관련 인코딩 변경 부분
			file1.transferTo(new File(path,newFileName));
		}
		
		return "redirect:/upload/ex01.do?uploadFileName="+newFileName;
	}
	
}
