package ch.bbw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTBookController {
    private List<Book> books;
    public RESTBookController() {
        books = new ArrayList<>();
        books.add(new Book(1, "The Metamorphosis", "Franz Kafka"));
        books.add(new Book(2, "The Trial", "Franz Kafka"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Animal Farm", "George Orwell"));
        books.add(new Book(6,"Harry Potter and the Philosopher's Stone","J.K. Rowling" ));
    }
    @GetMapping("books")
    public List<Book> getBooks() {
        return books;
    }
}