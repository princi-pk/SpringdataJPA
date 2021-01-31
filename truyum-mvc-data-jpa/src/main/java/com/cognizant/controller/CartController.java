package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.repository.CartEmptyException;
import com.cognizant.truyum.service.CartItemService;

/**
 * 
 * @author Shiyam CartController used to handle request from carts of users
 * @see CartItemService
 *
 */
@SessionAttributes("userId")
@Controller
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
     CartItemService service;

	/**
	 * addToCart method used to add cart to the items
	 * 
	 * @param menuItemId
	 * @param map
	 * @param redirectAttributes
	 * @return
	 * @throws CartEmptyException
	 */

	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam("id") long menuItemId, @RequestParam("userId") int userId, ModelMap map,
			final RedirectAttributes redirectAttributes) throws CartEmptyException {
		LOGGER.info("addToCart -Start");
		System.out.println("================================"+menuItemId+" ==="+userId);
		service.addCartItem(userId, menuItemId);
		redirectAttributes.addFlashAttribute("addCartStatus", true);
		LOGGER.info("addToCart -End");
		return "redirect:/show-menu-list-customer";

	}

	/**
	 * showCart method used to show the user cart
	 * 
	 * @param map
	 * @return
	 */

	@GetMapping("/show-cart")
	public String showCart(ModelMap map) throws CartEmptyException {
		LOGGER.info("showCart -Start");
		//Cart cart = null;
		List<Cart> cart;
		cart =  service.getAllCartItems(1);
		map.addAttribute("cart", cart);
		int total=0;
		if(cart.size()==0)
		{
			return "cart-empty";
		}
		for(Cart carts:cart)
		{
			total+=carts.getMenuItem().getPrice();
		}
	   map.put("total",total);
	   System.out.println("*************************************************"+total);
		LOGGER.info("showCart -End");
		return "cart";

	}

	/**
	 * removeCart method used to remove items from cart
	 * 
	 * @param menuItemId
	 * @param map
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/remove-cart")
	public String removeCart(@RequestParam("id") long menuItemId, @RequestParam("userId") int userId, ModelMap map,
			final RedirectAttributes redirectAttributes) {
		LOGGER.info("removeCart -Start");
		service.removeCartItem(userId, menuItemId);
		redirectAttributes.addFlashAttribute("removeCartItemStatus", true);
		LOGGER.info("removeCart -End");
		return "redirect:/show-cart";
	}

}
