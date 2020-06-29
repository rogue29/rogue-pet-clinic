package io.rogue.roguepetclinic.bootstrap;

import io.rogue.roguepetclinic.model.*;
import io.rogue.roguepetclinic.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.time.LocalDate.now;

@Component
public class DataLoader implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().isEmpty()) {
            loadVetsWithSpecialities();
            loadOwnersWithPets();
        }
    }

    private void loadVetsWithSpecialities() {
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Catherine");
        vet1.setLastName("Calcutta");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Dan");
        vet2.setLastName("Dsouza");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        log.info("#####Saved Vets#####");
    }

    private void loadOwnersWithPets() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Akash");
        owner1.setLastName("Ahuja");

        Pet akashpet = new Pet();
        akashpet.setPetType(savedDog);
        akashpet.setName("BowBow");
        akashpet.setOwner(owner1);
        akashpet.setBirthDate(now());

        owner1.getPets().add(akashpet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bob");
        owner2.setLastName("Bell");

        Pet bobPet = new Pet();
        bobPet.setPetType(cat);
        bobPet.setName("MeowMeow");
        bobPet.setOwner(owner2);
        bobPet.setBirthDate(now());

        owner2.getPets().add(bobPet);

        ownerService.save(owner2);

        Visit meowVisit = new Visit();
        meowVisit.setPet(bobPet);
        meowVisit.setDate(now());
        meowVisit.setDescription("Sneezy Kitty");
        visitService.save(meowVisit);

        log.info("#####Saved Owners#####");
    }
}
