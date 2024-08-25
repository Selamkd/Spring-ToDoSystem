package com.selamkd.todosystem;

import com.selamkd.todosystem.model.entities.MusicTrack;
import com.selamkd.todosystem.model.repositories.MusicTrackRepository;
import com.selamkd.todosystem.service.MusicTracksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MusicTrackServiceTests {
    @Autowired
   private MusicTracksService  trackService;
    @MockBean
   private MusicTrackRepository trackRepository;


    @Test
    @DisplayName("save music track successfully adds a new track to the music_tracks table")
    void saveMusicTrackSuccessfullyAddsANewTrackToTheMusicTracksTable() {
        MusicTrack trackEntity = new MusicTrack();

        trackEntity.setArtistName("Selam A.");
        trackEntity.setTrackLink("https://intlanthem.bandcamp.com/track/visit-croatia");

        when(trackRepository.save(trackEntity)).thenReturn(trackEntity);
        MusicTrack savedTrack = trackService.saveTrack(trackEntity);

        Assertions.assertNotNull(savedTrack);
        Assertions.assertEquals(trackEntity.getId(), savedTrack.getId());
        Assertions.assertEquals(trackEntity.getArtistName(), savedTrack.getArtistName());
        Assertions.assertEquals(trackEntity.getTrackLink(), savedTrack.getTrackLink());

    }


}
