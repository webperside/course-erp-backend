package com.webperside.courseerpbackend.services.user;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    // todo: currently our system supports only email login, but in the future
    //  we have to implement phone number version
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByEmail(username);

        return new LoggedInUserDetails(
                user.getEmail(), user.getPassword(), new ArrayList<>()
        );
    }
}
