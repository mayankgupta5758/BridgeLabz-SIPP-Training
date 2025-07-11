class Process {
    int pid, burstTime, priority;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    Process head = null, tail = null;

    void addProcess(int pid, int burst, int priority) {
        Process p = new Process(pid, burst, priority);
        if (head == null) {
            head = tail = p;
            p.next = head;
        } else {
            tail.next = p;
            tail = p;
            tail.next = head;
        }
    }

    void execute(int quantum) {
        int totalTime = 0;
        Process curr = head;
        while (true) {
            boolean done = true;
            Process temp = curr;
            do {
                if (temp.burstTime > 0) {
                    done = false;
                    if (temp.burstTime > quantum) {
                        totalTime += quantum;
                        temp.burstTime -= quantum;
                    } else {
                        totalTime += temp.burstTime;
                        System.out.println("Process " + temp.pid + " done at " + totalTime);
                        temp.burstTime = 0;
                    }
                }
                temp = temp.next;
            } while (temp != curr);
            if (done) break;
        }
    }

    public static void main(String[] args) {
        RoundRobinScheduler rr = new RoundRobinScheduler();
        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 3);
        rr.execute(4);
    }
}
