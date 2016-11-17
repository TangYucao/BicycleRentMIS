package com.tyc.web.service;

import com.tyc.web.dao.BicycleDao;
import com.tyc.web.entity.Bicycle;
public class BicycleService{
private BicycleDao bicycleDao;




public BicycleDao getBicycleDao() {
	return bicycleDao;
}

public void setBicycleDao(BicycleDao bicycleDao) {
	this.bicycleDao = bicycleDao;
}

public void addBicycle(Bicycle bicycle) {
	// TODO Auto-generated method stub
	bicycleDao.addBicycle(bicycle);
}

public void modBicycle(Bicycle bicycle) {
	// TODO Auto-generated method stub
	bicycleDao.modBicycle(bicycle);
}



}
