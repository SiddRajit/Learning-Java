public class Todo {

    private int id;
    private static int lastId = 0;
    private String description;
    private Status status;

    public Todo(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
    }

    public Todo(int id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;

        if (id > lastId) {
            lastId = id;
        }
    }

    public String toJson() {
        return "{"
                + "\"id\":" + id + ","
                + "\"status\":\"" + status + "\","
                + "\"description\":\"" + description + "\""
                + "}";
    }

    public static Todo fromJson(String json) {
        json = json.replace("{", "")
                   .replace("}", "")
                   .replace("\"", "");

        String[] parts = json.split(",");

        int id = 0;
        String description = "";
        Status status = Status.TODO;

        for (String part : parts) {
            String[] keyValue = part.split(":");


            String key = keyValue[0].trim();
            String value = keyValue[1].trim();


            switch (key) {

                case "id":
                    id = Integer.parseInt(value);
                    break;

                case "status":
                    status = Status.valueOf(value);
                    break;

                case "description":
                    description = value;
                    break;
            }
        }
        return new Todo(id, description, status);
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id: " + id + ", description: " + description.strip() + ", status: " + status.getValue();
    }

}
