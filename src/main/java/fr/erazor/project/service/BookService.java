package fr.erazor.project.service;

import fr.erazor.project.dto.book.BookUpdateDTO;
import fr.erazor.project.model.Book;
import fr.erazor.project.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, BookUpdateDTO bookUpdateDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        if (bookUpdateDTO.getTitle() != null) {
            book.setTitle(bookUpdateDTO.getTitle());
        }
        if (bookUpdateDTO.getAuthor() != null) {
            book.setAuthor(bookUpdateDTO.getAuthor());
        }
        if (bookUpdateDTO.getPublicationDate() != null) {
            book.setPublicationDate(bookUpdateDTO.getPublicationDate());
        }
        if (bookUpdateDTO.getAvailableCopies() != null) {
            book.setAvailableCopies(bookUpdateDTO.getAvailableCopies());
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<List<Book>> findBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return books.isEmpty() ? Optional.empty() : Optional.of(books);
    }

    @Override
    public Optional<List<Book>> findBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books.isEmpty() ? Optional.empty() : Optional.of(books);
    }

    @Override
    public List<Book> findBooksByPublicationDate(Date publicationDate) {
        return bookRepository.findByPublicationDate(publicationDate);
    }

    @Override
    public List<Book> findBooksByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author);
    }
}
