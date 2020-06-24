package io.rogue.roguepetclinic.services.map;

import io.rogue.roguepetclinic.model.Pet;
import io.rogue.roguepetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
