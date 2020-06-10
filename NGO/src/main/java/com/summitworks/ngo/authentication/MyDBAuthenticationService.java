/*package com.summitworks.ngo.authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.summitworks.ngo.repo.UserRepository;
 
@Service
public class MyDBAuthenticationService implements UserDetailsService {
 
	@Autowired
	UserRepository userRepo;	
 
    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	com.summitworks.ngo.entities.User customUser = userRepo.findByUserId(username).get(0);	
        System.out.println("Account= " + customUser.getId() + customUser.getPassword());

        UserBuilder builder = null;
        if (customUser != null) {
          builder = org.springframework.security.core.userdetails.User.withUsername(username);
          builder.password(new BCryptPasswordEncoder().encode(customUser.getPassword()));
          builder.roles(customUser.getRole());
        } else {
          throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
 
}*/