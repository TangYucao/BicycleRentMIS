package com.tyc.web.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tyc.web.entity.Manager;
import com.tyc.web.entity.User;

public class ManagerDao {
	private SessionFactory sessionFactory;
 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean checkManager(Manager manager) {
		String hql = "from Manager m where m.mid=? and m.passwd=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, manager.getMid());
		query.setString(1, manager.getPasswd());
		Manager tmp = (Manager) query.uniqueResult();
		if (tmp != null)
			return true;
		return false;
	}
	
	public List<Manager> queryAllManager()
	{
		String hql = " from Manager";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Manager> tmp=query.list();
		System.out.println(tmp.size());
		
		for(Manager managerTmp:tmp)
		{
			System.out.println(managerTmp.getMid());
			System.out.println(managerTmp.getPasswd());
		}
		return tmp;
	}
}
