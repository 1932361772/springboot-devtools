package com.itmuch.cloud.contrllor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.OS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller//返回模板文件只能用@Controller
public class FileUploadController {//  /batch
	
	//单文件上传
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

	
//多文件上传	
	@RequestMapping("/multifile")
	public String multifile() {
		return "/multifile";
	}
	@RequestMapping(value="/batch/upload",method=RequestMethod.POST)
	@ResponseBody//返回到页面
	public  String batchfileUpload(HttpServletRequest request) {
		List<MultipartFile>files=((MultipartHttpServletRequest)request).getFiles("filename");//与multifile.html中的name完全一样.
		MultipartFile file=null;
		String filePath="c://SSM/";//后面的/不能少.否则不能进入子目录.
		
		for (int i = 0; i < files.size();i++) {
			file=files.get(i);
			
			String	fileName=file.getOriginalFilename();
			System.err.println(".......filName:"+fileName);
			if (file.isEmpty()) {
				return "false";
			}else {
				
				File dest=new File(filePath+fileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				try {
					file.transferTo(dest);
//					return "true";
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return "true";
	}
	
	
//文件下載
	@RequestMapping("/download")
	public String download(HttpServletResponse response) throws IOException {
		String filename="POST-NET.gif";
		String filePath="C://bank/"; //"C://bank//"均可.
		File file=new File(filePath+filename);
		if (file.exists()) {
			response.setContentType("application/force-download");//下载时不用打开.
			response.addHeader("Content-Disposition", "attachment;filename="+filename);//
			byte[] bffer=new byte[1024];
			FileInputStream fis=null;
			BufferedInputStream bis=null;
		
			fis=new FileInputStream(file);
			bis=new BufferedInputStream(fis);
			OutputStream os=response.getOutputStream();
			int i=bis.read(bffer);
			while (i!=-1) {//i不等于-1说明有数据.
				os.write(bffer);//
				i=bis.read(bffer);//必须写这个否则下载不会停止.
			}
	
		System.err.println("-------------filedown ok....");
		bis.close();
		fis.close();
		os.close();
		
		}
		
		return null;
	}
	
}
