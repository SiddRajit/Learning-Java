import java.util.ArrayList;
import java.util.List;

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
      books = mapper.readValue(jsonFile, new TypeReference<List<Book>>() {});
      
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
}
