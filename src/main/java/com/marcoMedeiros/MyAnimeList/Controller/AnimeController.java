package com.marcoMedeiros.MyAnimeList.Controller;

import com.marcoMedeiros.MyAnimeList.Model.Anime;
import com.marcoMedeiros.MyAnimeList.Service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/animes")
public class AnimeController {

    @Autowired
    private AnimeService service;

    @Autowired
    private LoadTimeWeaverAware loadTimeWeaverAware;

    @GetMapping
    public ResponseEntity<List<Anime>> findAll(){
        List<Anime> listAnime = service.findAll();
        return ResponseEntity.ok().body(listAnime);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id){
        Anime obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Anime> insert(@RequestBody Anime obj){
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Anime> update(@PathVariable Long id, @RequestBody Anime obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
