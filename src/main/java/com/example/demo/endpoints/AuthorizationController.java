package com.example.demo.endpoints;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleName;
import com.example.demo.models.LoginModel;
import com.example.demo.models.RegistryModel;
import com.example.demo.models.ResponseWithUserAndRole;
import com.example.demo.repository.RoleRepository;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private RoleRepository roleService;

    @Autowired
    public AuthorizationController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginModel loginModel) {

        ResponseWithUserAndRole response = userDetailsService.authenticateUser(loginModel);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegistryModel registryModel) {

        if (!userDetailsService.registerUser(registryModel))
            return new ResponseEntity<>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);


        return ResponseEntity.ok().body("User registered successfully!");
    }


}
