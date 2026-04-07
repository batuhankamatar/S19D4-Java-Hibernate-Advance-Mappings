package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/actor")
@AllArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    public List<Actor> findAll() { return actorService.findAll(); }

    @GetMapping("/{id}")
    public Actor find(@PathVariable Long id) { return actorService.findById(id); }

    @PostMapping
    public Actor save(@RequestBody ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        List<Movie> movies = actorRequest.getMovies();
        for(Movie movie : movies) {
            actor.addMovie(movie);
        }
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor) {
        actor.setId(id);
        return actorService.save(actor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable Long id) {
        Actor actor = actorService.findById(id);
        actorService.delete(actor);
        return actor;
    }
}