package com.kafkalab.quickstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkalab.quickstart.dto.SongDTO;
import com.kafkalab.quickstart.services.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody SongDTO song) {
        songService.sendMessage("song", song.getName());
        return ResponseEntity.status(201).body(song);
    }
}
