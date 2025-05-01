package com.dinegrid.menu_service.service;

import com.dinegrid.menu_service.dto.MenuItemRequest;
import com.dinegrid.menu_service.dto.MenuItemResponse;

import java.util.List;

public interface MenuService {

    MenuItemResponse addMenuItem(MenuItemRequest menuItem);

    List<MenuItemResponse> getAllMenuItems();

    MenuItemResponse getMenuItemById(Long id);

    MenuItemResponse updateMenuItem(Long id, MenuItemRequest menuItem);

    void deleteMenuItem(Long id);
}
