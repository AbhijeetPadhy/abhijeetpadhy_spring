package com.example.demo.web.security;

import com.example.demo.data.entity.User;
import com.example.demo.data.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LandonUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public LandonUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("cannot find username" + username);
        }
        return new LandonUserPrincipal(user);
    }
}
