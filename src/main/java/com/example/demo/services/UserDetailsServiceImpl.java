package com.example.demo.services;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleName;
import com.example.demo.entity.User;
import com.example.demo.models.LoginModel;
import com.example.demo.models.RegistryModel;
import com.example.demo.models.ResponseWithUserAndRole;
import com.example.demo.models.UserPrinciple;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtProvider;
import com.example.demo.security.JwtResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder encoder;
    private RoleService roleService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, JwtProvider jwtProvider, AuthenticationManager authenticationManager, PasswordEncoder encoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("user not found with -> username or email : " + email);
            throw new UsernameNotFoundException("user not found with -> username or email : " + email);
        }
        return UserPrinciple.build(user);
    }

    public ResponseWithUserAndRole authenticateUser(LoginModel loginModel) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User username = userRepository.findByEmail(loginModel.getEmail());

        if (username != null) {
            log.info("authorizeded user " + username.getEmail());
        } else throw new RuntimeException("unauthorized user");

        String jwt = jwtProvider.generateJwtToken(authentication);
        return new ResponseWithUserAndRole(new JwtResponse(jwt), username.getRoles().getId(), username.getId());
    }

    public boolean registerUser(RegistryModel registryModel) {
        if (userRepository.existsByEmail(registryModel.getEmail())) {
            log.info(registryModel.getEmail() + " email already in use");
            return false;
        }

        Role role = roleService.getRole(RoleName.USER);

        User user = new User(registryModel.getEmail(),
                encoder.encode(registryModel.getPassword()),
                registryModel.getFirstName(),
                registryModel.getLastName(),
                role);

        userRepository.save(user);

        log.info(user.getEmail() + " user registered");
        return true;
    }

}
