package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	

	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public String addCartItem(@RequestParam("quantity")int quantity, @RequestParam("productId")int productId,
			HttpSession session, Model m) {
		//CartController cart = new CartController();
		Product product = productDAO.getProduct(productId);
		String username = (String)session.getAttribute("username");
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setUsername(username);
		cartItem.setStatus("NA");
		cartDAO.addCartItem(cartItem);
		String mystatus = cartItem.getStatus();
		List<CartItem> cartItems = cartDAO.showCartItems(username);
		
		m.addAttribute("cartItems", cartItems);
		/*for(CartItem cartitem:cartItems){
			System.out.println(cartitem.getProductId());
			System.out.println(cartitem.getProductName());
		}*/
		m.addAttribute("totalPurchaseAmount",this.calcTotalPurchaseAmount(cartItems));
		System.out.println("tpa:"+this.calcTotalPurchaseAmount(cartItems));
		return "Cart";
	}

	public int calcTotalPurchaseAmount(List<CartItem> cartItems) {
		int totalPurchaseAmount = 0;
		int count = 0;
		System.out.println(cartItems.size());
		while (count < cartItems.size()) {
			CartItem cartItem = cartItems.get(count);
			System.out.println(cartItem.getPrice());
			totalPurchaseAmount = totalPurchaseAmount + cartItem.getQuantity() * cartItem.getPrice();
			count++;
		}
		return totalPurchaseAmount;
	}

	@RequestMapping(value = { "/updateCartItem" }, method = RequestMethod.POST)
	public String updateCartItem(@RequestParam("quantity") int quantity, @RequestParam("cartItemId")int cartItemId,
			HttpSession session, Model m) {
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		String username = (String) session.getAttribute("username");
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		String mystatus = cartItem.getStatus();
		List<CartItem> cartItems = cartDAO.showCartItems(username);
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
		return "Cart";
	}

	@RequestMapping(value={"/deleteCartItem-{cartItemId}-cartItem"},method = RequestMethod.GET)
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, HttpSession session, Model m) {
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		String username = (String) session.getAttribute("username");
		cartDAO.deleteCartItem(cartItem);
		String mystatus = cartItem.getStatus();
		List<CartItem> cartItems = cartDAO.showCartItems(username);
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
		return "Cart";
	}
	@RequestMapping(value = "/continueShopping")
	public String continueShopping(Model m) {
		m.addAttribute("productList",productDAO.listProducts());
		return "ProductDisplay";
	}
}
