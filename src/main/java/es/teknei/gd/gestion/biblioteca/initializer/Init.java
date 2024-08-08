package es.teknei.gd.gestion.biblioteca.initializer;

import es.teknei.gd.gestion.biblioteca.model.Book;
import es.teknei.gd.gestion.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Init {

    @Autowired
    private BookService bookService;

    public void displayMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nGestor de Biblioteca");
                System.out.println("1. Agregar libro");
                System.out.println("2. Ver todos los libros");
                System.out.println("3. Buscar libro por ID");
                System.out.println("4. Editar libro");
                System.out.println("5. Eliminar libro");
                System.out.println("6. Marcar como leído/pendiente");
                System.out.println("7. Salir");
                System.out.print("Selecciona una opción: ");

                int option = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea

                switch (option) {
                    case 1 -> addBook(scanner);
                    case 2 -> listAllBooks();
                    case 3 -> findBookById(scanner);
                    case 4 -> updateBook(scanner);
                    case 5 -> deleteBook(scanner);
                    case 6 -> toggleReadStatus(scanner);
                    case 7 -> exit = true;
                    default -> System.out.println("Opción no válida, por favor intenta de nuevo.");
                }
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.println("Ingrese el título del libro que quiere agregar:");
        String title = scanner.nextLine();
        System.out.println("Ingrese el autor del libro que quiere agregar:");
        String author = scanner.nextLine();
        System.out.println("Ingrese el género del libro que quiere agregar:");
        String genre = scanner.nextLine();

        var book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setRead(false);

        bookService.addBook(book);
        System.out.println("Libro agregado exitosamente.");
    }

    private void listAllBooks() {
        System.out.println("Recuperando la lista de todos los libros que hay en la biblioteca:");
        List<Book> books = bookService.listAllBooks();
        books.forEach(book -> {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Read: " + book.isRead());
            System.out.println("---------------");
        });
    }

    private void findBookById(Scanner scanner) {
        System.out.println("Recuperando el libro por su identificador:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        var book = bookService.findBookById(id);
        if (book != null) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Read: " + book.isRead());
        } else {
            System.out.println("Libro no encontrado con el ID proporcionado.");
        }
    }

    private void updateBook(Scanner scanner) {
        System.out.println("Actualizando un libro, por favor, proporcione un identificador válido:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        if (bookService.doesBookExist(id)) {
            var book = bookService.findBookById(id);

            boolean updating = true;
            while (updating) {
                System.out.println("¿Qué quiere actualizar? (escriba el nombre del campo, por ejemplo: 'title', 'author', 'genre', 'read') o 'done' para terminar:");
                String field = scanner.nextLine().trim();

                switch (field) {
                    case "title" -> {
                        System.out.println("Ingrese el nuevo título:");
                        String newTitle = scanner.nextLine();
                        book.setTitle(newTitle);
                    }
                    case "author" -> {
                        System.out.println("Ingrese el nuevo autor:");
                        String newAuthor = scanner.nextLine();
                        book.setAuthor(newAuthor);
                    }
                    case "genre" -> {
                        System.out.println("Ingrese el nuevo género:");
                        String newGenre = scanner.nextLine();
                        book.setGenre(newGenre);
                    }
                    case "read" -> {
                        System.out.println("Ingrese el nuevo estado de lectura (true/false):");
                        boolean newRead = scanner.nextBoolean();
                        scanner.nextLine();  // Limpiar el buffer del scanner
                        book.setRead(newRead);
                    }
                    case "done" -> updating = false;
                    default -> System.out.println("Campo no válido. Inténtelo de nuevo.");
                }
            }

            bookService.updateBook(book);
            System.out.println("Libro actualizado con éxito.");
        } else {
            System.out.println("El identificador no corresponde a ningún libro de la base de datos. Inténtelo con otro ID.");
        }
    }

    private void deleteBook(Scanner scanner) {
        System.out.println("Ingrese el ID del libro a eliminar:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        if (bookService.doesBookExist(id)) {
            bookService.deleteBook(id);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("El identificador no corresponde a ningún libro de la base de datos.");
        }
    }

    private void toggleReadStatus(Scanner scanner) {
        System.out.println("Ingrese el ID del libro para marcar como leído/pendiente:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        var book = bookService.findBookById(id);
        if (book != null) {
            book.setRead(!book.isRead());
            bookService.updateBook(book);
            System.out.println("Estado de lectura cambiado a: " + book.isRead());
        } else {
            System.out.println("El identificador no corresponde a ningún libro de la base de datos.");
        }
    }

}


