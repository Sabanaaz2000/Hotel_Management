package com.geekster.HotelManagementServiceAPI.repo;

import com.geekster.HotelManagementServiceAPI.model.order.FoodOrder;
import com.geekster.HotelManagementServiceAPI.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<FoodOrder, Integer> {
    List<FoodOrder> findByUser(User user);
}
