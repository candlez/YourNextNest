package apartments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TenantRepository repository1, ListingRepository repository2) {
        return args -> {
            // tenants
            log.info("Preloading " + repository1.save(new Tenant("Adam")));
            log.info("Preloading " + repository1.save(new Tenant("Bob")));
            log.info("Preloading " + repository1.save(new Tenant("Cameron")));
            log.info("Preloading " + repository1.save(new Tenant("Dave")));
            log.info("Preloading " + repository1.save(new Tenant("Edward")));

            // listings
            log.info("Preloading " + repository2.save(new Listing(
                "FoxRidge",
                "123 Unviersity Boulevard",
                1,
                900
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Shawnee",
                "123 Unviersity Boulevard",
                1,
                900
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Chasewood",
                "123 Unviersity Boulevard",
                1,
                900
            )));
        };
    }
}
