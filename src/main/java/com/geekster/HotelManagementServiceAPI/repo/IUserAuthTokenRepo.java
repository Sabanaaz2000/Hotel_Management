package com.geekster.HotelManagementServiceAPI.repo;

import com.geekster.HotelManagementServiceAPI.model.UserAuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAuthTokenRepo extends JpaRepository<UserAuthToken, Integer> {
    UserAuthToken findFirstByValue(String tokenValue);
}
