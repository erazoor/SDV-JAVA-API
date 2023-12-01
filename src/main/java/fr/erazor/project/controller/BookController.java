package fr.erazor.project.controller;

import fr.erazor.project.dto.book.*;
import fr.erazor.project.model.Book;
import fr.erazor.project.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        try {
            return bookService.getBook(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * @param bookTitleDTO
     * @return ResponseEntity<List < Book>> : permet de retourner une liste de Book
     */
    @GetMapping("/title")
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestBody BookTitleDTO bookTitleDTO) {
        String title = bookTitleDTO.getTitle();
        Optional<List<Book>> books = bookService.findBooksByTitle(title);
        return books.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * @param bookAuthorDTO
     * @return
     */
    @GetMapping("/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestBody BookAuthorDTO bookAuthorDTO) {
        String author = bookAuthorDTO.getAuthor();
        Optional<List<Book>> books = bookService.findBooksByAuthor(author);
        return books.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * @param bookPublicationDateDTO
     * @return
     */
    @GetMapping("/publicationDate")
    public ResponseEntity<List<Book>> getBooksByPublicationDate(@RequestBody BookDateDTO bookPublicationDateDTO) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date publicationDate = formatter.parse(bookPublicationDateDTO.getPublicationDate());
            return ResponseEntity.ok(bookService.findBooksByPublicationDate(publicationDate));
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBooksByTitleAndAuthor(@RequestBody BookTitleAuthorDTO bookTitleAuthorDTO) {
        String title = bookTitleAuthorDTO.getTitle();
        String author = bookTitleAuthorDTO.getAuthor();
        List<Book> books = bookService.findBooksByTitleAndAuthor(title, author);
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        try {
            Book updatedBook = bookService.updateBook(id, bookUpdateDTO);
            return ResponseEntity.ok(updatedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Successfully deleted book number " + id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
