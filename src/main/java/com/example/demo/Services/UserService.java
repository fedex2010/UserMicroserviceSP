package com.example.demo.Services;

import com.example.demo.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    public ArrayList<User> findAll(){
        return new ArrayList<User>();
    }

    public User findByMail(String mail) {
        return new User("proabdno","proabdno","proabdno");
    }

    public User create(User newUser) {
        return newUser;
    }

    public User update(User newUser) {
        return newUser;
    }

    public void delete(String mail) {
    }
}
