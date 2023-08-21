package dev.ricky.movie.service;


import dev.ricky.movie.domain.Movie;
import dev.ricky.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovieData(){
        return movieRepository.findAll();
    }


    public Movie getMovieInfoByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId).orElseThrow(NoSuchElementException::new);
    }
}
