package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getTopMatches(Long userId, int topN) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty())
			throw new RuntimeException("User not found");

		User currentUser = optionalUser.get();
		List<User> allUsers = userRepository.findAll();

		// Filter out the current user from the list
		allUsers = allUsers.stream().filter(user -> !user.getId().equals(userId)).collect(Collectors.toList());

		// Score users based on rules
		return allUsers.stream().sorted(Comparator.comparingInt(user -> calculateScore(currentUser, user))).limit(topN)
				.collect(Collectors.toList());
	}

	private int calculateScore(User currentUser, User potentialMatch) {
		int score = 0;

		// Gender Rule
		if (!currentUser.getGender().equalsIgnoreCase(potentialMatch.getGender()))
			score += 100;

		// Age Rule
		score -= Math.abs(currentUser.getAge() - potentialMatch.getAge());

		// Interest Rule
		List<String> commonInterests = currentUser.getInterests().stream()
				.filter(potentialMatch.getInterests()::contains).collect(Collectors.toList());
		score += commonInterests.size() * 10;

		return -score; // Negative to sort in descending order
	}
}