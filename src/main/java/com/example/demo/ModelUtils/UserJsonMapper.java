package com.example.demo.ModelUtils;

import com.example.demo.Models.User;

public class UserJsonMapper {
    private String name;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toEntity(){
        User aUser = new User(this.name,this.password,this.email);

        return aUser;
    }
}
