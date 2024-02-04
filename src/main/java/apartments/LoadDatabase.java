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
    CommandLineRunner initDatabase(TenantRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Tenant("Adam")));
            log.info("Preloading " + repository.save(new Tenant("Bob")));
            log.info("Preloading " + repository.save(new Tenant("Cameron")));
            log.info("Preloading " + repository.save(new Tenant("Dave")));
            log.info("Preloading " + repository.save(new Tenant("Edward")));
        };
    }
}
