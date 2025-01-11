//package com.example.demo;
//
//import com.example.demo.model.User;
//import com.example.demo.service.RecommendationService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.util.Arrays;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class RecommendationServiceTest {
//
//	 @Autowired
//	    private RecommendationService recommendationService;
//
//	    @Test
//	    public void testGetTopMatches() {
//	        // Create mock user data
//	        User user1 = new User("User 1", "Female", 25, Arrays.asList("Cricket", "Chess"));
//	        User user2 = new User("User 2", "Male", 27, Arrays.asList("Cricket", "Football", "Movies"));
//	        User user3 = new User("User 3", "Male", 26, Arrays.asList("Movies", "Tennis", "Football", "Cricket"));
//
//	        // Call the service and test the results
//	        List<User> matches = recommendationService.getTopMatches(user2.getId(), 2);
//
//	        // Validate the top matches (expected result)
//	        assertEquals("User 1", matches.get(0).getName());
//	    }
//	}