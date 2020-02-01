package com.cesi.jee.repositories;

import java.util.List;

import com.cesi.jee.entities.Website;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteRepository extends JpaRepository<Website, Long> {
 
  public List<Website> findByCategoryId(Long id);
}