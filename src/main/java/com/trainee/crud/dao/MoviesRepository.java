package com.trainee.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.crud.model.Movies;
@Repository("moviesRepository")
public interface MoviesRepository extends JpaRepository<Movies, Long>{

}
