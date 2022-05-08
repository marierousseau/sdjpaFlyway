package guru.springframework.sdjpaintro.config;


import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//drops all the database objects and then rebuilds from the Flyway Migration
@Profile("Clean")
@Configuration
public class DbClean {
    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
            flyway.clean();
            flyway.migrate();

        };
    }
}
