package com.dinegrid.menu_service.controller;

import com.dinegrid.menu_service.dto.MenuItemRequest;
import com.dinegrid.menu_service.dto.MenuItemResponse;
import com.dinegrid.menu_service.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;


    @PostMapping
    public ResponseEntity<MenuItemResponse> addMenuItem(@Valid @RequestBody MenuItemRequest request) {
        log.info("Received request to add menu item: {}", request.getName());
        MenuItemResponse response = menuService.addMenuItem(request);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<MenuItemResponse>> getAllMenuItems() {
        log.info("Fetching all menu items");
        List<MenuItemResponse> response = menuService.getAllMenuItems();
        return ResponseEntity.ok(response);
    }

//test
    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponse> getMenuItemById(@PathVariable Long id) {
        log.info("Fetching menu item by id: {}", id);
        MenuItemResponse response = menuService.getMenuItemById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponse> updateMenuItem(
            @PathVariable Long id,
            @Valid @RequestBody MenuItemRequest request
    ) {
        log.info("Updating menu item id: {}", id);
        MenuItemResponse response = menuService.updateMenuItem(id, request);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        log.info("Deleting menu item id: {}", id);
        menuService.deleteMenuItem(id);
        return ResponseEntity.ok("Menu item deleted successfully.");
    }

}
