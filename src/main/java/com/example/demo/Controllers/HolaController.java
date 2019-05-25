package com.example.demo.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.Models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new User(counter.incrementAndGet(),
				String.format(template, name));
	}
}