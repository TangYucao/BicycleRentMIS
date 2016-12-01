//����ط�����Ϊview
package com.tyc.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Manager;
import com.tyc.web.entity.Rent;
import com.tyc.web.service.ManagerService;
import com.tyc.web.util.FileUpload;

@Controller
@RequestMapping("/manager")
public class ManagerController extends FileUpload{

	@Autowired
	private ManagerService managerService;

	@RequestMapping("/toIndex")
	public String toIndex()
	{
		return "/pages/manager/index.html";
	}
	@RequestMapping("/toLogIn")
	public String toLogIn() {
		return "/pages/manager/login.html";
	}
	
	@RequestMapping(value="/toShowPage")//all bicycles
	public String toShowPage(HttpServletRequest request) 
	{
		List<Bicycle> tmpBicycleList=null;
		tmpBicycleList=managerService.getAllBicycle();
		request.setAttribute("tmpBicycleList", tmpBicycleList);
		
		return "/pages/manager/showPage.jsp";
	}
	@RequestMapping("/toAddNewBike")
	public String toAddNewBike()
	{
		return "/pages/manager/addNewBike.html";
	}
	@RequestMapping("/toBikeDetail")//mod bike!
	public String toBikeDetail(HttpServletRequest request)
	{
		int bid=Integer.parseInt(request.getParameter("bid").toString());
		Bicycle tmpBicycle=managerService.getBicycleByBid(bid);
		request.setAttribute("tmpBicycle", tmpBicycle);
		System.out.println("class-toBikeDetail-bid="+bid);
		return "/pages/manager/bikeDetail.jsp";
	}
	@RequestMapping(value="/afterLogIn",method=RequestMethod.POST)
	public String afterLogIn(Manager manager,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("ManagerController:afterLogin-----");
		// ��user�ŵ�dao�����hql��ѯ
		if (managerService.checkManager(manager)) {
			request.setAttribute("mid", manager.getMid());
			request.setAttribute("password", manager.getPasswd());
			List<Manager> tmp=managerService.queryAllManager();//�����ôд
			request.setAttribute("managerList", tmp);
			response.addCookie(new Cookie("mid", manager.getMidString()));
			return "/manager/toIndex";
		} else
			return "/manager/toLogIn";
	}

//	//��ӳ���������ͼƬ��ȥִ��util�е�upload����
//	@RequestMapping(value="/addBicycle")
//	public String addBicycle(Bicycle bicycle,File file)
//	{
//		System.out.println("ManagerController:1");
//		FileUpload fileUpload=new FileUpload(bicycle,file);
//		fileUpload.addBicycle();
//		System.out.println(bicycle.getBimageurl());
//		System.out.println(bicycle.getBrentmoney());
//		managerService.addBicycle(bicycle);
//		return "/manager/success.jsp";
//	}
//	
	///
	@RequestMapping(value="/selectBicycle")
	public String selectBicycle(
			@RequestParam("btype")String btype,	HttpServletRequest request,HttpServletResponse response
			) {
			System.out.println("In the selectBicycle()");
			List<Bicycle> tmp = managerService.selectBicycle(btype, null, null, 0, 9999, null, true);
			request.setAttribute("tmpBicycleList", tmp);
			return "/pages/manager/showPage.jsp";
		}
	
	@RequestMapping(value="/updateBicycle")
	public String updateBicycle(
			@RequestParam("bid")int bid, @RequestParam("columen_name")String column_name, String value,
			HttpServletRequest request,HttpServletResponse response
			)
	{
		managerService.updateBicycle(bid, column_name, value);
		return "/pages/manager/showPage.jsp";
	}	
}

