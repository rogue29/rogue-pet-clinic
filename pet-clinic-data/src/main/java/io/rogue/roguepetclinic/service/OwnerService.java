package io.rogue.roguepetclinic.service;

import io.rogue.roguepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
