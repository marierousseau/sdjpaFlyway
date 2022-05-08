package guru.springframework.sdjpaintro;


import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.respositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //order of tests to be run
@DataJpaTest
@ComponentScan(basePackages = "guru.springframework.sdjpaintro.bootstrap") //component scan of the bootstrap package
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //override default H2 database
public class SpringBootJpaTestSlice {
    @Autowired
    BookRepository bookRepository;

    @Commit //commit data from a specific test (rare)
    @Order(1)
    @Test
    void  testJpaTestSplice(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "4674684", "Self", null));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);


    }
    @Order(2)
    @Test
    void  testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

        bookRepository.save(new Book("My Book", "4674684", "Self", null));

    }
}
