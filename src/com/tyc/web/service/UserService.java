package com.tyc.web.service;

import java.util.List;

import com.tyc.web.dao.BicycleDao;
import com.tyc.web.dao.RentDao;
import com.tyc.web.dao.UserDao;
import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Rent;
import com.tyc.web.entity.User;

public class UserService{
private UserDao userDao;
private BicycleDao bicycleDao;
private RentDao rentDao;
public UserDao getUserDao() {
	return userDao;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

public void addUser(User user) {
	// TODO Auto-generated method stub
	userDao.addUser(user);
}

public boolean checkUser(User user) {
	// TODO Auto-generated method stub
	
	return userDao.checkUser(user);
}


//用户信息页面:返回attribute:user,rent,sell
public User getUserByUid(int uid)//返回个人信息
{
	return userDao.getUserByUid(uid);
}

public void sell(Bicycle bicycle) {
	// TODO Auto-generated method stub
	bicycle.setBstatus("F");
	bicycleDao.addBicycle(bicycle);
}

public void repair(Rent rent) {
	// TODO Auto-generated method stub
	bicycleDao.repair(rent);
}

public void addRent(Bicycle bicycle,String uphonenum) {
	// TODO Auto-generated method stub
	rentDao.addRent(bicycle,uphonenum);
}
public List<Rent> getRentByUserPhonenum(String uphonenum){
	System.out.println((bicycleDao == null));
	return rentDao.getRentByUserPhonenum(uphonenum);
}

public User getUserByUphonenum(String uphonenum) {
	// TODO Auto-generated method stub
	return userDao.getUserByUphonenum(uphonenum);
}

public BicycleDao getBicycleDao() {
	return bicycleDao;
}

public void setBicycleDao(BicycleDao bicycleDao) {
	this.bicycleDao = bicycleDao;
}

public RentDao getRentDao() {
	return rentDao;
}

public void setRentDao(RentDao rentDao) {
	this.rentDao = rentDao;
}
}
