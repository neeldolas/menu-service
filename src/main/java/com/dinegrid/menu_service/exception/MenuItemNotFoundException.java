package com.dinegrid.menu_service.exception;

public class MenuItemNotFoundException extends RuntimeException {
    public MenuItemNotFoundException(Long id) {
        super("Menu item with ID " + id + " not found.");
    }
}

