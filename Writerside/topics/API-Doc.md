# API Doc

## Book API Documentation

### Endpoints

| Endpoint                  | HTTP Method | Description                                  | Request Body       | Response Body                       | Status Codes            |
|---------------------------|-------------|----------------------------------------------|--------------------|-------------------------------------|-------------------------|
| `/api/books`              | POST        | Create a new book                            | `Book`             | `Book`                              | 200 OK, 4XX Errors      |
| `/api/books/{id}`         | GET         | Get a book by its ID                         | None               | `ResponseEntity<Book>`              | 200 OK, 404 Not Found   |
| `/api/books`              | GET         | Get all books                                | None               | `List<Book>`                        | 200 OK                  |
| `/api/books/title`        | GET         | Get books by title                           | `BookTitleDTO`     | `ResponseEntity<List<Book>>`        | 200 OK, 404 Not Found   |
| `/api/books/author`       | GET         | Get books by author                          | `BookAuthorDTO`    | `ResponseEntity<List<Book>>`        | 200 OK, 404 Not Found   |
| `/api/books/publicationDate` | GET      | Get books by publication date               | `BookDateDTO`      | `ResponseEntity<List<Book>>`        | 200 OK, 400 Bad Request |
| `/api/books/search`       | GET         | Search books by title and author             | `BookTitleAuthorDTO` | `ResponseEntity<List<Book>>`      | 200 OK, 404 Not Found   |
| `/api/books/{id}`         | PUT         | Update a book's details                      | `BookUpdateDTO`    | `ResponseEntity<Book>`              | 200 OK, 404 Not Found   |
| `/api/books/{id}`         | DELETE      | Delete a book by its ID                      | None               | `ResponseEntity<String>`            | 200 OK, 404 Not Found   |

### DTOs

- `Book`
- `BookTitleDTO` - Contains `title` field.
- `BookAuthorDTO` - Contains `author` field.
- `BookDateDTO` - Contains `publicationDate` field.
- `BookTitleAuthorDTO` - Contains `title` and `author` fields.
- `BookUpdateDTO`

### Notes

- Status code `404 Not Found` is returned when the requested book is not found.
- Status code `400 Bad Request` is used when there's an issue with the request format or data.
- The `@PathVariable` `id` in the endpoints should be the unique identifier of the book.
