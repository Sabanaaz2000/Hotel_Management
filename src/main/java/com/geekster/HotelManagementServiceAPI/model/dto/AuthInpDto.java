package com.geekster.HotelManagementServiceAPI.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInpDto {

    private String TokenValue;
    private String email;
    private Role role;

    public AuthInpDto(String value, String email, com.geekster.HotelManagementServiceAPI.model.user.Role role) {
    }
}
