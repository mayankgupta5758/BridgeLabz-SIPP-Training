class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    Task head = null, tail = null;
    Task current = null;

    void addTask(int id, String name, int pr, String due) {
        Task newTask = new Task(id, name, pr, due);
        if (head == null) {
            head = tail = current = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    void removeTask(int id) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) tail = prev;
                }
                if (temp == current) current = current.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void nextTask() {
        if (current != null) {
            System.out.println("Task: " + current.name + " | Due: " + current.dueDate);
            current = current.next;
        }
    }

    void searchByPriority(int pr) {
        Task temp = head;
        do {
            if (temp.priority == pr)
                System.out.println(temp.name + " - " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void displayAll() {
        Task temp = head;
        if (temp == null) return;
        do {
            System.out.println(temp.id + ": " + temp.name + " - " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addTask(1, "Math Homework", 2, "10-07-2025");
        ts.addTask(2, "Science Project", 1, "12-07-2025");
        ts.displayAll();
        ts.nextTask();
        ts.nextTask();
        ts.removeTask(1);
        ts.displayAll();
    }
}
