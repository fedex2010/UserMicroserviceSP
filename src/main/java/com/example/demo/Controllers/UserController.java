package com.example.demo.Controllers;

import java.util.ArrayList;

import com.example.demo.ModelUtils.UserJsonMapper;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ArrayList<User> listUser() {
		return userService.findAll();
	}

    @RequestMapping(value = "/{mail}",method = RequestMethod.GET)
    public User getUser(@PathVariable("mail") String mail) {
        return userService.findByMail(mail);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody UserJsonMapper userPayload) {
        User aUser = userPayload.toEntity();
        return userService.create( aUser );
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody UserJsonMapper userPayload) {
        User aUser = userPayload.toEntity();
        return userService.update( aUser );
    }

    @RequestMapping(value = "/{mail}",method = RequestMethod.DELETE)
    public User daleteUser(@PathVariable("mail") String mail) {
	    userService.delete(mail);
        return new User("un nombre","un pass","un emial");
    }

}