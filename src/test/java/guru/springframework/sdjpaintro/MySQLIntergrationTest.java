package guru.springframework.sdjpaintro;


import guru.springframework.sdjpaintro.respositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@ActiveProfiles("local")
@DataJpaTest //uses an H2 in memory database by default
@ComponentScan(basePackages = "guru.springframework.sdjpaintro.bootstrap") //component scan of the bootstrap package
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //override default H2 database
public class MySQLIntergrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);


    }
}