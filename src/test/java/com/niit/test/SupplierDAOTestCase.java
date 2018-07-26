package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	public static SupplierDAO supplierDAO;
		@BeforeClass
		public static void executeFirst(){
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		}
		@Ignore	
	@Test
	public void addSupplierTest(){
		
		Supplier supplier = new Supplier();
		//supplier.setSupplierId(1001);
		supplier.setSupplierName("rem");
		supplier.setSupplierAddr("10,n.j.road,kodambakkam");
		//supplierDAO.addSupplier(supplier);
		assertEquals("Success",true,supplierDAO.addSupplier(supplier));
	
		
	}
		@Ignore
	@Test
	public void updateSupplierTest(){
		Supplier supplier = supplierDAO.getSupplier(1);
		supplier.setSupplierName("Paul");
		supplier.setSupplierAddr("101,H.N.road,T.Nagar");
		assertTrue("Problem in Updating Supplier:",supplierDAO.updateSupplier(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest(){
		try{
		Supplier supplier = supplierDAO.getSupplier(6);
		assertTrue("Problem in Deleting Supplier:",supplierDAO.deleteSupplier(supplier));}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void listSupplierTest(){
		List<Supplier> listSupplier = supplierDAO.listSupplier();
		assertTrue("Problem in Listing Category:",listSupplier.size()>0);
		for(Supplier supplier:listSupplier ){
			System.out.println(supplier.getSupplierId()+":::");
			System.out.println(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierAddr()+":::");
		}
	}

}

