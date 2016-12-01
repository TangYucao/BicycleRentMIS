//����ط�����Ϊview
package com.tyc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Manager;
import com.tyc.web.service.BicycleService;
import com.tyc.web.service.ManagerService;
import com.tyc.web.util.FileUpload;

@Controller
@RequestMapping("/bicycle")
public class BicycleController {

	@Autowired
	private BicycleService bicycleService;

	@RequestMapping(value="/addBicycle")
	public String addBicycle(Bicycle bicycle,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
        if(multipartResolver.isMultipart(request)){  
            //ת���ɶಿ��request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //ȡ��request�е������ļ���  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //��¼�ϴ������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
                int pre = (int) System.currentTimeMillis();  
                //ȡ���ϴ��ļ�  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //ȡ�õ�ǰ�ϴ��ļ����ļ����  
                    String myFileName = file.getOriginalFilename();  
                    //�����Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //�������ϴ�����ļ���  
                        bicycle.setBimageurl(myFileName);//tyc
                        String fileName = file.getOriginalFilename();  
                        //�����ϴ�·��  
                        String path=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/"); //tyc
                        path +=  "imgBicycle\\"+fileName;  
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                    }  
                }  
                //��¼�ϴ����ļ����ʱ��  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
        
        }  
      
        bicycleService.addBicycle(bicycle);
		return "/success.jsp";
	}
	
	@RequestMapping(value="/modBicycle")
	public String modBicycle(Bicycle bicycle,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException
	{
		System.out.println("BicycyleController-modBicycle:1");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
        if(multipartResolver.isMultipart(request)){  
            //ת���ɶಿ��request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //ȡ��request�е������ļ���  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //��¼�ϴ������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
                int pre = (int) System.currentTimeMillis();  
                //ȡ���ϴ��ļ�  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //ȡ�õ�ǰ�ϴ��ļ����ļ����  
                    String myFileName = file.getOriginalFilename();  
                    //�����Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //�������ϴ�����ļ���  
                        bicycle.setBimageurl(myFileName);//tyc
                        String fileName = file.getOriginalFilename();  
                        //�����ϴ�·��  
                        String path=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/"); //tyc
                        path +=  "imgBicycle\\"+fileName;  
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                    }  
                }  
                //��¼�ϴ����ļ����ʱ��  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
        
        }  
      
        bicycleService.modBicycle(bicycle);
		return "/success.jsp";
	}
	
}
