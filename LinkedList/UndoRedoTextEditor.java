class State {
    String content;
    State prev, next;

    State(String content) {
        this.content = content;
    }
}

public class UndoRedoTextEditor {
    State head = null, current = null;
    int limit = 10;
    int count = 0;

    void addState(String text) {
        State newState = new State(text);
        if (head == null) {
            head = current = newState;
            count = 1;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            count++;

            // Trim older history if exceeding limit
            if (count > limit) {
                head = head.next;
                head.prev = null;
                count--;
            }
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No Text Available");
        }
    }

    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.displayCurrent();

        editor.undo();
        editor.displayCurrent();

        editor.redo();
        editor.displayCurrent();
    }
}
