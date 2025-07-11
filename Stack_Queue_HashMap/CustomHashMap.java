class Entry {
    String key;
    int value;
    Entry next;

    public Entry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap {
    private final int SIZE = 100;
    private Entry[] table = new Entry[SIZE];

    private int getIndex(String key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(String key, int value) {
        int index = getIndex(key);
        Entry newNode = new Entry(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Entry current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Integer get(String key) {
        int index = getIndex(key);
        Entry current = table[index];
        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }

    public void remove(String key) {
        int index = getIndex(key);
        Entry current = table[index];
        Entry prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null)
                    table[index] = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("apple", 10);
        map.put("banana", 20);
        System.out.println(map.get("apple")); 
        map.remove("apple");
        System.out.println(map.get("apple")); 
    }
}
