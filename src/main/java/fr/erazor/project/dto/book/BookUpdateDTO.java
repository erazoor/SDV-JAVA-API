package fr.erazor.project.dto.book;

import java.util.Date;
import java.util.Optional;

public class BookUpdateDTO {
    private String title;
    private String author;
    private Date publicationDate;
    private Integer availableCopies;

    public BookUpdateDTO(){
    }

    public String getTitle() {
        return title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
