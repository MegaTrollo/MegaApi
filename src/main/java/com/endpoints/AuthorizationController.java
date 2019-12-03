package com.endpoints;

import com.models.LoginModel;
import com.models.RegistryModel;
import com.models.ResponseWithUserAndRole;
import com.services.UserDetailsServiceImpl;
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
    public AuthorizationController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginModel loginModel) {

        ResponseWithUserAndRole response = userDetailsService.authenticateUser(loginModel);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity registerUser(@Valid @RequestBody RegistryModel registryModel) {

        if (!userDetailsService.registerUser(registryModel))
            return new ResponseEntity<>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
