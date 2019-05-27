package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryI extends CrudRepository<User, Long> {
    /*@Modifying
    @Query("delete from User b where b.email=:email")
    long deleteByAEmail(@Param("email") String email);*/
}