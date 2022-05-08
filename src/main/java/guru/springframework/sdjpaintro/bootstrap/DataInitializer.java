package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.respositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();//delete data and reinitialize

        //Creating a book object
        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        //saving the book
        Book saveDDD = bookRepository.save(bookDDD);



        Book bookSIA = new Book("Spring in Action", "345321", "Oriely", null);
        Book saveSIA = bookRepository.save(bookSIA);



        bookRepository.findAll().forEach(book ->{
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title " + book.getTitle());
        });



    }
}
