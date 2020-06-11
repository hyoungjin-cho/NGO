package com.summitworks.ngo.unittest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.UserNotFoundException;
import com.summitworks.ngo.repo.UserRepository;
import com.summitworks.ngo.services.UserService;
import com.summitworks.ngo.services.UserServiceImpl;

@SpringBootTest
public class UserServiceMockTest {
	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@BeforeEach
	void setUserRepo() {
		User u1 = new User();
		User u2 = new User();
		u1.setEmail("email1");
		u1.setFirstname("first1");
		u1.setLastname("last1");
		u1.setPassword("password1");
		u2.setEmail("email2");
		u2.setFirstname("first2");
		u2.setLastname("last2");
		u2.setPassword("password2");
		ArrayList<User> arr = new ArrayList<User>();
		arr.add(u1);
		arr.add(u2);
		
		when(userRepo.findAll()).thenReturn(arr);
		when(userRepo.getOne(1L)).thenReturn(u1);
	}
	
	@Test
	public void testGetAll() {
		User u1 = new User();
		User u2 = new User();
		u1.setEmail("email1");
		u1.setFirstname("first1");
		u1.setLastname("last1");
		u1.setPassword("password1");
		u2.setEmail("email2");
		u2.setFirstname("first2");
		u2.setLastname("last2");
		u2.setPassword("password2");
		ArrayList<User> arr = new ArrayList<User>();
		arr.add(u1);
		arr.add(u2);
		//assertArrayEquals(arr, userService.getAllUsers());
		// I can't configure assertArrayEquals method, not sure.
		
	}
	
	@Test
	public void testGet() {
		User u1 = new User();
		u1.setEmail("email1");
		u1.setFirstname("first1");
		u1.setLastname("last1");
		u1.setPassword("password1");
		try {
		assertEquals(u1 ,userService.getUser(1L));
		} catch(UserNotFoundException e ) {
			System.out.println("err: " + e);
		}
		
	}
	

}
