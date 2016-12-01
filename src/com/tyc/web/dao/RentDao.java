package com.tyc.web.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Manager;
import com.tyc.web.entity.Rent;
import com.tyc.web.entity.User;

public class RentDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addRent(String rfee,String rrenttime,Bicycle bicycle,String uphonenum)
	{
		Rent rent=new Rent();
		rent.setBicycle(bicycle);
		User user=new User();
		user.setUphonenum(uphonenum);

		rent.setUser(user);
		rent.setRfee(rfee);
		rent.setRrenttime(rrenttime);
		this.sessionFactory.getCurrentSession().save(rent);
	}

	public List<Rent> getRentByUserPhonenum(String uphonenum) {
		// TODO Auto-generated method stub
		Transaction trans=sessionFactory.getCurrentSession().beginTransaction();
		System.out.println("class-getRentByUserPhonenum-break1");
		String hql = "from Rent r where r.user.uphonenum=?";//where r.uphonenum=?
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,uphonenum);
		List<Rent> tmp=null;
		tmp=query.list();
		trans.commit();
		System.out.println(tmp.size());
		
		if (tmp!=null)	
			return tmp;
		else return null;
	}

	public Rent getRentByRid(int tmpRid) {
		// TODO Auto-generated method stub
		String hql="from Rent r where r.rid=? "; 
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		String tmpString=String.valueOf(tmpRid);
		query.setString(0, tmpString);
		Rent tmp=(Rent) query.uniqueResult();
		return tmp; 
	}

}
