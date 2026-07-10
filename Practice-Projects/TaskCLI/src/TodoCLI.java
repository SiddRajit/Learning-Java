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
            case "list":
                if (args.length == 1) {
                    todoService.listTodos("All");

                } else {
                    todoService.listTodos(args[1]);
                }
            case "update":
                // update todo
            case "delete":
                // delete todo
            case "mark-in-progress":
                // mark todo as in progress
            case "mark-done":
                // mark todo as done
        }
    }
}
