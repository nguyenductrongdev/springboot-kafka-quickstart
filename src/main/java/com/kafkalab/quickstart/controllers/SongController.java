package com.kafkalab.quickstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkalab.quickstart.dto.SongDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/songs")
public class SongController {
    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody SongDTO song) {
        return ResponseEntity.status(201).body(song);
    }
}
