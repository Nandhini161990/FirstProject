package com.niit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
import com.niit.dao.CategoryDAOImpl;
@Controller
public class CategoryController {
	@Autowired
	public CategoryDAO categorydao;
	//boolean flag=false;
	
@RequestMapping(value="/category")
public String showCategoryPage(Model m){
	//flag=false;
	List<Category> listCategories = categorydao.listCategories();
	m.addAttribute("categorylist", listCategories);
	//m.addAttribute("flag",flag);
	return "CategoryInsert";
}
@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
public String insertCategory(@RequestParam("catname")String categoryName,@RequestParam("catDesc")String categoryDesc, Model m){
	//flag=true;
	Category category = new Category();
	category.setCategoryName(categoryName);
	category.setCategoryDesc(categoryDesc);
	categorydao.addCategory(category);
	List<Category> listCategories = categorydao.listCategories();
	m.addAttribute("categorylist", listCategories);
	//m.addAttribute("flag",flag);
	return "CategoryInsert";
}
//@RequestMapping(value="/deleteCategory/{categoryID}",method =RequestMethod.GET)
@RequestMapping(value = { "/delete-{categoryID}-category" }, method = RequestMethod.GET)
public String deleteCategory(@PathVariable("categoryID") int categoryId,Model m){
	//flag=false;
Category category = categorydao.getCategory(categoryId)	;
categorydao.deleteCategory(category);
List<Category> listCategories = categorydao.listCategories();
m.addAttribute("categorylist", listCategories);
return "redirect:/category";
}
//@RequestMapping(value="/editCategory/{categoryID}",method =RequestMethod.GET)
@RequestMapping(value = { "/edit-{categoryID}-category" }, method = RequestMethod.GET)
public String editCategory(@PathVariable("categoryID") int categoryId,Model m){
	//flag=true;
Category category = categorydao.getCategory(categoryId);

//List<Category> listCategories = categorydao.listCategories();
m.addAttribute("categoryData", category);
//m.addAttribute("flag",flag);
return "CategoryUpdate";
}
//@RequestMapping(value="/UpdateCategory",method =RequestMethod.POST)
@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
public String updateCategory(@RequestParam("catid") int categoryId,@RequestParam("catname")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m){
	//flag=true;
	Category category = new Category();
	category.setCategoryId(categoryId);
	category.setCategoryName(categoryName);
	category.setCategoryDesc(categoryDesc);
	categorydao.updateCategory(category);
	List<Category> listCategories = categorydao.listCategories();
	m.addAttribute("categorylist", listCategories);
//m.addAttribute("categoryData", category);
//m.addAttribute("flag",flag);
//return "CategoryInsert";
	return "redirect:/category";	
}
}

