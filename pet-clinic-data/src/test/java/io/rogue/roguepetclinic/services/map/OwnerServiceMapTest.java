package io.rogue.roguepetclinic.services.map;

import io.rogue.roguepetclinic.model.Owner;
import io.rogue.roguepetclinic.services.PetService;
import io.rogue.roguepetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
class OwnerServiceMapTest {
    public static final String LAST_NAME = "smith";
    public static final Long ID = 1L;
    @Mock
    private PetService petService;
    @Mock
    private PetTypeService petTypeService;
    @InjectMocks
    private OwnerServiceMap ownerService;

    @BeforeEach
    void setUp() {
        Owner owner1 = new Owner();
        owner1.setId(ID);
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setLastName(LAST_NAME);
        ownerService.save(owner2);
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ID);
        assertEquals(ID, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ID);
        assertEquals(1, ownerService.findAll().size());
        assertNotEquals(ID, ownerService
            .findAll()
            .stream()
            .findFirst()
            .get()
            .getId());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ID));
        assertEquals(1, ownerService.findAll().size());
        assertNotEquals(ID, ownerService
            .findAll()
            .stream()
            .findFirst()
            .get()
            .getId());
    }

    @Test
    void save() {
        Owner owner3 = new Owner();
        owner3.setId(3L);
        ownerService.save(owner3);
        assertEquals(3, ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
    }
}
