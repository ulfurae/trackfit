package project.security.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.service.UserService;
import project.persistence.entities.User;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userManager;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));

        User userInDatabase = userManager.findByUsername(username);

        org.springframework.security.core.userdetails.User user = null;

        user = new org.springframework.security.core.userdetails.User(userInDatabase.getUsername(),
                    userInDatabase.getPass(), roles);


        return user;
    }

}
