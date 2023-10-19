package com.geekster.HotelManagementServiceAPI.controller;

import com.geekster.HotelManagementServiceAPI.Service.UserAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {
    @Autowired
    UserAuthTokenService userAuthTokenService;
}
