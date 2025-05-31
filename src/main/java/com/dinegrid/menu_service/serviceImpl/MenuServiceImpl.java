package com.dinegrid.menu_service.serviceImpl;

import com.dinegrid.menu_service.dto.MenuItemRequest;
import com.dinegrid.menu_service.dto.MenuItemResponse;
import com.dinegrid.menu_service.entity.MenuEntity;
import com.dinegrid.menu_service.exception.MenuItemNotFoundException;
import com.dinegrid.menu_service.exception.ResourceNotFoundException;
import com.dinegrid.menu_service.mapper.MenuItemMapper;
import com.dinegrid.menu_service.repository.MenuRepository;
import com.dinegrid.menu_service.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuItemMapper menuItemMapper;

    @Override
    @CachePut(value = "menuItems", key = "#result.id")
    public MenuItemResponse addMenuItem(MenuItemRequest menuItem) {
        MenuEntity menuItemEntity = menuItemMapper.toEntity(menuItem);
        MenuEntity savedItem = menuRepository.save(menuItemEntity);
        return menuItemMapper.toResponse(savedItem);
    }

    @Override
    public List<MenuItemResponse> getAllMenuItems() {
        return menuRepository.findAll()
                .stream()
                .map(menuItemMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "menuItems", key = "#id")
    @Override
    public MenuItemResponse getMenuItemById(Long id) {
        return menuRepository.findById(id)
                .map(menuItemMapper::toResponse)
                .orElseThrow(() -> new MenuItemNotFoundException(id));
    }


    @Override
    @CacheEvict(value = "menuItems", key = "#id")
    public MenuItemResponse updateMenuItem(Long id, MenuItemRequest request) {
        log.info("Updating menu item with id: {}", id);
        MenuEntity existingItem = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found with id: " + id));

        menuItemMapper.updateEntityFromDto(request, existingItem);

        MenuEntity updatedItem = menuRepository.save(existingItem);
        log.info("Menu item updated: {}", updatedItem.getId());
        return menuItemMapper.toResponse(updatedItem);
    }

    @Override
    @CacheEvict(value = "menuItems", key = "#id")
    public void deleteMenuItem(Long id) {
        log.info("Deleting menu item with id: {}", id);
        if (!menuRepository.existsById(id)) {
            throw new ResourceNotFoundException("Menu item not found with id: " + id);
        }
        menuRepository.deleteById(id);
        log.info("Deleted menu item with id: {}", id);
    }
}
