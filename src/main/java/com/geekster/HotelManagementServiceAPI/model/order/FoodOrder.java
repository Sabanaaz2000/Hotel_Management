package com.geekster.HotelManagementServiceAPI.model.order;

import com.geekster.HotelManagementServiceAPI.model.FoodItem;
import com.geekster.HotelManagementServiceAPI.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    @JoinColumn(name = "fkFoodId")
    private List<FoodItem> foodItemList;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "fkUserId")
    private User user;
    @Enumerated(value = EnumType.STRING)
    private status orderStatus;
    private LocalDateTime creationTime;

    public FoodOrder(List<FoodItem> foodItems,User user){
        this.foodItemList=foodItems;
        this.user=user;
        quantity=foodItems.size();
        creationTime=LocalDateTime.now();
        orderStatus=status.CREATED;
    }
}
