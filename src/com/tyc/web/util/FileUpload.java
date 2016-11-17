package com.tyc.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.ServletConfigPropertySource;

import com.tyc.web.entity.Bicycle;
import com.tyc.web.service.BicycleService;

public class FileUpload {
	
	public File file;//从前端得到值！
	private String fileFileName;
	private String fileFileContentType;
	public Bicycle bicycle = new Bicycle();//stuct2中，前端会把实体以及他的值传过来，不知道spring会不会？
	public FileUpload()
	{
		
	}
	public FileUpload(Bicycle bicycle,File file)
	{
		this.bicycle=bicycle;
		this.file=file;
	}//构造函数：从controller传bicycle与file过来
	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}


    	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}




	public String getFileFileContentType() {
		return fileFileContentType;
	}


	public void setFileFileContentType(String fileFileContentType) {
		this.fileFileContentType = fileFileContentType;
	}
	
	public String addBicycle() {
		
		
		BicycleService bicycleService=new BicycleService();
		//String path = ServletActionContext.getRequest().getRealPath("/");
		String path=ContextLoader.getCurrentWebApplicationContext().getServletContext().getContextPath(); 
//		String path="C:\Java\apache-tomcat-6.0.36\webapps\ROOT\";
		System.out.println("tyc!:path"+path);
		System.out.println();
		String completeName = path + "imgBicycle\\" + fileFileName;//保存在image!
		//bicycle.setBimageurl(fileFileName);
		
//		goodsservice.update(goods);这里改为bicycle.update
		bicycleService.addBicycle(bicycle);
		//System.out.println("path = " + path + "completeName = " + completeName);
		try {
			
			
			int byteread = 0;
			int bytesum = 0;
			
			InputStream inStream = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(completeName);
			
			byte[] buffer = new byte[1444];
			int length;
			
			while((byteread = inStream.read(buffer))!=-1){
				bytesum += byteread;
				fos.write(buffer, 0, byteread);
			}
			inStream.close();
			
			
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("图片位置"+completeName);
	    System.out.println();
	    
	    
	    
	    return "T";
	}
}
