package com.marcoMedeiros.MyAnimeList.Service;

import com.marcoMedeiros.MyAnimeList.Model.Anime;
import com.marcoMedeiros.MyAnimeList.Repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public List<Anime> findAll(){
        return repository.findAll();
    }

    public Anime findById(Long id){
        Optional<Anime> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Anime insert(Anime obj){
       return repository.save(obj);
    }
}
