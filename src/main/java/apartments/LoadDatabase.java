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
                "750 Hethwood Boulevard",
                1,
                900
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Shawnee",
                "1222 Unviersity City Boulevard",
                1,
                1000
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Chasewood Downs",
                "1301 Unviersity City Boulevard",
                1,
                700
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Hunter's Ridge",
                "1310 Henry Lane",
                1,
                850
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Union",
                "1001 University City Boulevard",
                1,
                1100
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Widsor Hills",
                "200 Hampton Court",
                1,
                950
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Cedar Pointe",
                "200 Cedar Pointe Drive",
                1,
                850
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Hub",
                "1201 Snyder Lane",
                1,
                1000
            )));
        };
    }
}
