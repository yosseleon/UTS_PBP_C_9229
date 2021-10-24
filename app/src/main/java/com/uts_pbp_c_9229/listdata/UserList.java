package com.uts_pbp_c_9229.listdata;

import com.uts_pbp_c_9229.dao.Destination;
import com.uts_pbp_c_9229.dao.User;

import java.util.ArrayList;

public class UserList {
    public ArrayList<User> users;

    public UserList(){
        users = new ArrayList<>();
        users.add(user1);
    }

    public static final User user1 =
            new User("1","Yosse", "yosse@mail.com", "12345", "Gamping, Sleman",
            "https://www.realmadrid.com/img/vertical_380px/leon_2rm4823_550x650.jpg",
                    "12345");

    public String login(String email, String password){
        for(User user : users){
            if(user.getEmail().equalsIgnoreCase(email)){
                if(user.getPassword().equals(password))
                    return user.getUserId();
                else
                    return "Password invalid";
            }
        }
        return "User Not Found";
    }

    public User getUserById(String userId){
        for(User user : users){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

}

