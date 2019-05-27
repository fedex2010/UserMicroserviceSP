package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.ModelUtils.UserJsonMapper;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> listUser() {
        return new ResponseEntity<ArrayList<User>>( userService.findAll(), HttpStatus.OK);
	}

	//CREAR NOT FOUND EXCEPTION
    @RequestMapping(value = "/{mail}",method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("mail") String mail) {
	    Optional<User> u = userService.findByMail(mail);
        return new ResponseEntity<User>(u.get(),HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody UserJsonMapper userPayload) {
        User aUser = userPayload.toEntity();
        return new ResponseEntity<User>(aUser,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody UserJsonMapper userPayload) {
        User aUser = userPayload.toEntity();
        return new ResponseEntity<User>(aUser,HttpStatus.OK);
    }

    @RequestMapping(value = "/{mail}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> daleteUser(@PathVariable("mail") String mail) {
	    userService.deleteByEmail(mail);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public ResponseEntity<Void> daleteAll() {
        userService.deleteALl();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}