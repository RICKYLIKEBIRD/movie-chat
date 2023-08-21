package dev.ricky.movie.controller;

import dev.ricky.movie.domain.Movie;
import dev.ricky.movie.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Movie>> getAllMovieData(){
        List<Movie> result = movieService.getAllMovieData();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovieInfoByMovieId(@PathVariable String imdbId){
        return ResponseEntity.ok(movieService.getMovieInfoByImdbId(imdbId));
    }
}
