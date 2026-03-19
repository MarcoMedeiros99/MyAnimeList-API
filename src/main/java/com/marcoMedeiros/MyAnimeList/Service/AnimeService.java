package com.marcoMedeiros.MyAnimeList.Service;

import com.marcoMedeiros.MyAnimeList.Model.Anime;
import com.marcoMedeiros.MyAnimeList.Repository.AnimeRepository;
import com.marcoMedeiros.MyAnimeList.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public List<Anime> findAll() {
        return repository.findAll();
    }

    public Anime findById(Long id) {
        Optional<Anime> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Anime insert(Anime obj) {
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
}
