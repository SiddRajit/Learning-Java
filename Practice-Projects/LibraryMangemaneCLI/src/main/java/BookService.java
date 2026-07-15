import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class BookService {

  List<Book> books;
  ObjectMapper mapper = new ObjectMapper();
  File jsonFile = new File("books.json");

  public BookService() {
    books = new ArrayList<>();

    try {
      loadBooks();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void loadBooks() {
    try {
      books = mapper.readValue(jsonFile, new TypeReference<List<Book>>() {
      });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void saveBooks() {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, books);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void listBooks() {

    System.out.println("________________________________________________________________________");
    for (Book book : books) {
      System.out.println(book.toString());
    }
    System.out.println("________________________________________________________________________");
  }

  public void addBook(String title, String author, int pages) {
    Book book = new Book(title, author, pages);
    books.add(book);

    saveBooks();
    System.out.println("Added the following book successfuly: \n" + book.toString());
  }

  public void deleteBook(int id) {
    Book book = getBookById(id);

    books.removeIf(b -> b == book);
    saveBooks();

    System.out.println("Book with ID: " + id + " successfully removed");
  }

  public void searchBookByTitle(String title) {
    List<Book> foundBooks = books.stream().filter(book -> book.getTitle().contains(title)).collect(Collectors.toList());

    System.out.println("________________________________________________________________________");
    System.out.println("Search results: ");
    System.out.println("");
    foundBooks.forEach(book -> System.out.println(book.toString()));
    System.out.println("________________________________________________________________________");
  }

  public void searchBookByAuthor(String author) {
    List<Book> foundBooks = books.stream().filter(book -> book.getAuthor().contains(author))
        .collect(Collectors.toList());

    System.out.println("________________________________________________________________________");
    System.out.println("Search results: ");
    System.out.println("");
    foundBooks.forEach(book -> System.out.println(book.toString()));
    System.out.println("________________________________________________________________________");
  }

  public Book getBookById(int id) {
    Book foundBook = books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

    if (foundBook == null) {
      System.out.println("Book with ID: " + id + " not found");
    }

    return foundBook;
  }

}
