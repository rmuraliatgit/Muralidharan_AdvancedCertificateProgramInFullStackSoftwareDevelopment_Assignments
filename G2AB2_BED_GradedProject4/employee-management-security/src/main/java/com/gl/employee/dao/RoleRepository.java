package com.gl.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employee.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
