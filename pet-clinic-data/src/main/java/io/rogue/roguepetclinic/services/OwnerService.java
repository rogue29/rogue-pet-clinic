package io.rogue.roguepetclinic.services;

import io.rogue.roguepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
