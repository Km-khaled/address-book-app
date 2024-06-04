# Address Book

This project is a Java web application for managing address books. It provides the ability to create, delete, list and manage address books, as well as add, remove, search and list addresses within each address book.

## Features

- Create a new address book
- Delete an existing address book
- List all address books
- Add a new address to a book
- Remove an existing address from a book
- Search for a specific address in a book
- List all addresses in a book

## Technologies Used

- Java
- Jakarta Servlet
- JSP
- MySQL
- JDBC
- HTML
- CSS
- Bootstrap

## Configuration

1. Make sure you have a MySQL instance running on your machine.
2. Create a database named `mid` in MySQL.
3. Import the SQL script provided in the `resources` folder to create the necessary tables.
4. Update the database connection information in the `SingletonConnection.java` file with your appropriate MySQL credentials.
5. Deploy the application to a Jakarta Servlet-compatible application server (e.g., Apache Tomcat).

## Usage

1. Access the application's URL in your web browser.
2. You will be redirected to the main page where you can create, delete, and list address books.
3. Click on an address book link to access the address management page for that book.
4. On the address management page, you can add, remove, search, and list addresses for the selected address book.

## Project Components

- `Adresse.java`: Class representing an address.
- `AdresseDaoImpl.java`: Implementation of the `AdresseDao` interface for CRUD operations on addresses.
- `AdresseDao.java`: Interface defining methods for CRUD operations on addresses.
- `carnet.java`: Class representing an address book and implementing CRUD methods for address books.
- `carnetDao.java`: Interface defining methods for CRUD operations on address books.
- `HelloServlet.java`: Main servlet handling HTTP requests and application actions.
- `Personne.java`: Class representing a person.
- `SingletonConnection.java`: Class managing the connection to the MySQL database.
- `carnet.jsp`: JSP page for managing addresses in a specific address book.
- `first.jsp`: Home JSP page listing all address books.
- `index.jsp`: JSP page for creating, deleting, and listing address books.
- `web.xml`: Web application deployment descriptor.

## License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).

    
