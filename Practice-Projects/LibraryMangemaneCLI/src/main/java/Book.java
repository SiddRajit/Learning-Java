public class Book {
  private int id;
  private static int lastId = 0;
  private String title;
  private String author;
  private int pages;
  private Status status;

  public Book () {

  }

  public Book (String title, String author, int pages) {
    this.id = ++lastId;
    this.title = title;
    this.author = author;
    this.pages = pages;
    this.status = Status.AVAILABLE;
  }

  public String getTitle() {
    return this.title;
  }

  public int getId() {
    return this.id;
  }

  public String getAuthor() {
    return this.author;
  }

  public int getPages() {
    return this.pages;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setId(int id) {
    this.id = id;
    if (id > lastId) {
        lastId = id;
    }
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setpages(int pages) {
    this.pages = pages;
  }

  public void setauthor(String author) {
    this.author = author;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public String toString() {
    return "Id: " + this.id + ", Title: " + this.title + ", Author: " + this.author + ", Pages: " + this.pages + ", Status: " + this.status.getValue();
  }
}
