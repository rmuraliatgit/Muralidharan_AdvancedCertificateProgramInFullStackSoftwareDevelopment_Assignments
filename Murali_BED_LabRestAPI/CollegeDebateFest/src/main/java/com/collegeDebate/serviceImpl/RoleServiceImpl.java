package com.collegeDebate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeDebate.entity.Role;
import com.collegeDebate.repo.RoleRepository;
import com.collegeDebate.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByRolename(String roleName) {
        return roleRepository.findByRolename(roleName);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

	@Override
	public void updateRole(Role role, Long id) {
		Role foundRole = roleRepository.findById(id).get();
		foundRole.setRolename(role.getRolename());
		roleRepository.save(foundRole);
	}
}

