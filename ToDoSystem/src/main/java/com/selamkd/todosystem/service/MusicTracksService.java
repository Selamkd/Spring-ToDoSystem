package com.selamkd.todosystem.service;

import com.selamkd.todosystem.model.entities.MusicTrack;
import com.selamkd.todosystem.model.repositories.MusicTrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MusicTracksService {
    private final MusicTrackRepository musicRepository;

    public MusicTracksService(MusicTrackRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public MusicTrack saveTrack(MusicTrack musicTrack){
        return musicRepository.save(musicTrack);
    }

    public MusicTrack updateTrack(String id, MusicTrack updatedMusicTrack) {
        Optional<MusicTrack> trackOptional = musicRepository.findById(Integer.valueOf(id));

        if (trackOptional.isPresent()) {
            MusicTrack trackToUpdate = trackOptional.get();
            trackToUpdate.setArtistName(updatedMusicTrack.getArtistName());
            trackToUpdate.setTrackLink(updatedMusicTrack.getTrackLink());

            return musicRepository.save(trackToUpdate);
        } else {
            return null;
        }
    }
    public List<MusicTrack> getAllTracks(){
        return musicRepository.findAll();
    }

    public Optional<MusicTrack> getTrackById(String id){
        return musicRepository.findById(Integer.valueOf(id));
    }

    public String deleteTasksById(String id){
        Optional<MusicTrack>  trackToDelete = musicRepository.findById(Integer.valueOf(id));
        if(trackToDelete.isPresent()){
            musicRepository.delete(trackToDelete.get());
            return "Track deleted successfully";
        }else{
            return "Unable to find the track.";
        }
    }
}
