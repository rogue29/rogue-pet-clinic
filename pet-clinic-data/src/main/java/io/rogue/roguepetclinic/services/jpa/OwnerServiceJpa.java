package io.rogue.roguepetclinic.services.jpa;

import io.rogue.roguepetclinic.model.Owner;
import io.rogue.roguepetclinic.repositories.OwnerRepository;
import io.rogue.roguepetclinic.repositories.PetRepository;
import io.rogue.roguepetclinic.repositories.PetTypeRepository;
import io.rogue.roguepetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("jpa")
@Service
public class OwnerServiceJpa implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerServiceJpa(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
                           PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
