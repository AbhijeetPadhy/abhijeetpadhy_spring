package com.example.demo.web.security;

import com.example.demo.data.entity.AuthGroup;
import com.example.demo.data.entity.User;
import com.example.demo.data.repository.AuthGroupRepository;
import com.example.demo.data.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandonUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public LandonUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("cannot find username" + username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
        return new LandonUserPrincipal(user, authGroups);
    }
}
