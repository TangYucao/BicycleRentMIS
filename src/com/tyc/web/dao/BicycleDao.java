package com.tyc.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tyc.web.entity.Bicycle;
import com.tyc.web.entity.Manager;
import com.tyc.web.entity.Rent;
import com.tyc.web.entity.User;

public class BicycleDao{
private SessionFactory sessionFactory;
 
public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
//ע��
public void addBicycle(Bicycle bicycle) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().save(bicycle);
	
}

public void modBicycle(Bicycle bicycle) {//���Ҫ���ø÷���������뱣֤�����Ѿ�������һ����ô���Զ����¡��������save��
	// TODO Auto-generated method stub
	//wait!
	sessionFactory.getCurrentSession().update(bicycle);
}
//�û�����ά��
public void repair(Rent rent) {
	// TODO Auto-generated method stub
	String hql="update Bicycle b set bdamage='T' where b.bid=? "; 
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	query.setInteger(0, rent.getBicycle().getBid());
}

//�ܽ᣺�����Ҫ�ύɾ����update����Ҫ��ʵ��ҹ���
public static void main(String[] args) {
	BicycleDao bicycleDao=new BicycleDao();
	Configuration configuration=new Configuration().configure("/config/hibernatetest.cfg.xml");
	 SessionFactory sf =   configuration.buildSessionFactory();
     Session session = sf.openSession();
     Transaction trans=session.beginTransaction();
     //String hql="update Bicycle b set b.bdamage='T' where b.bid = ? ";
//     String hql="delete from Bicycle b where b.bid = ?";
//     String hql = "from Rent";
//     Query query=session.createQuery(hql);
//    // query.setInteger(0, 3);
////     System.out.println(query.toString());
//     List<Rent> tmp=null;
//	tmp=query.list();
//	System.out.println(tmp.size());
//	for(Rent st:tmp)
//	{
//		System.out.println("id:"+st.getRid()); 
//        System.out.println("name:"+st.getBicycle().getBrentmoney()); 
//        System.out.println("name:"+st.getBicycle().getBstatus()); 
//		
//	}
//     //query.executeUpdate();
//     trans.commit();
//     //query.setParameter(0, "1");
     Bicycle bicycle=new Bicycle();
     bicycle.setBid(1);
     float brentmoney=123.0f;
     bicycle.setBrentmoney(brentmoney);
     
     Rent rent=new Rent();
		User user=new User();
		String uphonenum="151";
		user.setUphonenum(uphonenum);
		rent.setBicycle(bicycle);
		rent.setUser(user);
		session.save(rent);
		 trans.commit();
	
}

public List<Bicycle> getAllBicycle() {
	String hql = " from Bicycle";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Bicycle> tmp=query.list();
	System.out.println(tmp.size());
	
	return tmp;
}

public Bicycle getBicycleByBid(int bid) {
	// TODO Auto-generated method stub
	String hql="from Bicycle b where b.bid=? "; 
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	query.setInteger(0, bid);
	Bicycle tmp=(Bicycle) query.uniqueResult();
	return tmp; 
}

//从鑫
public List<Bicycle> selectFromBicycle(String btype, String bdamage, String bstatus, float min_price, float max_price, String sort_name, boolean isASC)
{
	String hql = "from Bicycle";
	
	if (btype != null)
		hql += " where btype like \'" + btype + "\' ";
	else
		hql += " where btype like \'%\' ";
	
	if (bdamage != null)
		hql += " and bdamage like \'" + bdamage + "\' ";
	else
		hql += " and bdamage like \'%\' ";
	
	if (bstatus != null)
		hql += " and bstatus like \'" + bstatus + "\' ";
	else
		hql += " and bstatus like \'%\' ";
	
	hql += " and bpriceperday between " + min_price + " and " + max_price + " ";

	if (sort_name != null)
		hql += " order by " + sort_name + " ";
	else
		hql += " order by bid ";
	
	if (isASC)
		hql += " ASC ";
	else
		hql += " DESC ";
	
	Query query = sessionFactory.getCurrentSession().createQuery(hql);	
	List<Bicycle> list = query.list();
	return list;
}
public void updateBicycle(int bid, String column_name, String value)//By Cong Xin
{
	String hql = "";
	if (column_name.equals("bpriceperday")|| column_name.equals("brentmoney"))
		hql += "update Bicycle t set t." + column_name + "=" + value + " where t.bid=" + bid;
	else
		hql += "update Bicycle t set t." + column_name + "=\'" + value + "\' where t.bid=" + bid;
	
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	query.executeUpdate();
}
}
 