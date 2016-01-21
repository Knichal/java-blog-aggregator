package pl.mknichal.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mknichal.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
