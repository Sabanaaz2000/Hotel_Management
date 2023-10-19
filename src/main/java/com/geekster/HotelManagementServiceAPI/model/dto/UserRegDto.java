package com.geekster.HotelManagementServiceAPI.model.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegDto {

    private String name;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}$\n")
    private String password;
}
