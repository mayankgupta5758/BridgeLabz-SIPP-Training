import java.util.Scanner;

class LL {
    private Node head;
    private Node tail;
    int size = 0;

    public Node getHeadNode() {
        return head;
    }

    public Node getTailNode() {
        return tail;
    }

    static class Node {
        int num;
        String data;
        Node next;
        Node prev;

        Node(String data, int num) {
            this.data = data;
            this.num = num;
        }

        @Override
        public String toString() {
            return num + "." + data;
        }
    }

    public Node createLL(String data, int num) {
        Node node = new Node(data, num);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return node;
    }

    public Node deleteNode(int idx) {
        if (head == null || idx <= 0 || idx > size) return null;

        Node temp = head;

        while (temp != null) {
            if (temp.num == idx) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                size--;
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("End");
    }

    public int tailData() {
        return tail != null ? tail.num : 0;
    }

    public Node nextNode(int idx) {
        Node temp = head;
        while (temp != null) {
            if (temp.num == idx) return temp.next;
            temp = temp.next;
        }
        return null;
    }

    public Node backNode(int idx) {
        Node temp = head;
        while (temp != null) {
            if (temp.num == idx) return temp.prev;
            temp = temp.next;
        }
        return null;
    }
}

public class BrowserHistoryNavigation {

    public static void main(String[] args) {
        LL l = new LL();
        l.createLL("Instagram", 1);
        l.createLL("Facebook", 2);
        l.createLL("Reddit", 3);
        l.createLL("Gmail", 4);
        l.createLL("Java", 5);
        l.display();

        Scanner sc = new Scanner(System.in);
        int lastIdx = l.tailData();

        System.out.println("------------------------------------------------------------------");
        System.out.println("You want to Add or Delete something? Add: 1 or Delete: 2 or Exit: 0");
        int num = sc.nextInt();
        sc.nextLine(); 

        OUTER:
        while (num != 0) {
            switch (num) {
                case 1 -> {
                    System.out.print("Enter History topic: ");
                    String data = sc.nextLine();
                    lastIdx++;
                    l.createLL(data, lastIdx);
                    System.out.println();
                    l.display();
                    System.out.println("------------------------------------------------------------------");
                }
                case 2 -> {
                    System.out.print("Enter the number you want to delete: ");
                    int del = sc.nextInt();
                    LL.Node deleted = l.deleteNode(del);
                    System.out.println("You Deleted: " + (deleted != null ? deleted : "Invalid Index"));
                    l.display();
                    System.out.println("------------------------------------------------------------------");
                }
                default -> {
                    break OUTER;
                }
            }

            System.out.println("Add: 1 or Delete: 2 or Exit: 0");
            num = sc.nextInt();
            sc.nextLine(); 
        }

        System.out.println("Where You Want To Move? Back: 1 or Forward: 2 or Exit: 0");
        int check = sc.nextInt();
        int his = 1;

        OUTER:
        while (check != 0) {
            switch (check) {
                case 1 -> {
                    LL.Node back = l.backNode(his);
                    if (back == null) {
                        System.out.println("You Can't Go Back");
                    } else {
                        his = back.num;
                        System.out.println("Moved to: " + back.data);
                    }
                    System.out.println("------------------------------------------------------------------");
                }
                case 2 -> {
                    LL.Node forward = l.nextNode(his);
                    if (forward == null) {
                        System.out.println("You Can't Go Forward");
                    } else {
                        his = forward.num;
                        System.out.println("Moved to: " + forward.data);
                    }
                    System.out.println("------------------------------------------------------------------");
                }
                default -> {
                    break OUTER;
                }
            }

            System.out.println("Back: 1 or Forward: 2 or Exit: 0");
            check = sc.nextInt();
        }
    }
}
