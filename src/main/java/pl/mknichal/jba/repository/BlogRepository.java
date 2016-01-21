package pl.mknichal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mknichal.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
