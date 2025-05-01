package com.dinegrid.menu_service.mapper;

import com.dinegrid.menu_service.dto.MenuItemRequest;
import com.dinegrid.menu_service.dto.MenuItemResponse;
import com.dinegrid.menu_service.entity.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuEntity toEntity(MenuItemRequest request);

    MenuItemResponse toResponse(MenuEntity menuItem);

    void updateEntityFromDto(MenuItemRequest request, @MappingTarget MenuEntity existingItem);
}
