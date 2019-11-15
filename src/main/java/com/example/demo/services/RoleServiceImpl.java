package com.example.demo.services;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleName;
import com.example.demo.repository.RoleRepository;
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
