package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;





public class ProductDAOTestCase {
	public static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("ProductDAO");
	}
	
	@Ignore
@Test
public void addProductTest(){
	Product product = new Product();
	//supplier.setSupplierId(1001);
	product.setProductName("shampoo");
	product.setProductDesc("anti-hairfall shampoo");
	//productDAO.addProduct(product);
	assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
}
	@Ignore
@Test
public void updateProductTest(){
	Product product = productDAO.getProduct(2);
	product.setProductName("detergent");
	product.setProductDesc("dishwashing liuid");
	assertTrue("Problem in Updating product:",productDAO.updateProduct(product));
}
	@Ignore
@Test
public void deleteProductTest(){
	Product product = productDAO.getProduct(2);
	assertTrue("Problem in Deleting Product:",productDAO.deleteProduct(product));
}

@Test
public void listProductTest(){
	List<Product> listProduct = productDAO.listProducts();
	assertTrue("Problem in Listing Category:",listProduct.size()>0);
	for(Product product:listProduct ){
		System.out.println(product.getProductId()+":::");
		System.out.println(product.getProductName()+":::");
		System.out.println(product.getProductDesc()+":::");
	}

}}

