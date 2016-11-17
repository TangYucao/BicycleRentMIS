package com.tyc.web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tyc.web.entity.User;

public class UserDao{
private SessionFactory sessionFactory;
 
public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
//注册
public void addUser(User user) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().save(user);
	
}

//会在登陆和注册时候用到
public boolean checkUser(User user) {
	String hql="from User u where u.uphonenum=? and u.upasswd=?"; 
	System.out.println("class-checkUser-user"+user.getUphonenum());
	System.out.println(user.getUpasswd());
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	query.setString(0, user.getUphonenum());
	query.setString(1, user.getUpasswd());   
	User tmp=(User) query.uniqueResult();
	if(tmp != null) 
		{System.out.println("checkUser-true");
	return true;}
	return false;
}

//用户信息页面:返回attribute:user,rent,sell
public User getUserByUid(int uid)//返回个人信息
{	
	String hql="from User u where u.uid=? "; 
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	query.setInteger(0, uid);
	User tmp=(User) query.uniqueResult();
	return tmp; 
}

public User getUserByUphonenum(String uphonenum) {
	//System.out.println("这个方法tmd不行？？？");
	String hql="from User u where u.uphonenum=? "; 
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	query.setString(0, uphonenum);
	User tmp=(User) query.uniqueResult();
	return tmp; 
}


}
 