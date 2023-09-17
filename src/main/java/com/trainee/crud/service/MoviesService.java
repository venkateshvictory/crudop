package com.trainee.crud.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.trainee.crud.dao.MoviesRepository;
import com.trainee.crud.model.Movies;

@Service("moviesService")
public class MoviesService {

	@Resource(name="moviesRepository")
	private MoviesRepository moviesRepository;
	
	String line ="";
	public void saveMoviesData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/movies.csv"));
			while((line= br.readLine())!=null) {
			String[]	data=line.split(",");
			Movies m = new Movies();
			m.setGenres(data[0]);
			m.setPrimaryTitle(data[1]);
			m.setRuntimeMinutes(data[2]);
			m.setTconst(data[3]);
			m.setTitleType(data[4]);
			moviesRepository.save(m);
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
