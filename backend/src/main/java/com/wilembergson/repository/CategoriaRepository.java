package com.wilembergson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilembergson.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
