package com.example.demo.services;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role getRole(String roleName);
}
