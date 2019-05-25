package com.example.demo.Controllers;

import java.util.ArrayList;

import com.example.demo.Models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ArrayList<User> listUser() {
		return new ArrayList<User>();
	}

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@RequestParam(value="name", defaultValue="World") String name) {
        return new User("un nombre","un pass","un emial");
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public User createUser(@RequestParam(value="name", defaultValue="World") String name) {
        return new User("un nombre","un pass","un emial");
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public User updateUser(@RequestParam(value="name", defaultValue="World") String name) {
        return new User("un nombre","un pass","un emial");
    }

    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public User deleteUser(@RequestParam(value="name", defaultValue="World") String name) {
        return new User("un nombre","un pass","un emial");
    }

}