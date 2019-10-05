import java.util.*;
public class User {
    private String userName;
    User[] userConnections;
    int connectionCount;
    public User(String userName,String value) {
        this.userName = userName;
        userConnections = new User[10];
        connectionCount = 0;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserConnections(User connection) {
        this.userConnections[connectionCount] = connection;
        connectionCount = connectionCount + 1;
    }
    public String getUserName() {
        return this.userName;
    }
    public User[] getUserConnections() {
        return this.userConnections;
    }
}