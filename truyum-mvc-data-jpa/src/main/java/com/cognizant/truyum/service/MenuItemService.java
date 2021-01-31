package com.cognizant.truyum.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.MenuItemController;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;


/**
 * 
 * 
 * @see MenuItemDaoSqlImpl
 *
 */

@Service
public class MenuItemService {
	/**
	 * MenuItemService class is the implementation of the service layer
	 * menuItemDao attribute is injected using spring-config.xml
	 * bean menuItemDao is auto wired with MenuItemCollectionDaoImpl object
	 */
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	/**
	 * getMenuItemListAdmin() method return the list of menu items which are
	 * displayed to admin
	 * 
	 * @return list of menu items for admin
	 */

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Start");
		return this.menuItemRepository.findAll();
		
	}

	/**
	 * getMenuItemListCustomer() returns list of menu items which are available for
	 * customers
	 * 
	 * @return list of menu items for customers
	 */

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");
		return this.menuItemRepository.findCustomerMenuItems();
	}

	/**
	 * getMenuItem() returns the MenuItem based on menuItemId menuItemDao is used
	 * for invoking the methods for getting MenuItem
	 * 
	 * @param menuItemId
	 * @return MenuItem for the given menuItemId
	 */

	
	public MenuItem getMenuItem(long menuItemId) {

		return menuItemRepository.getOne((int)menuItemId);
	}

	/**
	 * editMenuItem() takes
	 * 
	 * @param menuItem modifies the menu item and gets the updated menu item
	 */

	@Transactional
	public void editMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		MenuItem menu=menuItemRepository.getOne(menuItem.getId());
		menu.setName(menuItem.getName());
		menu.setActive(menuItem.getActive());
		menu.setFreeDelivery(menuItem.getFreeDelivery());
		menu.setDateOfLaunch(menuItem.getDateOfLaunch());
		menu.setId(menuItem.getId());
		menu.setPrice(menuItem.getPrice());
		menu.setCategory(menuItem.getCategory());
		menuItemRepository.save(menu);
		LOGGER.info("End");

	}

}
