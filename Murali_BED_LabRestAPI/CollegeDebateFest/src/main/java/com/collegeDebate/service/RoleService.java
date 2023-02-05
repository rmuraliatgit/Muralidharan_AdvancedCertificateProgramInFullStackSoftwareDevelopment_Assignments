package com.collegeDebate.service;

import java.util.List;

import com.collegeDebate.entity.Role;

public interface RoleService {
	Role findByRolename(String rolename);

	Role saveRole(Role role);

	void updateRole(Role role, Long id);

	void deleteRole(Long id);

	List<Role> findAllRoles();
}