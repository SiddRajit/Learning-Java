public enum Status {
    TODO("Todo"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
