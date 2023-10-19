package com.geekster.HotelManagementServiceAPI.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private String imageUrl;
    private AuthInpDto authInpDto;
}
