package com.marcoMedeiros.MyAnimeList.Config;

import com.marcoMedeiros.MyAnimeList.Model.Anime;
import com.marcoMedeiros.MyAnimeList.Repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public void run(String... args) throws Exception {

        Anime anime1 = new Anime(null, "Jujutsu Kaisen", "Shounen", "2020", "MAPPA", 9.2, true);
        Anime anime2 = new Anime(null, "Shingeki no Kyojin", "Shounen / Seinen", "2013", "WIT Studio / MAPPA", 10.0, true);

        animeRepository.saveAll(Arrays.asList(anime1, anime2));

    }
}
