package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.controller.CartController;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.repository.CartRepository;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartItemService {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	 UserRepository userRepository;
	@Autowired
	 MenuItemRepository menuRepository;

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	public void addCartItem(int userId, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		LOGGER.info("ADD CART ITEM");
		Cart c=new Cart();
		c.setUser(userRepository.getOne(userId));
		c.setMenuItem(menuRepository.getOne((int)menuItemId));
	cartRepository.save(c);
	LOGGER.info("END");
		
		
	}

	public void removeCartItem(int userId, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		 cartRepository.removeItem(userId,menuItemId);
		 LOGGER.info("END");
	}

	public List<Cart> getAllCartItems(int i) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		LOGGER.info("Get All Cart Items");
		return cartRepository.findById(i);
		
	}

	
	
}
