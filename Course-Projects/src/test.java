
public class test {
    public static void main(String[] args) {
        User user1 = new User("user1", "user1@email.com", 20);
        User user2 = new User("user2", "user2@email.com", 30);
        User user3 = new User("user3", "user3@email.com", 40);

        user1.printUser();
        user2.printUser();
        user3.printUser();
    }
}
