package com.selamkd.todosystem.model.repositories;

import com.selamkd.todosystem.model.entities.MusicTrack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicTrackRepository extends JpaRepository<MusicTrack, Integer> {
}