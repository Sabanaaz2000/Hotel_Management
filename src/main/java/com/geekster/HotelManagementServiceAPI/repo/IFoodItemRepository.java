package com.geekster.HotelManagementServiceAPI.repo;

import com.geekster.HotelManagementServiceAPI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepository extends JpaRepository<FoodItem, Integer> {
}
