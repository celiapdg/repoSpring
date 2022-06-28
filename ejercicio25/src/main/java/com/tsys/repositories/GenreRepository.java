package com.tsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsys.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
