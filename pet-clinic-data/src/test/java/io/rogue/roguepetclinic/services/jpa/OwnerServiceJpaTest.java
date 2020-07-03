package io.rogue.roguepetclinic.services.jpa;

import io.rogue.roguepetclinic.model.Owner;
import io.rogue.roguepetclinic.repositories.OwnerRepository;
import io.rogue.roguepetclinic.repositories.PetRepository;
import io.rogue.roguepetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    public static final long ID = 1L;
    public static final String LAST_NAME = "smith";
    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetTypeRepository petTypeRepository;
    @Mock
    private PetRepository petRepository;
    @InjectMocks
    private OwnerServiceJpa ownerService;

    private Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = new Owner();
        returnedOwner.setId(ID);
        returnedOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        Owner owner = ownerService.findByLastName(LAST_NAME);
        assertNotNull(owner);
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerService.findById(ID);
        assertNotNull(owner);
        assertEquals(ID, owner.getId());
    }

    @Test
    void findAll() {
        Owner owner2 = new Owner();
        owner2.setId(2L);
        Set<Owner> owners = new HashSet<>();
        owners.add(returnedOwner);
        owners.add(owner2);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returnedOwners = ownerService.findAll();
        assertEquals(2, returnedOwners.size());
    }

    @Test
    void save() {
        Long id = 3L;
        Owner owner3 = new Owner();
        owner3.setId(id);
        when(ownerRepository.save(any())).thenReturn(owner3);
        Owner savedOwner = ownerService.save(owner3);
        assertNotNull(savedOwner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerService.delete(returnedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ID);
        verify(ownerRepository).deleteById(any());
    }
}
