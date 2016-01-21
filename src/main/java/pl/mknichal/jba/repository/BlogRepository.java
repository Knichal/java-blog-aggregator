package pl.mknichal.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mknichal.jba.entity.Blog;
import pl.mknichal.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user);
	
}
