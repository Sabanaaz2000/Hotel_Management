package com.geekster.HotelManagementServiceAPI.controller;

import com.geekster.HotelManagementServiceAPI.Service.OrderService;
import com.geekster.HotelManagementServiceAPI.model.dto.AuthInpDto;
import com.geekster.HotelManagementServiceAPI.model.order.FoodOrder;
import com.geekster.HotelManagementServiceAPI.model.order.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public String placeOrder(@RequestBody AuthInpDto authInpDto, @RequestParam List<Integer> foodIds){
        return orderService.placeOrder(authInpDto,foodIds);
    }

    @PutMapping("/order/{orderId}/status")
    public String updateOrderStatus(@RequestBody AuthInpDto authInpDto, @PathVariable Integer orderId, @RequestParam status orderStatus){
        return orderService.updateOrderStatus(authInpDto,orderId,orderStatus);
    }

    @GetMapping("/order/user")
    public List<FoodOrder> getOrders(@RequestBody AuthInpDto authInpDto){
        return orderService.getOrders(authInpDto);
    }

}
