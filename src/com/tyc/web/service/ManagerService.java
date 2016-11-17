package com.tyc.web.service;

import java.util.List;

import com.tyc.web.dao.BicycleDao;
import com.tyc.web.dao.ManagerDao;
import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Manager;
import com.tyc.web.entity.Rent;

public class ManagerService{
private ManagerDao managerDao;
private BicycleDao bicycleDao;

public ManagerDao getManagerDao() {
	return managerDao;
}


public void setManagerDao(ManagerDao managerDao) {
	this.managerDao = managerDao;
}


public boolean checkManager(Manager manager) {
	// TODO Auto-generated method stub
	
	return managerDao.checkManager(manager);
}
public List<Manager> queryAllManager(){
	return managerDao.queryAllManager();
}


public void addBicycle(Bicycle bicycle) {
	// TODO Auto-generated method stub
	bicycleDao.addBicycle(bicycle);
}


public BicycleDao getBicycleDao() {
	return bicycleDao;
}


public void setBicycleDao(BicycleDao bicycleDao) {
	this.bicycleDao = bicycleDao;
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
