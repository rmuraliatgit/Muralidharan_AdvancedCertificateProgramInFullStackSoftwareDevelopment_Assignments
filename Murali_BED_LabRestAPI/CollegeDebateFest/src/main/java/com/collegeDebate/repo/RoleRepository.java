package com.collegeDebate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeDebate.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRolename(String roleName);
}
