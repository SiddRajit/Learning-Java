public enum Status {
  AVAILABLE("Available"),
  CHECKED_OUT("Checked Out"),
  RESERVED("Reserved");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
