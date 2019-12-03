package com.services;

import com.entity.RoleName;
import com.entity.Role;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(RoleName roleName) {
        return this.roleRepository.getRoleByName(roleName);
    }
}
