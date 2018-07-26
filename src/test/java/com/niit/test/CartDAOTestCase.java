package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
//import com.niit.dao.CartDAO;
import com.niit.model.CartItem;
import com.niit.model.Category;



public class CartDAOTestCase {

	static CartDAO cartDAO;
	@BeforeClass
	public static void executeFirst(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO = (CartDAO)context.getBean("CartDAO");
	}
	@Test
	public void addCartItemTestTest(){
		CartItem cartItem = new CartItem();
		//category.setCategoryId(1);
		cartItem.setProductId(2);
		cartItem.setProductName("samsung J7");
		cartItem.setQuantity(20);
		cartItem.setUsername("nandy");
		cartItem.setPrice(10000);
		cartItem.setStatus("NA");
		//categoryDAO.addCategory(category);
		assertTrue("Problem in Adding CartItem:",cartDAO.addCartItem(cartItem));
	}
	@Ignore
	@Test
	public void listCategoriesTest(){
		List<CartItem> cartItems = cartDAO.showCartItems("nandy");
		assertTrue("Problem in Showing CartItem:",cartItems.size()>0);
		for(CartItem cartItem:cartItems ){
			System.out.print(cartItem.getProductName()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.print(cartItem.getPrice()+":::");
			System.out.print(cartItem.getStatus()+":::");
		}}
	   @Ignore
		@Test
		public void getCartItemTestCase(){
			CartItem cartItem = cartDAO.getCartItem(2);
			assertNotNull("Problem in getting CartItem",cartItem);
			System.out.println("********************Getting a CartItem**********");
			System.out.print(cartItem.getProductName()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.print(cartItem.getPrice()+":::");
			System.out.print(cartItem.getStatus()+":::");
		}
	   @Ignore
		@Test
		public void deleteCartItemTestCase(){
			CartItem cartItem = cartDAO.getCartItem(2);
			assertTrue("Problem in deleting CartItem:",cartDAO.deleteCartItem(cartItem));
		}
	   @Ignore
		@Test
		public void updateCartItemTestCase(){
			CartItem cartItem = cartDAO.getCartItem(1);
			cartItem.setQuantity(10);
			assertTrue("Problem in updating CartItem:",cartDAO.updateCartItem(cartItem));
		}
}
