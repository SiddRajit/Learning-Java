import java.util.ArrayList;
import java.util.Arrays;

public class TodoCLI {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: TodoCli <command> [arguments]");
            System.out.println("You NEED to enter a command!");
        }

        String command = args[0];

        TodoService todoService = new TodoService();

        switch (command) {
            case "add" :
                todoService.addTodo(args[1]);
                break;
            case "list":
                if (args.length == 1) {
                    todoService.listTodos("All");

                } else {
                    todoService.listTodos(args[1]);
                }
                break;
            case "update":
                todoService.updateTodo(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                todoService.deleteTodo(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                todoService.markAsInProgress(Integer.parseInt(args[1]));
                break;
            case "mark-done":
                todoService.markAsDone(Integer.parseInt(args[1]));
                break;
        }
    }
}
