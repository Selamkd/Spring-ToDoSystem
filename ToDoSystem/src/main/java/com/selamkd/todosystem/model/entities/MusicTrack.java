package com.selamkd.todosystem.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "music_tracks")
public class MusicTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ArtistName", length = 250)
    private String artistName;

    @Column(name = "TrackLink", length = 250)
    private String trackLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackLink() {
        return trackLink;
    }

    public void setTrackLink(String trackLink) {
        this.trackLink = trackLink;
    }

}