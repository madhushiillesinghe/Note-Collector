# Note Collector V2

Welcome to the Note Collector V2 project repository! This is a Spring Boot application designed for efficient note management, with three branches demonstrating different levels of security implementations. Explore the repository to discover the progression from no security to basic authentication, and finally, advanced JWT-based authentication.

## Branches

- **master**: This branch contains the basic version of the project without any security features.
- **secure-basic**: This branch introduces basic authentication and authorization using Spring Security.
- **secure-jwt**: This branch implements JWT (JSON Web Token) for advanced security.

## API Endpoints

### Authentication

- **POST /api/v1/auth/signup**: Register a new user.
- **POST /api/v1/auth/signin**: Authenticate an existing user and return a JWT.
- **POST /api/v1/auth/refresh**: Refresh the JWT.

### Notes Management

- **POST /api/v1/notes**: Create a new note.
- **GET /api/v1/notes/allnotes**: Retrieve all notes (Admin only).
- **GET /api/v1/notes/{noteId}**: Retrieve a note by ID.
- **PATCH /api/v1/notes/{id}**: Update a note.
- **DELETE /api/v1/notes/{id}**: Delete a note.

### User Management

- **DELETE /api/v1/users/{id}**: Delete a user by ID.
- **GET /api/v1/users/{id}**: Retrieve user details by ID.
- **GET /api/v1/users**: Retrieve all users (Admin only).
- **PATCH /api/v1/users/{id}**: Update user details.

## 🧐 Features

This project offers the following features:

- Create new notes.
- View all notes (Admin only).
- View a specific note by ID.
- Update existing notes.
- Delete notes.
- Manage users (create, update, delete).
- File upload support for user profile pictures.

## API Documentation

For detailed API usage and request/response formats, [view the API Documentation](https://documenter.getpostman.com/view/35385949/2sAXxS8rKq).

## 💻 Built With

- **Spring Boot**: Simplifies the development of Java-based enterprise applications.
- **Spring Security**: Provides authentication and authorization capabilities.
- **JWT (JSON Web Token)**: Ensures secure communication between client and server.
- **Hibernate**: ORM framework for database interactions.
- **MySQL**: Relational database management system.
- **Gradle**: Build automation tool.
- **ModelMapper**: Simplifies object mapping.
- **Lombok**: Reduces boilerplate code.

---

Feel free to clone the repository and explore the different security layers implemented in each branch. Enjoy building with Note Collector V2!
