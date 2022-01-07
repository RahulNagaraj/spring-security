package com.rahuln.springsecurity.repository;

import com.rahuln.springsecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
