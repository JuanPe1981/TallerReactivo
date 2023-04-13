package com.svalero.tallerreactive.repository;

import com.svalero.tallerreactive.domain.Taller;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TallerRepository extends ReactiveMongoRepository<Taller, String> {

    Flux<Taller> findAll();

    Mono<Taller> findById(String id);

    Flux<Taller> findByCiudad(String ciudad);
}
