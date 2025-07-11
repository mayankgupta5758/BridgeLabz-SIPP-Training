import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class FriendConnectionSystem {
    User head = null;

    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) head = newUser;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    User getUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 != null && u2 != null) {
            if (!u1.friendIds.contains(id2)) u1.friendIds.add(id2);
            if (!u2.friendIds.contains(id1)) u2.friendIds.add(id1);
        }
    }

    void removeFriend(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(id2));
            u2.friendIds.remove(Integer.valueOf(id1));
        }
    }

    void mutualFriends(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 != null && u2 != null) {
            System.out.print("Mutual Friends: ");
            for (int fid : u1.friendIds) {
                if (u2.friendIds.contains(fid)) {
                    System.out.print(fid + " ");
                }
            }
            System.out.println();
        }
    }

    void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        }
    }

    void searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.userId + " - " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public static void main(String[] args) {
        FriendConnectionSystem fcs = new FriendConnectionSystem();
        fcs.addUser(1, "Alice", 20);
        fcs.addUser(2, "Bob", 22);
        fcs.addUser(3, "Charlie", 21);

        fcs.addFriend(1, 2);
        fcs.addFriend(1, 3);

        fcs.displayFriends(1);
        fcs.mutualFriends(2, 3);

        fcs.searchByName("Bob");
    }
}
