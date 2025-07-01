// Hybrid Inheritance (with Interface)

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is cooking dishes.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Raj", 101);
        Waiter waiter = new Waiter("Vikram", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}
