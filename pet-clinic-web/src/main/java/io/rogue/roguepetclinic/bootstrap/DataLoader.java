package io.rogue.roguepetclinic.bootstrap;

import io.rogue.roguepetclinic.model.Owner;
import io.rogue.roguepetclinic.model.Vet;
import io.rogue.roguepetclinic.services.OwnerService;
import io.rogue.roguepetclinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Akash");
        owner1.setLastName("Ahuja");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bob");
        owner2.setLastName("Bell");

        ownerService.save(owner2);

        log.info("#####Saved Owners#####");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Catherine");
        vet1.setLastName("Calcutta");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Dan");
        vet2.setLastName("Dsouza");

        vetService.save(vet2);

        log.info("#####Saved Vets#####");
    }
}
