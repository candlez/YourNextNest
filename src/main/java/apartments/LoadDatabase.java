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
                1200
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "FoxRidge",
                "750 Hethwood Boulevard",
                2,
                1400
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "FoxRidge",
                "750 Hethwood Boulevard",
                3,
                1600
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "FoxRidge",
                "750 Hethwood Boulevard",
                4,
                2600
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "FoxRidge",
                "750 Hethwood Boulevard",
                5,
                3200
            )));

            log.info("Preloading " + repository2.save(new Listing(
                "Shawnee",
                "1222 Unviersity City Boulevard",
                1,
                1000
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Shawnee",
                "1222 Unviersity City Boulevard",
                2,
                2400
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Shawnee",
                "1222 Unviersity City Boulevard",
                3,
                4350
            )));

            log.info("Preloading " + repository2.save(new Listing(
                "Chasewood Downs",
                "1301 Unviersity City Boulevard",
                1,
                800
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Chasewood Downs",
                "1301 Unviersity City Boulevard",
                2,
                1800
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Chasewood Downs",
                "1301 Unviersity City Boulevard",
                3,
                1500
            )));

            log.info("Preloading " + repository2.save(new Listing(
                "Hunter's Ridge",
                "1310 Henry Lane",
                2,
                1700
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Hunter's Ridge",
                "1310 Henry Lane",
                4,
                3300
            )));

            log.info("Preloading " + repository2.save(new Listing(
                "The Union",
                "1001 University City Boulevard",
                1,
                1500
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Union",
                "1001 University City Boulevard",
                2,
                2500
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Union",
                "1001 University City Boulevard",
                3,
                3600
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Union",
                "1001 University City Boulevard",
                4,
                4400
            )));

            log.info("Preloading " + repository2.save(new Listing(
                "Windsor Hills",
                "200 Hampton Court",
                1,
                1150
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Windsor Hills",
                "200 Hampton Court",
                2,
                2500
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Windsor Hills",
                "200 Hampton Court",
                3,
                4900
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Cedar Pointe",
                "200 Cedar Pointe Drive",
                1,
                1300
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "Cedar Pointe",
                "200 Cedar Pointe Drive",
                2,
                3500
            )));

            log.info("Preloading " + repository2.save(new Listing(
                "The Hub",
                "1201 Snyder Lane",
                1,
                1700
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Hub",
                "1201 Snyder Lane",
                2,
                2500
            )));
            log.info("Preloading " + repository2.save(new Listing(
                "The Hub",
                "1201 Snyder Lane",
                4,
                1000
            )));
        };
    }
}