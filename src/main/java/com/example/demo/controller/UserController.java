package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.RecommendationService;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RecommendationService recommendationService;

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/{id}/matches")
	public List<User> getMatches(@PathVariable Long id, @RequestParam int topN) {
		return recommendationService.getTopMatches(id, topN);
	}
}
