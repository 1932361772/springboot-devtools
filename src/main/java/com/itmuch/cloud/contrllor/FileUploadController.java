package com.itmuch.cloud.contrllor;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller//返回模板文件只能用@Controller
public class FileUploadController {
	@RequestMapping("/file")
	public String file() {
		return "/file";
	}
	@RequestMapping("/upload")
	@ResponseBody//返回到页面
	public String fileUpload(@RequestParam("filename") MultipartFile file) {
		if (file.isEmpty()) {
			return "false";
		}
		String	fileName=file.getOriginalFilename();
		System.err.println(".......filName:"+fileName);
		String filePath="c://SSM/";//后面的/不能少.否则不能进入子目录.
		File dest=new File(filePath+fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return "true";
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "false";
	}
	
	
}
