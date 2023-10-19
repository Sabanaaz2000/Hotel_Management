package com.geekster.HotelManagementServiceAPI.Service;

import com.geekster.HotelManagementServiceAPI.model.UserAuthToken;
import com.geekster.HotelManagementServiceAPI.model.dto.AuthInpDto;
import com.geekster.HotelManagementServiceAPI.model.user.User;
import com.geekster.HotelManagementServiceAPI.repo.IUserAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthTokenService {

    @Autowired
    IUserAuthTokenRepo userAuthTokenRepo;
    public UserAuthToken createToken(User user){
        UserAuthToken userAuthToken=new UserAuthToken(user);
        userAuthTokenRepo.save(userAuthToken);
        return userAuthToken;
    }

    public UserAuthToken getUserAuthToken(AuthInpDto authInpDto) {
        UserAuthToken userAuthToken=userAuthTokenRepo.findFirstByValue(authInpDto.getTokenValue());
        if(userAuthToken==null)return null;
        User user=userAuthToken.getUser();
        if(user.getEmail().equals(authInpDto.getEmail())&&user.getRole().equals(authInpDto.getRole()))
            return  userAuthToken;
        return null;
    }
    public boolean removeFromRecord(AuthInpDto authInpDto){
        UserAuthToken userAuthToken= getUserAuthToken(authInpDto);
        if(userAuthToken!=null){
            userAuthTokenRepo.delete(userAuthToken);
            return true;
        }
        return false;
    }

}
