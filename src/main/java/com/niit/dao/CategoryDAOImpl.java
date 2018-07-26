package com.niit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFact;
	private boolean b = true;
	Category category = new Category();
	
	public boolean addCategory(Category category) {
		sessionFact.getCurrentSession().save(category);
		
		System.out.println(category.getCategoryDesc()+category.getCategoryId()+category.getCategoryName());
		return true;
	}
	
	/*public boolean addCategory(Category category)
	{
		
	
			sessionFactory.getCurrentSession().save(category);
			return true;
		
		catch(Exception e)
		{
			return false;
		}
		
	}*/
	
	public boolean updateCategory(Category category)
	{
		try
		{
			Session session = sessionFact.openSession();
			Transaction tx = session.beginTransaction();
			session.update(category);
			tx.commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteCategory(Category category)
	{
		try
		{
			sessionFact.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public Category getCategory(int categoryId)
	{
		System.out.println("hi");
		Session session = sessionFact.getCurrentSession();
		Category category = (Category)session.get(Category.class,categoryId);
		//session.close();
		return category;
		//session.close();
	}
	public List<Category> listCategories()
	{
		Session session = sessionFact.getCurrentSession();
		Query query = session.createQuery("from Category");
		List<Category> listCategories = query.list();
		return listCategories;
	}
	
}

