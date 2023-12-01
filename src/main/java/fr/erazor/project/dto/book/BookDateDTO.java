package fr.erazor.project.dto.book;

import lombok.Getter;

@Getter
public class BookDateDTO {
    private String publicationDate;

    public String getDate() {
        return publicationDate;
    }

    public void setDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
