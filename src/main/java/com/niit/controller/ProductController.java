package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	public ProductDAO productdao;
	@Autowired
	public CategoryDAO categorydao;
	@Autowired
	public SupplierDAO supplierdao;

	@RequestMapping(value = "/product")
	public String showProductPage(Model m) {
		Product product = new Product();
		m.addAttribute(product);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		m.addAttribute("productList", productdao.listProducts());
		return "ManageProduct";
	}

	@RequestMapping(value = "/ProductInsert", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,
			@RequestParam("pimage") MultipartFile imageFile, Model m) {

		productdao.addProduct(product);
		// System.out.println("Product Added");
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("supplierList", this.getSuppliers());
		Product product1 = new Product();
		String path = "C:\\Users\\HARISH\\workspace\\MyBazaaarFrontend\\src\\main\\webapp\\resources\\images\\";
		path = path + String.valueOf(product.getProductId()) + ".jpg";
		File file = new File(path);
		if (!imageFile.isEmpty()) {
			try {
				System.out.println("hi");
				byte[] buffer = imageFile.getBytes();
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(buffer);
				fos.close();
				//BufferedOutputStream bs = new BufferedOutputStream(fos);
				//bs.close();
			} catch (Exception e) {
				System.out.println("Exception Arised:" + e);
			}
		} else {
			m.addAttribute("ErrorInfo", "There is System Problem No Image Insertion");
		}
		m.addAttribute(product1);
		m.addAttribute("productList", productdao.listProducts());
		return "ManageProduct";
	}

	@RequestMapping("/productDisplay")
	public String displayAllProducts(Model m) {
		//ProductDAO productdao;
		//Product product = new Product();
		//m.addAttribute(product);
		List<Product> listProduct = productdao.listProducts();
		m.addAttribute("productList", productdao.listProducts());
		for(Product product:listProduct ){
			System.out.println(product.getProductId()+":::");
			System.out.println(product.getProductName()+":::");
			System.out.println(product.getProductDesc()+":::");
		}
		return "ProductDisplay";
	}
	@RequestMapping(value = {"/totalProductInfo-{productId}-product"},method = RequestMethod.GET)
	public String showTotalProductDisplay(@PathVariable("productId")int productId,Model m){
		Product product = productdao.getProduct(productId);
		m.addAttribute("product",product);
		m.addAttribute("categoryName",categorydao.getCategory(product.getCategoryId()).getCategoryName());
		return "TotalProductDisplay";
	}

	//@RequestMapping(value = "/deleteProduct/{productID}")
	@RequestMapping(value={"/delete-{productID}-product"},method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productID") int productId, Model m) {

		Product product = productdao.getProduct(productId);
		productdao.deleteProduct(product);
		// System.out.println("Product Added");
		// m.addAttribute("categoryList",this.getCategories());
		// Product product1 = new Product();
		m.addAttribute(product);
		m.addAttribute("productList", productdao.listProducts());
		return "redirect:/product";
	}

	//@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	@RequestMapping(value = { "/edit-{productId}-product" }, method = RequestMethod.GET)
	public String editProduct(@PathVariable("productId") int productId, Model m) {

		Product product = productdao.getProduct(productId);
		// productdao.deleteProduct(product);
		// System.out.println("Product Added");
		// m.addAttribute("categoryList",this.getCategories());
		
		
		System.out.println("Update -> " + product.getProductId());
		m.addAttribute(product);
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("productList", productdao.listProducts());
		return "UpdateProduct";
	}

	@RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product, Model m) {

		System.out.println(product.getProductId());
		productdao.updateProduct(product);
		// System.out.println("Product Added");
		//Product product1 = new Product();
		
		
		product.setProductId(product.getProductId());
		m.addAttribute(product);
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("productList", productdao.listProducts());
		return "redirect:/product";
	}

	public LinkedHashMap<Integer, String> getCategories() {
		List<Category> listCategories = categorydao.listCategories();
		LinkedHashMap<Integer, String> categoryData = new LinkedHashMap<Integer, String>();
		for (Category category : listCategories) {
			categoryData.put(category.getCategoryId(), category.getCategoryName());
		}
		return categoryData;
	}
	public LinkedHashMap<Integer, String> getSuppliers() {
		List<Supplier> listSuppliers = supplierdao.listSupplier();
		LinkedHashMap<Integer, String> supplierData = new LinkedHashMap<Integer, String>();
		for (Supplier supplier : listSuppliers) {
			supplierData.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return supplierData;
	}
}
