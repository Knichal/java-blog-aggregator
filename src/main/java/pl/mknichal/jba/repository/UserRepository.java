package pl.mknichal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mknichal.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
