package com.repository;

import com.entity.Role;
import com.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role getRoleByName(RoleName roleName);

}
