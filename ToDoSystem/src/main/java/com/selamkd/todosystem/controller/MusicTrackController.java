package com.selamkd.todosystem.controller;

import com.selamkd.todosystem.model.entities.MusicTrack;
import com.selamkd.todosystem.model.exceptions.ListNotFoundException;
import com.selamkd.todosystem.model.exceptions.RequestBodyNotFoundException;
import com.selamkd.todosystem.service.MusicTracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MusicTrackController {

    private final MusicTracksService trackService;

   @Autowired
    public MusicTrackController(MusicTracksService tracksService) {
        this.trackService = tracksService;
    }

    @PostMapping("track")
    public Optional<MusicTrack> addTrack(@RequestBody Optional<MusicTrack> track) throws RequestBodyNotFoundException {
       if(track.isEmpty()){
           throw new RequestBodyNotFoundException("Music track body missing. Please check your input and try again later.");
       }else{
           trackService.saveTrack(track.get());
           return track;
       }
    }

    @GetMapping("/tracks")
    public List<MusicTrack> getAllTracks() throws ListNotFoundException {
       List<MusicTrack> allTracks = trackService.getAllTracks();
       if(allTracks.isEmpty()){
           throw new ListNotFoundException("There are no tracks available at the moment. Please try again later");
       }
       return allTracks;
    }
}
