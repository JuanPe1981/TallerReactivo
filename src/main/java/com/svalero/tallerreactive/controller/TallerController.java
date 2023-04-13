package com.svalero.tallerreactive.controller;

import com.svalero.tallerreactive.domain.Taller;
import com.svalero.tallerreactive.service.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class TallerController {

    @Autowired
    private TallerService tallerService;

    @GetMapping(value = "/talleres", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Taller> getTalleres(){
        return tallerService.findAll();
    }

    @GetMapping(value = "/taller/{id}")
    public Mono<Taller> getById (@PathVariable String id) {
        return tallerService.findById(id);
    }
    @GetMapping(value = "/talleres/{ciudad}")
    public Flux<Taller> getByCiudad (@PathVariable String ciudad) {
        return tallerService.findByCiudad(ciudad);
    }

    @PostMapping(value = "/talleres")
    public void addTaller(@RequestBody Taller taller) {
        tallerService.addTaller(taller).block();
    }

    @PutMapping(value = "taller/{id}")
    public void updateTaller(@PathVariable String id, @RequestBody Taller tallerModificado) {
        tallerService.updateTaller(id, tallerModificado).block();
    }

    @DeleteMapping(value = "/taller/{id}")
    public Mono<Void> deleteTaller (@PathVariable String id) {
        return tallerService.deleteTaller(id);
    }

}

