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
public class SupplierController {
	@Autowired
	public SupplierDAO supplierdao;
	@Autowired
	public CategoryDAO categorydao;

	@RequestMapping(value = "/supplier")
	public String showProductPage(Model m) {
		Supplier supplier = new Supplier();
		m.addAttribute(supplier);
		//m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList", supplierdao.listSupplier());
		return "SupplierInsert";
	}

	@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("suppname")String supplierName,@RequestParam("suppaddr")String supplierAddr, Model m){
		//flag=true;
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		supplierdao.addSupplier(supplier);
		List<Supplier> listSuppliers = supplierdao.listSupplier();
		m.addAttribute("supplierList", listSuppliers);
		//m.addAttribute("fla"g",flag);
		return "SupplierInsert";
	}
	//@RequestMapping(value="/deleteCategory/{categoryID}",method =RequestMethod.GET)
	@RequestMapping(value = { "/delete-{supplierID}-supplier" }, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("supplierID") int supplierId,Model m){
		//flag=false;
		Supplier supplier = supplierdao.getSupplier(supplierId)	;
		supplierdao.deleteSupplier(supplier);
		List<Supplier> listSuppliers = supplierdao.listSupplier();
	m.addAttribute("supplierList", listSuppliers);
	return "redirect:/supplier";
	}
	//@RequestMapping(value="/editCategory/{categoryID}",method =RequestMethod.GET)
	@RequestMapping(value = { "/edit-{supplierID}-supplier" }, method = RequestMethod.GET)
	public String editCategory(@PathVariable("supplierID") int supplierId,Model m){
		//flag=true;
		Supplier supplier = supplierdao.getSupplier(supplierId)	;


	//List<Category> listCategories = categorydao.listCategories();
	m.addAttribute("supplierData", supplier);
	//m.addAttribute("flag",flag);
	return "SupplierUpdate";
	}
	//@RequestMapping(value="/UpdateCategory",method =RequestMethod.POST)
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("suppid") int supplierId,@RequestParam("suppname")String supplierName,@RequestParam("suppAddr")String supplierAddr,Model m){
		//flag=true;
		Supplier supplier = new Supplier();
		supplier.setSupplierId(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		supplierdao.updateSupplier(supplier);
		List<Supplier> listSuppliers = supplierdao.listSupplier();
		m.addAttribute("supplierlist", listSuppliers);
	//m.addAttribute("categoryData", category);
	//m.addAttribute("flag",flag);
	//return "CategoryInsert";
		return "redirect:/supplier";	
	}
	}
