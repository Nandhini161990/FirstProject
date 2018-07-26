package com.niit.dao;

import org.hibernate.Query;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;
@Repository("OrderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {
	@Autowired
	SessionFactory sessionFact;
	public boolean insertOrderDetail(OrderDetail orderDetail) {
		try{
			sessionFact.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	public boolean updateOrderDetail(String username){
		try{
			Session session = sessionFact.openSession();
			Query query = session.createQuery("update CartItem set status='P' where username=:myusername and status='NA'");
			query.setParameter("myusername",username);
			int row_eff = query.executeUpdate();
			if(row_eff>0)
				return true;
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}
}
