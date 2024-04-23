# Library Management System

Welcome to the Library Management System! This system allows users to manage books, authors, and rental transactions efficiently.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Overview
This application provides a backend system for managing a library's inventory and rental transactions. It allows users to perform CRUD operations on books and authors, as well as rent and return books.

## Features
- Add, view, update, and delete books and authors.
- Rent and return books with automatic tracking of rental periods.
- Error handling for invalid requests and missing resources.
- MongoDB integration for data storage.

## Setup
1. Clone the repository to your local machine:
    ```
    git clone https://github.com/LokeshV790/Library_Management.git
    ```
2. Navigate to the project directory:
    ```
    cd Library_Management
    ```
3. Make sure you have Java (version >= 8) and Maven installed.
4. Set up a MongoDB instance locally or configure the application to connect to your MongoDB server.
5. Update the `application.properties` file with your MongoDB connection details.
6. Build the project using Maven:
    ```
    mvn clean install
    ```
7. Run the application:
    ```
    mvn spring-boot:run
    ```

## Usage
Once the application is up and running, you can interact with it using HTTP requests. You can use tools like cURL, Postman, or any HTTP client to test the endpoints.

## Endpoints
The application exposes the following endpoints:

- `/books`: Manage books (CRUD operations).
- `/authors`: Manage authors (CRUD operations).
- `/rentals`: Manage rental transactions (renting and returning books).

For detailed information on each endpoint and sample requests, refer to the [API Documentation](#documentation) section below.

## API Endpoints

### Books Endpoints:

1. **Create Book:**
   - Method: POST
   - URL: `http://localhost:8080/books`
   - Body: JSON
     ```json
     {
         "title": "Book Title",
         "author": "Author Name",
         "isbn": "978-1-234567-89-0",
         "publicationYear": 2022
     }
     ```

2. **Get Book by ID:**
   - Method: GET
   - URL: `http://localhost:8080/books/<book_id>`

3. **Update Book:**
   - Method: PUT
   - URL: `http://localhost:8080/books/<book_id>`
   - Body: JSON
     ```json
     {
         "title": "Updated Book Title",
         "author": "Updated Author Name",
         "isbn": "978-1-234567-89-1",
         "publicationYear": 2023
     }
     ```

4. **Delete Book:**
   - Method: DELETE
   - URL: `http://localhost:8080/books/<book_id>`

### Authors Endpoints:

1. **Create Author:**
   - Method: POST
   - URL: `http://localhost:8080/authors`
   - Body: JSON
     ```json
     {
         "name": "Author Name",
         "biography": "Author Biography"
     }
     ```

2. **Get Author by ID:**
   - Method: GET
   - URL: `http://localhost:8080/authors/<author_id>`

3. **Update Author:**
   - Method: PUT
   - URL: `http://localhost:8080/authors/<author_id>`
   - Body: JSON
     ```json
     {
         "name": "Updated Author Name",
         "biography": "Updated Author Biography"
     }
     ```

4. **Delete Author:**
   - Method: DELETE
   - URL: `http://localhost:8080/authors/<author_id>`

### Rentals Endpoints:

1. **Rent Book:**
   - Method: POST
   - URL: `http://localhost:8080/rentals`
   - Body: JSON
     ```json
     {
         "bookId": "<book_id>",
         "renterName": "Renter Name"
     }
     ```

2. **Return Book:**
   - Method: PUT
   - URL: `http://localhost:8080/rentals/return/<rental_id>`

Replace `<book_id>`, `<author_id>`, and `<rental_id>` with the appropriate IDs for the specific resources you want to interact with. Additionally, ensure that your server is running on `http://localhost:8080` or modify the URL accordingly.


## Contributing
Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests. Please adhere to the existing code style and guidelines.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
