package com.svalero.tallerreactive.service;

import com.svalero.tallerreactive.domain.Taller;
import com.svalero.tallerreactive.repository.TallerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TallerServiceImpl implements TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    @Override
    public Flux<Taller> findAll() {
        return tallerRepository.findAll();
    }

    @Override
    public Mono<Taller> findById(String id) {
        return tallerRepository.findById(id);
    }

    @Override
    public Flux<Taller> findByCiudad(String ciudad) {
        return tallerRepository.findByCiudad(ciudad);
    }

    @Override
    public Mono<Taller> addTaller(Taller taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public Mono<Taller> updateTaller(String id, Taller tallerModificado) {
        return tallerRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTaller ->{
                    if (optionalTaller.isPresent()) {
                        tallerModificado.setId(id);
                        return tallerRepository.save(tallerModificado);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> deleteTaller (String id) {
        return tallerRepository.deleteById(id);
    }
}
