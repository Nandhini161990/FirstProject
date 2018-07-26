package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	 
		@Autowired
		SessionFactory sessionFact;
		
		public boolean registerUser(UserDetail userDetail)
		{
			try
			{
				sessionFact.getCurrentSession().save(userDetail);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
			
		}
		
		public boolean updateUserDetail(UserDetail userDetail)
		{
			try
			{
				sessionFact.getCurrentSession().saveOrUpdate(userDetail);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

		
		/*public List<String> getUserDetail(String username)
		{
			Session session = sessionFact.getCurrentSession();
			UserDetail userDetail = session.get(UserDetail.class,username);
		    //List<String> UserDetailslist = new ArrayList<String>();
		    //UserDetailslist.add(userDetail.getPassword());
		    UserDetailslist.add(userDetail.getRole());
			//session.close();
			return UserDetailslist;
		}*/
		public UserDetail getUserDetail(String username)
		{
			System.out.println("hi");
			Session session = sessionFactory.getCurrentSession();
			UserDetail userDetail = (UserDetail)session.get(UserDetail.class,username);
			//session.close();
			return userDetail;
			//session.close();
		}
		public List<UserDetail> listUserDetails()
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UserDetail");
			List<UserDetail> listUserDetails = query.list();
			return listUserDetails;
		}
		
}
