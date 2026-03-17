package com.marcoMedeiros.MyAnimeList.Repository;

import com.marcoMedeiros.MyAnimeList.Model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
