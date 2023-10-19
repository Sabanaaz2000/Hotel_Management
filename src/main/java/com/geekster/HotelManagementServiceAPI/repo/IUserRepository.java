package com.geekster.HotelManagementServiceAPI.repo;

import com.geekster.HotelManagementServiceAPI.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findFirstByEmail(String email);

    User findFirstByPassword(String pass);
}
