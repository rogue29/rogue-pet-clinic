package io.rogue.roguepetclinic.service;

import io.rogue.roguepetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Set<Vet> findAll();

    Vet save(Vet vet);
}
