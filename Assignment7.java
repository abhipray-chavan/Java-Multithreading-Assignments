import java.util.ArrayList;
import java.util.List;

public class Assignment7 {
    public static class User {
        private String name;
        
        public User(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
    }
    
    public static List<String> getUserNames(List<User> users) {
        List<String> userNames = new ArrayList<>();
        
        for (User user : users) {
            userNames.add(user.getName());
        }
        
        return userNames;
    }
    
    public static void main(String[] args) {
        // Create a list of users
        List<User> users = new ArrayList<>();
        users.add(new User("Abhipray"));
        users.add(new User("Akarsh"));
        users.add(new User("Prithvi"));
        users.add(new User("Chinmay"));
        
        // Get the list of user names
        List<String> userNames = Assignment7.getUserNames(users);
        
        // Display the user names
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}