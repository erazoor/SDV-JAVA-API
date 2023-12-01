package fr.erazor.project.dto.book;

public class BookTitleDTO {
    private String title;

    // Constructors
    public BookTitleDTO() {
    }

    public BookTitleDTO(String title) {
        this.title = title;
    }

    // Getter and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
