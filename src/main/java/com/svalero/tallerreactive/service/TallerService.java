package com.svalero.tallerreactive.service;

import com.svalero.tallerreactive.domain.Taller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {

    Flux<Taller> findAll();

    Mono<Taller> findById(String id);

    Flux<Taller> findByCiudad(String ciudad);

    Mono<Taller> addTaller(Taller taller);

    Mono<Taller> updateTaller(String id, Taller tallerModificado);

    Mono<Void> deleteTaller(String id);
}
