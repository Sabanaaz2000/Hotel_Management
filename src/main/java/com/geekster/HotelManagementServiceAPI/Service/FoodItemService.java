package com.geekster.HotelManagementServiceAPI.Service;

import com.geekster.HotelManagementServiceAPI.model.FoodItem;
import com.geekster.HotelManagementServiceAPI.model.UserAuthToken;
import com.geekster.HotelManagementServiceAPI.model.dto.AuthInpDto;
import com.geekster.HotelManagementServiceAPI.model.dto.FoodDto;
import com.geekster.HotelManagementServiceAPI.model.user.Role;
import com.geekster.HotelManagementServiceAPI.repo.IFoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepository foodItemRepo;
    @Autowired
    UserAuthTokenService userAuthTokenService;
    private boolean isNotAValidUser(AuthInpDto authInpDto){
        UserAuthToken userAuthToken=userAuthTokenService.getUserAuthToken(authInpDto);
        if(userAuthToken==null)return true;
        return !userAuthToken.getUser().getRole().equals(Role.ADMIN);
    }

    public String addFood(FoodDto foodDto) {
        if(isNotAValidUser(foodDto.getAuthInpDto()))return "don't have privileges";
        FoodItem foodItem=new FoodItem(foodDto.getTitle(),foodDto.getDescription(),foodDto.getImageUrl());
        foodItemRepo.save(foodItem);
        return "added sucessfully";
    }

    public List<FoodItem> getAll() {
        return foodItemRepo.findAll();
    }


    private boolean isNullOrEmpty(String s){
        return s!=null&&!s.isEmpty();
    }

    private void updateIfValid(String s, Predicate<String> valid, Consumer<String> apply){
        if(valid.test(s)){
            apply.accept(s);
        }
    }

    public String updateFoodById(AuthInpDto authInpDto, Integer foodItemId, String title, String description) {
        if(isNullOrEmpty(title)&&isNullOrEmpty(description)) return "nothing to update";
        if(isNotAValidUser(authInpDto))return "don't have privileges";
        FoodItem foodItem=foodItemRepo.findById(foodItemId).orElseThrow();
        updateIfValid(title,this::isNullOrEmpty,foodItem::setTitle);
        updateIfValid(description,this::isNullOrEmpty,foodItem::setDescription);
        foodItemRepo.save(foodItem);
        return "updated sucessfully";
    }

    public List<FoodItem> findByIds(List<Integer> foodIds) {
        return foodItemRepo.findAllById(foodIds);
    }
}
