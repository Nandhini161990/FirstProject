package com.niit.dao;

import java.util.List;

//import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.niit.model.Category;
import com.niit.model.Product;
@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFact;
	@Autowired
	HibernateTransactionManager transactionMyManager;
	public boolean addProduct(Product product) {
		try
		{
			sessionFact.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try
		{
			//Session session = sessionFact.getCurrentSession();
			// product = (Product)session.get(Product.class,product.getProductId());
//			product.setProductName(product.getProductName());
//			product.setProductDesc(product.getProductDesc());
//			product.setPrice(product.getPrice());
//			product.setStock(product.getStock());
//			product.setCategoryId(product.getCategoryId());
//			product.setStock(product.getStock());
			
			//sessionFact.openSession().update(product);
			//Transaction tx = transactionMyManager.getSessionFactory().openSession().beginTransaction();
			//Transaction tx = null;
			Session session = sessionFact.openSession();
			Transaction tx = session.beginTransaction();
			session.update(product);
			tx.commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try
		{
			sessionFact.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Product getProduct(int productId) {
		/*Session session = sessionFact.getCurrentSession();
		Product product = (Product)session.get(Product.class,productId);*/
		//session.close();
		Session session = sessionFact.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product)session.get(Product.class,productId);
		tx.commit();
		session.close();
		return product;
	}

	public List<Product> listProducts() {
		Session session = sessionFact.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> listProducts = query.list();
		return listProducts;
	}

	

	

	

}

