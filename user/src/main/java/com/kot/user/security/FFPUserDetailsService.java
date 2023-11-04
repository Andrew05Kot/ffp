package com.kot.user.security;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kot.user.api.backoffice.v1.user.UserV1ApiMapper;
import com.kot.user.api.backoffice.v1.user.UserV1Response;
import com.kot.user.entity.UserEntity;
import com.kot.user.repository.UserRepository;

@Service
public class FFPUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserV1ApiMapper userV1ApiMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, List.of());
    }

    public UserV1Response getUserDetailsByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return userV1ApiMapper.domainToDto(userEntity);
    }
}
