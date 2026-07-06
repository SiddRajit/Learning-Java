public class User {
    String username;
    String email;
    int age;

    User ( String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public void printUser() {
        System.out.println(username + email + age);
    };


}
