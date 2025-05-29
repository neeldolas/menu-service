package com.dinegrid.menu_service.serviceImpl;

import com.dinegrid.menu_service.dto.OrderPlacedEvent;
import com.dinegrid.menu_service.entity.MenuEntity;
import com.dinegrid.menu_service.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderEventListner {

    private final MenuRepository menuRepository;

//   @KafkaListener(topics = "order-events", groupId = "menu-service-group")
//    public void consumeOrderEvent(String message) {
//        log.info("Received order event: {}", message);
//
//        // Optional: parse message and act on it
//        // You can deserialise JSON if needed later
//    }

//    @KafkaListener(topics = "order-events", groupId = "menu-service-group")
//    public void consumeOrderEvent(OrderPlacedEvent event) {
//        log.info("Consumed order event: {}", event);
//
//        Optional<MenuEntity> menuItemOpt = menuRepository.findById(event.getMenuItemId());
//        if (menuItemOpt.isPresent()) {
//            MenuEntity menuItem = menuItemOpt.get();
//            int newQuantity = menuItem.getQuantity() - event.getQuantity();
//            menuItem.setQuantity(newQuantity >= 0 ? newQuantity : 0);
//            menuRepository.save(menuItem);
//            log.info("Updated quantity for menu item {} to {}", event.getMenuItemId(), newQuantity);
//        } else {
//            log.warn("Menu item with id {} not found!", event.getMenuItemId());
//        }
//    }
}
