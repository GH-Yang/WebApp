package entity;

public class User {
    private static String username;
    private static String password;
    private static String city;

    public User()
    {

    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        User.city = city;
    }
}
