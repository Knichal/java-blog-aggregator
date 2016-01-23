package pl.mknichal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mknichal.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
