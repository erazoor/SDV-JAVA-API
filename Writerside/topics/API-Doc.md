# API Documentation

## Book API Documentation

### Endpoints

| Endpoint                          | HTTP Method | Description                       | Request Body              | Response Body                       | Status Codes              |
|-----------------------------------|-------------|-----------------------------------|---------------------------|-------------------------------------|---------------------------|
| `/api/books`                      | POST        | Create a new book                 | `Book`                    | `Book`                              | 200 OK, 4XX Errors        |
| `/api/books/{id}`                 | GET         | Get a book by its ID              | None                      | `ResponseEntity<Book>`              | 200 OK, 404 Not Found     |
| `/api/books`                      | GET         | Get all books                     | None                      | `List<Book>`                        | 200 OK                    |
| `/api/books/title`                | GET         | Get books by title                | `BookTitleDTO`            | `ResponseEntity<List<Book>>`        | 200 OK, 404 Not Found     |
| `/api/books/author`               | GET         | Get books by author               | `BookAuthorDTO`           | `ResponseEntity<List<Book>>`        | 200 OK, 404 Not Found     |
| `/api/books/publicationDate`      | GET         | Get books by publication date     | `BookDateDTO`             | `ResponseEntity<List<Book>>`        | 200 OK, 400 Bad Request   |
| `/api/books/search`               | GET         | Search books by title and author  | `BookTitleAuthorDTO`      | `ResponseEntity<List<Book>>`        | 200 OK, 404 Not Found     |
| `/api/books/{id}`                 | PUT         | Update a book's details           | `BookUpdateDTO`           | `ResponseEntity<Book>`              | 200 OK, 404 Not Found     |
| `/api/books/{id}`                 | DELETE      | Delete a book by its ID           | None                      | `ResponseEntity<String>`            | 200 OK, 404 Not Found     |

### DTOs

- `Book`
- `BookTitleDTO`
- `BookAuthorDTO`
- `BookDateDTO`
- `BookTitleAuthorDTO`
- `BookUpdateDTO`

## User API Documentation

### Endpoints

| Endpoint                        | HTTP Method | Description                      | Request Body              | Response Body              | Status Codes              |
|---------------------------------|-------------|----------------------------------|---------------------------|----------------------------|---------------------------|
| `/api/users`                    | POST        | Create a new user                | `User`                    | `User`                     | 200 OK, 4XX Errors        |
| `/api/users/{id}`               | GET         | Get a user by their ID           | None                      | `ResponseEntity<User>`     | 200 OK, 404 Not Found     |
| `/api/users/all`                | GET         | Get all users                    | None                      | `List<User>`               | 200 OK                    |
| `/api/users/username`           | GET         | Get users by username            | `UserUsernameDTO`         | `ResponseEntity<List<User>>` | 200 OK, 404 Not Found   |
| `/api/users/email`              | GET         | Get users by email               | `UserEmailDTO`            | `ResponseEntity<List<User>>` | 200 OK, 404 Not Found   |
| `/api/users/{id}`               | PUT         | Update a user's details          | `UserUpdateDTO`           | `ResponseEntity<User>`     | 200 OK, 404 Not Found     |
| `/api/users/{id}`               | DELETE      | Delete a user by their ID        | None                      | `ResponseEntity<String>`   | 200 OK, 404 Not Found     |

### DTOs

- `User`
- `UserUsernameDTO`
- `UserEmailDTO`
- `UserUpdateDTO`

## Loan API Documentation

### Endpoints

| Endpoint                        | HTTP Method | Description                      | Request Body              | Response Body                      | Status Codes            |
|---------------------------------|-------------|----------------------------------|---------------------------|------------------------------------|-------------------------|
| `/api/loans`                    | POST        | Create a new loan                | `Loan`                    | `ResponseEntity<Loan>`             | 200 OK                  |
| `/api/loans/{id}`               | GET         | Get a loan by its ID             | None                      | `ResponseEntity<Loan>`             | 200 OK, 404 Not Found   |
| `/api/loans`                    | GET         | Get all loans                    | None                      | `List<Loan>`                       | 200 OK                  |
| `/api/loans/user/{id}`          | GET         | Get loans by user ID             | None                      | `ResponseEntity<List<Loan>>`       | 200 OK, 404 Not Found   |
| `/api/loans/book/{id}`          | GET         | Get loans by book ID             | None                      | `ResponseEntity<List<Loan>>`       | 200 OK, 404 Not Found   |
| `/api/loans/loan`               | GET         | Get loans by loan date           | `LoanDateDTO`             | `ResponseEntity<List<Loan>>`       | 200 OK, 400 Bad Request |
| `/api/loans/return`             | GET         | Get loans by return date         | `LoanDateDTO`             | `ResponseEntity<List<Loan>>`       | 200 OK, 400 Bad Request |
| `/api/loans/{id}`               | PUT         | Update a loan's details          | `LoanUpdateDTO`           | `ResponseEntity<Loan>`             | 200 OK, 404 Not Found   |
| `/api/loans/{id}`               | DELETE      | Delete a loan by its ID          | None                      | `ResponseEntity<String>`           | 200 OK, 404 Not Found   |

### DTOs

- `Loan`
- `LoanDateDTO`
- `LoanUpdateDTO`
