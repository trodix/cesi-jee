package com.cesi.jee.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

  @Id @GeneratedValue
  private Long id;

  private String name;

  @OneToMany(mappedBy="category", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Website> websites;

  public List<Website> getWebsites() {
    return this.websites;
  }

  public void setWebsites(List<Website> websites) {
    this.websites = websites;
  }

  public Category() {
    this.websites = new ArrayList<>();
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Category setName(String name) {
    this.name = name;
    return this;
  }
}