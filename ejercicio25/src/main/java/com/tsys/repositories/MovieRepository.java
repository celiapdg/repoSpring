package com.tsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsys.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
