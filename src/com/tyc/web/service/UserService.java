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


//�û���Ϣҳ��:����attribute:user,rent,sell
public User getUserByUid(int uid)//���ظ�����Ϣ
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

public List<Bicycle> getAllBicycle() {
	// TODO Auto-generated method stub
	return bicycleDao.getAllBicycle();
}


public Bicycle getBicycleByBid(int bid) {
	// TODO Auto-generated method stub
	Bicycle tmp=bicycleDao.getBicycleByBid(bid);
	return tmp;
}

public List<Bicycle> selectBicycle(String btype, String bdamage, String bstatus, //By　Cong Xin
		float min_price, float max_price, String sort_name, boolean isASC){
	return bicycleDao.selectFromBicycle(btype, bdamage, bstatus, min_price, max_price, sort_name, isASC);
}

public void updateBicycle(int bid, String column_name, String value){//By　Cong Xin
	bicycleDao.updateBicycle(bid, column_name, value);
}
}
