//����ط�����Ϊview
package com.tyc.web.controller;

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
	public String afterLogIn(User user,HttpServletResponse response) {
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
			return "forward:/user/toUserDetail";
		} else
			return "/fail.jsp";
	}


	@RequestMapping("/toRegister")//注册
	public String toRegister()
	{
		return "/pages/user/register_lx.html";
	}
	@RequestMapping("/afterRegister")//注册以后去登陆
	public String afterRegister(User user)
	{
		userService.addUser(user);
		return "/user/toLogIn";
	}
	

	
	
	@RequestMapping("/toRentPage")//租车以后
	public String toRentPage(){
		return "/pages/user/rentPage_feng.html";
	}
	@RequestMapping("/afterRent")//租车以后
	public String afterRent(Bicycle bicycle,@CookieValue("uphonenum")String uphonenum)
	{
		userService.addRent(bicycle,uphonenum);
		return "/user/toUserDetail";
	}
	
	//����ҳ��
	@RequestMapping(value="/toUserDetail",method=RequestMethod.POST)//用户详情页
	public String toDetail(@CookieValue("uphonenum")String uphonenum,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("cookie-uphonenum:"+uphonenum);//�ɹ��õ�
		System.out.println("class-toDetail-break1");
		User tmpUser=userService.getUserByUphonenum(uphonenum);
		request.setAttribute("tmpUser", tmpUser);
		//String tmpUphonenum=tmpUser.getUphonenum();
		System.out.println("class-toDetail-break2");
		List<Rent> tmpRent=null;
		tmpRent=userService.getRentByUserPhonenum(uphonenum);//?????????????
		request.setAttribute("tmpRent",tmpRent);
		System.out.println("class-toDetail-break3");
		//request.setAttribute("rent");
		return "/pages/user/personalCenter_lx.jsp";
	}
	
	//���۳���
	@RequestMapping("/toUpladSellInfo")//出售以后
	public String toUpladSellInfo(Bicycle bicycle){
		return "/pages/user/salePage_feng.html";
	}
	@RequestMapping("/afterUploadSellInfo")//出售以后
	public String afterUploadSellInfo(Bicycle bicycle){
		userService.sell(bicycle);
		return "/success.jsp";
	}
	@RequestMapping("/afterRequestRepair")//报修以后
	public String afterRequestRepair(Rent rent)
	{
		userService.repair(rent);
		return "/success.jsp";
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
