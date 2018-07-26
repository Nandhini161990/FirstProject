package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.OrderDetailDAO;
import com.niit.model.OrderDetail;

public class OrderDetailDAOTestCase {

	static OrderDetailDAO orderDetailDAO;
	@BeforeClass
	public static void executeFirst(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDetailDAO = (OrderDetailDAO)context.getBean("OrderDetailDAO");
	}
	@Test
	public void insertOrderDetailTest(){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUsername("Geetha");
		orderDetail.setTotalPurchaseAmount(45000);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPaymentMode("CC");
		assertTrue("Problem in Inserting OrderDetail:",orderDetailDAO.insertOrderDetail(orderDetail));
	}
	@Test
	public void updateCartItemsStatus(){
		assertTrue("Problem in Updating CartItem:",orderDetailDAO.updateOrderDetail("Geetha"));
	}
}
