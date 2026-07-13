

public class LibraryManagementCLI {


  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("You need to pass a command!");
      System.out.println("Usage: ");
      return;
    }

    String command = args[0];
    BookService bookService = new BookService();

    System.out.println("Welcome to Library Management CLI");
    switch (command) {
      case "list":
        bookService.listBooks();
        break;

      case "add":
        bookService.addBook(args[1], args[2], Integer.parseInt(args[3]));
        break;
    
      default:
        break;
    }
  }
}
