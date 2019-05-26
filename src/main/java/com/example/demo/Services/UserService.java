package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Repositories.UserRepositoryI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User findByMail(String mail) {
        return new User("proabdno","proabdno","proabdno");
    }

    public User create(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    public User update(User newUser) {
        return newUser;
    }

    public void delete(String mail) {
    }
}
