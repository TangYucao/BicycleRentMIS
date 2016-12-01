//����ط�����Ϊview
package com.tyc.web.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Manager;
import com.tyc.web.entity.Rent;
import com.tyc.web.entity.User;
import com.tyc.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toHome")//主页
	public String toHome() {
		return "/pages/user/overallPage_lx.html;";
	}
	@RequestMapping("/toLogIn")//登陆
	public String toLogIn() {
		return "/pages/user/login_lx.jsp";
	}
	@RequestMapping(value="/afterLogIn",method=RequestMethod.POST)//登陆以后
	public String afterLogIn(User user,HttpServletResponse response,HttpServletRequest request) {
		//��½֮��Ҫ���û�����session/cookie��
		// ��user�ŵ�dao�����hql��ѯ
		if (userService.checkUser(user)) {
			//��½�ɹ������û����뵽session��
			System.out.println("class-afterLogIn-break1");
			String tmpUphonenum=user.getUphonenum();
			System.out.println(tmpUphonenum);
			User tmpUser=userService.getUserByUphonenum(tmpUphonenum);//����ݿ���ȡ��user���滻ֻ��uphonenum�Ķ���???????Ϊʲô�ᱨ�?
			response.addCookie(new Cookie("uphonenum", tmpUphonenum));
			System.out.println("class-afterLogIn-break2");
			request.setAttribute("tmpUser", tmpUser);
			List<Rent> tmpRent=null;
			tmpRent=userService.getRentByUserPhonenum(tmpUphonenum);//?????????????
			request.setAttribute("tmpRent",tmpRent);
			
			return "/pages/user/personalCenter_lx.jsp";
		} else
			return "/fail.jsp";
	}
	@RequestMapping(value="/toUserDetail")//用户详情页
	public String toDetail(HttpServletRequest request)
	{
		Cookie[] cookie = request.getCookies();
		String uphonenum="";
		 for(int i = 0; i < cookie.length; i++)
	        {
	            if(cookie[i].getName().equals("uphonenum"))
	            {
	                uphonenum = cookie[i].getValue();
	                break;
	            }
	        }
		 if(uphonenum.equals(""))
		 {
			return "/user/toLogIn";
		}
		String tmpUphonenum=uphonenum;
		User tmpUser=userService.getUserByUphonenum(tmpUphonenum);//����ݿ���ȡ��user���滻ֻ��uphonenum�Ķ���???????Ϊʲô�ᱨ�?
		request.setAttribute("tmpUser", tmpUser);
		List<Rent> tmpRent=null;
		tmpRent=userService.getRentByUserPhonenum(tmpUphonenum);//?????????????}
		request.setAttribute("tmpRent",tmpRent);
		return "/pages/user/personalCenter_lx.jsp";
	}

	@RequestMapping("/toRegister")//注册
	public String toRegister()
	{
		return "/pages/user/register_lx.html";
	}
	@RequestMapping("/afterRegister")//注册以后去登陆
	public String afterRegister(User user)
	{
		//String tmpUphonenum=user.getUphonenum();
		try {
			userService.addUser(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "/fail.jsp";
		}
		return "/user/toLogIn";
	}
	

	
	
	@RequestMapping(value="/toRentPage")//去主要租车页面
	public String toRentPage(HttpServletRequest request){
		List<Bicycle> tmpBicycleList=null;
		tmpBicycleList=userService.getAllBicycleNotDamage();
		request.setAttribute("tmpBicycleList", tmpBicycleList);
		return "/pages/user/rentPage_feng.jsp";
	}
	@RequestMapping(value="/selectBicycle")//CX category
	public String selectBicycle(
			@RequestParam("btype")String btype,	HttpServletRequest request,HttpServletResponse response
			) {
			System.out.println("In the selectBicycle()");
			List<Bicycle> tmp = userService.selectBicycle(btype, null, null, 0, 9999, null, true);
			request.setAttribute("tmpBicycleList", tmp);
			return "/pages/user/rentPage_feng.jsp";
		}
	
	@RequestMapping(value="/updateBicycle")//CX
	public String updateBicycle(
			@RequestParam("bid")int bid, @RequestParam("columen_name")String column_name, String value,
			HttpServletRequest request,HttpServletResponse response
			)
	{
		userService.updateBicycle(bid, column_name, value);
		return "";
	}	
	@RequestMapping("/toBicycleDetial")//去主要租车页面
	public String toBicycleDetial(HttpServletRequest request){
		int bid=Integer.parseInt(request.getParameter("bid").toString());
		Bicycle tmpBicycle=userService.getBicycleByBid(bid);
		request.setAttribute("tmpBicycle", tmpBicycle);
		Calendar cal = Calendar.getInstance();
	    int currentTime = cal.get(Calendar.DATE);
		request.setAttribute("currentTime", currentTime);
		
		return "/pages/user/rentDetail_feng.jsp";
	}
	@RequestMapping("/afterRent")//租车以后
	public String afterRent(String rfee,String rrenttime,int bid,@CookieValue("uphonenum")String uphonenum)
	{
		if(uphonenum==null)
		{
			return "/fail.jsp";
		}
		Bicycle bicycle=userService.getBicycleByBid(bid);
		userService.addRent(rfee,rrenttime,bicycle,uphonenum);
		return "/user/toUserDetail";
	}
	
	
	
	//���۳���
	@RequestMapping("/toUploadSellInfo")//出售以后
	public String toUpladSellInfo(Bicycle bicycle){
		return "/pages/user/salePage_feng.html";
	}
	@RequestMapping("/afterUploadSellInfo")//出售以后
	public String afterUploadSellInfo(Bicycle bicycle){
		userService.sell(bicycle);
		return "/user/toHome";
	}
	@RequestMapping("/afterRequestRepair")//报修以后
	public String afterRequestRepair(Rent rent)
	{
		int tmpRid=rent.getRid();
		System.out.println("UserController-afterRequestRepair:"+tmpRid);
		Rent tmpRent=userService.getRentByRid(tmpRid);
		userService.repair(tmpRent);
		return "/user/toUserDetail";
	}
	
	
	
	//below are those meaningless pages controller 
	@RequestMapping("/toOfficalPage")//
	public String toOfficalPage()
	{
		return "/pages/user/officialPage_feng.html";
	}
	
	@RequestMapping("/toNewActivity")//
	public String toNewActivity()
	{
		return "/pages/user/newActivity_feng.html";
	}
	@RequestMapping("/toAboutUs")//
	public String toAboutUs()
	{
		return "/pages/user/aboutUs_lx.html";
	}
	@RequestMapping("/toGetMap")//
	public String toGetMap()
	{
		return "/pages/user/getmap_lx.html";
	}
}
