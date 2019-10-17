/**
 * This class implements all the methods of the SocialNetrorkInterface 
 * You are free to add your own behaviours to this class.
 * 
 * @author Siva Sankar
 */

import java.util.Arrays;
import java.util.*;
public class SocialNetwork {

    /**
     * users indicates the actual users in the network
     */
    User[] users;

    /**
     * The size indicates the numebr of users in the network
     */
    int size;

    /**
     * Initializes the default values of the social network.
     */
    public SocialNetwork() {
        // TODO
        // Your code goes here
        size = 0;
        users = new User[10];
    }

    /**
     * This method takes the string as a parameter which is used
     * to create a network. do nothing if the string is empty.
     * 
     * @param str to be used to create a network.
     */
    public void createDataStructure(String str) {
        // TODO
        // Your code goes here
        // User[] userId = new User[10];
        // User[] toUserId = new User[10];
        // User[] connections = new User[10];
        User admin,collection;
        if (str.length() > 0) {
            String[] connections = str.split(";");
            for(int i=0; i < connections.length; i++) {
                String[] userId = connections[i].split(" ");
                // if (searchUser(userId[0]) == false ) {
                //     addUser(userId[0]);
                // }
                admin = getUserName(userId[0]);
                if (admin == null) {
                    addUser(new User(userId[0],null));
                    admin = getUserName(userId[0]);
                }
                String[] toUserId = userId[userId.length - 1].split(",");
                for (int j = 0; j < toUserId.length; j++) {
                    if (getUser(collection[j]) == null) {
                        collection = addUser(new User(collection[j],null));
                        addUser(colletion);
                        addConnection(admin,getUser(collection[j]));
                    }
                }
                // Set<String> s = new HashSet<String>();
                // for (int j = 0; j < toUserId.length; j++) {
                //     addConnection(userId[0],toUserId[i]);
                // }
                // users[userId[0]] = s;
            }
        }
        return;
    }

    private boolean searchUser(User user) {
        for (int i = 0; i < size; i++) {
            if (user.equals(users[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Please don't modify the follwoing code.
     * This method returns the User based on the userName.
     * 
     * @param userName the string to be used to search for the user.
     * @return the User object based on the userName. 
     * Returns null otherwise
     */
    public User getUser(String userName) {
        for (int i = 0; i < size; i++) {
            if (userName.equals(users[i].getUserName())) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * This method adds a new User (object) that is passed as 
     * argument to the social network if the user is not currently 
     * on the social network.
     * @param userA to be added to the social network.
     */
    public void addUser(User userA) {
        // TODO
        // Your code goes here
        users[size] = userA;
        size = size + 1;
        // return ;
    }

    /**
     * This method takes two users (objects) as arguments and 
     * connects them on the network. userA and userB are 
     * the users that are passed as parameters to this function, 
     * then add userB to userA’s connections
     * 
     * Note: Both userA and userB should be there on the network.
     * if anyone of them are not on the network, then do nothing.
     * 
     * @param userA the userB is to be added to userA connections
     * @param userB to be added to userA connections
     */
    public void addConnection(User userA, User userB) {
        // TODO
        // Your code goes here
        if((searchUser(userA) == true) && (searchUser(userB) == true)) {
            userA.setUserConnections(userB);
        }
    }

    /**
     * This method takes a user object as an argument that returns the 
     * connections of this user. Return null if the user is not in 
     * the network.
     * 
     * @param userA the user object used to return the 
     * connections of this user.
     * 
     * @return the list of connections of userA. otherwise return null
     */
    public User[] getConnections(User userA) {
        // TODO
        // Your code goes here
        for (int i = 0; i < size; i++) {
            if (users[i].equals(userA)) {
                return users[i].getUserConnections();
            }
        }
        return null;
    }

    /**
     * This method returns the common connections of userA and userB.
     * Note: both userA and userB should be on the network. if anyone 
     * of them is not in the network, then return null
     * 
     * @param userA the first user
     * @param userB the second user
     * 
     * @return the common connections of both userA and userB if they 
     * both are in the network, otherwise return null
     */
    public User[] getCommonConnections(User userA, User userB) {
        // TODO
        // Your code goes here
        int size2=0;
        User[] display = new User[10];
        User[] connectionA = new User[10];
        User[] connectionB = new User[10];
        if((searchUser(userA) == true) && (searchUser(userB) == true)) {
            connectionA = userA.getConnections();
            connectionB = userB.getConnections();
            for (int i = 0;i<connectionA.length; i++) {
                for (int j = 0;j<connectionB.length; j++) {
                    if (connectionA[i].equals(connectionB[i])) {
                        display[size2] = connectionA[i];
                        size2 = size2 + 1;
                    }
                }
            }
            return display;
        }
        return null;
    }

    /**
     * This reutrns the String version of the social network.
     * 
     * @return the String version of the network, return an empty string
     * if there are no users in the network.
     */
    public String toString() {
        if (this.size == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (i = 0; i < size-1; i++) {
            sb.append(users[i] + "\n");
        }
        sb.append(users[i]);
        return sb.toString();
    }
}