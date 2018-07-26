package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.niit.model.Category;
import com.niit.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	
	
		@Autowired
		SessionFactory sessionFactory;
		
		public boolean addSupplier(Supplier supplier)
		{
				System.out.println("hi");
				sessionFactory.getCurrentSession().save(supplier);
				return true;
			
			
			
		}
		
		public boolean updateSupplier(Supplier supplier)
		{
			try
			{
				sessionFactory.getCurrentSession().saveOrUpdate(supplier);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}

		public boolean deleteSupplier(Supplier supplier)
		{
			try
			{
				sessionFactory.getCurrentSession().delete(supplier);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		public Supplier getSupplier(int supplierId)
		{
			Session session = sessionFactory.getCurrentSession();
			Supplier supplier = (Supplier)session.get(Supplier.class,supplierId);
			//session.close();
			return supplier;
		}
		public List<Supplier> listSupplier()
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Supplier");
			List<Supplier> listSupplier = query.list();
			return listSupplier;
		}
}

