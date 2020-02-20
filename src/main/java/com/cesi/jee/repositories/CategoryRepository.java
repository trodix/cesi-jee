package com.cesi.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cesi.jee.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  public Category findByName(String name);
}