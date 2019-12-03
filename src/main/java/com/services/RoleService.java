package com.services;

import com.entity.RoleName;
import com.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role getRole(RoleName roleName);
}
