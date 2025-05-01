package com.dinegrid.menu_service.repository;

import com.dinegrid.menu_service.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
