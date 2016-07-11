package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUpload {
	@RequestMapping("/fileupload")
	public String upload(){
		return "fileupload";
	}
	
	
	
@RequestMapping("/uploadfile")
public String fileupload(@RequestParam MultipartFile uploadfile,HttpServletRequest request){
	try{
		MultipartFile file=uploadfile;
		String filename=file.getOriginalFilename();
		InputStream is=file.getInputStream();
		String targetDir=request.getSession().getServletContext().getRealPath("uploadfiles");
		File targetfile=new File(targetDir,filename);
		FileOutputStream os=new FileOutputStream(targetfile);
		IOUtils.copy(is, os);
	}catch(Exception e){
		e.printStackTrace();
	}
	return "succ";
}
}
