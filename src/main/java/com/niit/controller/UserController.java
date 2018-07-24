package com.niit.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDAO;
@Controller
public class UserController {
	@Autowired
	public ProductDAO productdao;
	@RequestMapping(value = "/login_success")
	public String loginSuccess(Model m,HttpSession session){
		
		String page="";
		boolean loggedIn=false;
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String username = authentication.getName();
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles){
			session.setAttribute("role", role.getAuthority());
			if(role.getAuthority().equals("ROLE_USER")){
				loggedIn=true;
				page="ProductDisplay";
				m.addAttribute("productList",productdao.listProducts());
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
			else{
				loggedIn=true;
				page="AdminHome";
				//m.addAttribute("productList",productdao.listProducts());
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
		}
		System.out.println("Login Success");
		return page;
	}
	/*@RequestMapping(value = "/p_logout")
	public String logoutSuccess(Model m,HttpSession session){
		 session = request.getSession(false);
	    session.invalidate();
	    return "Login";
	}*/

}
