package com.niit.dao;

import java.util.List;

import org.hibernate.Query;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
@Autowired
SessionFactory sessionFactory;
	public boolean addCartItem(CartItem cartItem) {
		try{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean updateCartItem(CartItem cartItem) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public List<CartItem> showCartItems(String username) {
		Session session = sessionFactory.getCurrentSession();
		/*CartItem cartit = new CartItem();
		cartit.setStatus("NA");
		String mystatus = cartit.getStatus();*/
		Query query = session.createQuery("from CartItem where username=:myusername and status='NA'");
		query.setParameter("myusername",username);
		//query.setParameter("status",NA);
		List<CartItem> listCartItems = (List<CartItem>)query.list();
		for(CartItem cartitem:listCartItems){
			System.out.println(cartitem.getProductId());
			System.out.println(cartitem.getProductName());
			System.out.println(cartitem.getPrice());
		}
		return listCartItems;
	}

	public CartItem getCartItem(int cartItemId) {
		Session session = sessionFactory.getCurrentSession();
		CartItem cartItem = (CartItem)session.get(CartItem.class,cartItemId);
		return cartItem;
	}
	

}
