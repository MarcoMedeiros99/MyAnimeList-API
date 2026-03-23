package com.marcoMedeiros.MyAnimeList.Service;

import com.marcoMedeiros.MyAnimeList.Model.Anime;
import com.marcoMedeiros.MyAnimeList.Repository.AnimeRepository;
import com.marcoMedeiros.MyAnimeList.Service.Exceptions.DatabaseException;
import com.marcoMedeiros.MyAnimeList.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public List<Anime> findAll(Boolean assistido) {
        if (assistido == null) {
            return repository.findAll();
        } else {
           return repository.findAll().stream()
                    .filter(anime -> anime.getAssistido() == assistido)
                    .collect(Collectors.toList());
        }
    }

    public Anime findById(Long id) {
        Optional<Anime> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Anime insert(Anime obj) {
        if (obj.getId() != null) {
            throw new DatabaseException("Warning! ID generated automatically, do not enter manually.");
        }
        return repository.save(obj);
    }

    @Transactional
    public Anime update(Long id, Anime obj) {
        try {
            Anime entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return entity;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Anime entity, Anime obj) {
        entity.setTitulo(obj.getTitulo());
        entity.setGenero(obj.getGenero());
        entity.setAnoLancamento(obj.getAnoLancamento());
        entity.setEstudio(obj.getEstudio());
        entity.setNotaPessoal(obj.getNotaPessoal());
        entity.setAssistido(obj.getAssistido());
    }


    public void delete(Long id) {
        Optional<Anime> obj = repository.findById(id);
        obj.orElseThrow(() -> new ResourceNotFoundException(id));
        repository.deleteById(id);
    }

}
