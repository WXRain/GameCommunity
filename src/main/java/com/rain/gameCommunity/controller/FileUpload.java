package com.rain.gameCommunity.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class FileUpload {

	@RequestMapping("/fileUpload.do")
	@ResponseBody
	public JsonResult<String> fileUpload(String name, MultipartFile file, HttpServletRequest request){
		if(file.isEmpty()) return new JsonResult<String>(1, "文件为空", null); 
		System.out.println(request.getSession().getServletContext().getRealPath("uploadFloder"));
		String path = request.getSession().getServletContext().getRealPath("uploadFloder");
		String fileName = file.getOriginalFilename();//.jpg
		File targetFile = new File(path, fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();//不存在则新建目录
		}
		try{
			file.transferTo(targetFile);
		}catch(Exception e){
			return new JsonResult<String>(1, e.getMessage(), null);
		}
		File afile = new File(request.getSession().getServletContext().getRealPath("uploadFloder") + "/" + fileName);
		System.out.println(afile.length());
		return new JsonResult<String>(0, null, "文件上传成功");
	}
}
