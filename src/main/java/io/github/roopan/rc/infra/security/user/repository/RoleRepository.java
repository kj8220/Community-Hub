package io.github.roopan.rc.infra.security.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.roopan.rc.infra.security.user.model.Permission;
import io.github.roopan.rc.infra.security.user.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
	List<Permission> findByName(String roleName);

}