package com.dinegrid.menu_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MenuItemRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;
    @NotNull(message = "Price cannot be null")
    private Double price;
    private Boolean available;
}
