import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TodoService {

    private final Path FILE_PATH = Path.of("todos.json");
    private List<Todo> todos;

    public TodoService() {
        todos = new ArrayList<>();

        try{
            loadTodos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTodo(String description) {
        Todo newTodo = new Todo(description);
        todos.add(newTodo);
        saveChanges();
        System.out.println("Task added successfully (ID: " + newTodo.getId() + ")");
    }

    public void listTodos(String type) {
        for(Todo todo : todos) {
            String status = todo.getStatus().toString().strip();

            if (type.equals("All") || status.equals(type)){
                System.out.println(todo.toString());
            }
        }
    }

    public void saveTodos() throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("[\n");

        for (int i = 0; i < todos.size(); i++) {
            sb.append(todos.get(i).toJson());

            if (i != todos.size() - 1) {
                sb.append(",");
            }

            sb.append("\n");
        }

        sb.append("]");

        Files.writeString(FILE_PATH, sb.toString());
    }

    public void loadTodos() throws IOException {
        if (!Files.exists(FILE_PATH)) {
            return;
        }

        String content = Files.readString(FILE_PATH);

        if (content.equals("[]")) {
            return;
        }

        content = content.substring(1, content.length() - 1);

        String[] objects = content.split("},");

        for (String object : objects) {
            if (!object.endsWith("}")) {
                object += "}";
            }
            todos.add(Todo.fromJson(object));
        }


    }

    private void saveChanges() {
        try {
            saveTodos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTodo(int id, String description) {
        Todo todo = findTodoById(id);
        todo.setDescription(description);
        System.out.println("Todo with ID: " + id + " was updated.");
        saveChanges();
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
        saveChanges();
        System.out.println("Todo with ID: " + id + " was deleted");
    }

    public void markAsDone(int id) {
        Todo todo = findTodoById(id);

        if (todo == null) {
            System.out.println("Todo not found");
            return;
        }

        todo.setStatus(Status.DONE);
        System.out.println("Todo with ID: " + id + " status set to Done");
        saveChanges();
    }

    public void markAsInProgress(int id) {
        Todo todo = findTodoById(id);

        if (todo == null) {
            System.out.println("Todo not found");
            return;
        }

        todo.setStatus(Status.IN_PROGRESS);
        System.out.println("Todo with ID: " + id + " status set to In Progress");

        saveChanges();
    }

    private Todo findTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        System.out.println("Todo was not found");
        return null;
    }
}
