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
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional<User> findByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

    public User create(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    public User update(User newUser) {
        return newUser;
    }

    public void delete(User newUser) {
        userRepository.delete(newUser);
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void deleteALl() {
        userRepository.deleteAll();
    }

}
