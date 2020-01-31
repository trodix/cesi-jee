package com.cesi.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cesi.jee.entities.Website;

public interface WebsiteRepository extends JpaRepository<Website, Long> {
 
}