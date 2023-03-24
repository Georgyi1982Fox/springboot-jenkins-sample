package org.example.controller;

import org.example.entity.ThemeParkRide;
import org.example.repository.ThemeParkRideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
@RestController
public class ThemeParkRideController {
    private final ThemeParkRideRepository themeParkRideRepository;
    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository){
        this.themeParkRideRepository = themeParkRideRepository;
    }
    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides(){
        return themeParkRideRepository.findAll();
    }
    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide findById(@PathVariable long id){
        return themeParkRideRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide){
        return themeParkRideRepository.save(themeParkRide);
    }
}
