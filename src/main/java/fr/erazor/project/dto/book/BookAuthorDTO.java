package fr.erazor.project.dto.book;

import lombok.Getter;

@Getter
public class BookAuthorDTO {
    private String author;

    public BookAuthorDTO() {
    }

    public BookAuthorDTO(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
