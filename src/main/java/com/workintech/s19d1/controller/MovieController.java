package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/workintech/movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<Movie> findAll() { return movieService.findAll(); }

    @GetMapping("/{id}")
    public Movie find(@PathVariable Long id) { return movieService.findById(id); }

    @PostMapping
    public Movie save(@RequestBody Movie movie) { return movieService.save(movie); }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        movieService.delete(movie);
        return movie;
    }
}