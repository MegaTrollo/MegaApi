package com.example.demo.services;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleName;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role getRole(RoleName roleName);
}
