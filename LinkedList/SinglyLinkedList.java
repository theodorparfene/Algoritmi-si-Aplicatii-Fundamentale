package LinkedList;

public class SinglyLinkedList<E> {

    private Node listHead;

    public SinglyLinkedList (E[] values) {
        Node head = new Node();
        Node it = head;
        for (E elem : values) {
            Node newNode = new Node(elem);
            it.next(newNode);
            it = it.next();
        }

        listHead = head.next();
    }

    public SinglyLinkedList () {}

    public void iterate() {
        Node it = listHead;
        while (it != null) {
            E crtElement = it.value();
            System.out.println(crtElement);
            it = it.next();
        }
    }

    public boolean find(E key) {
        for (Node it = listHead; it != null; it = it.next()) {
            if (it.value().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void insert(E newValue, int pos) {
        Node it = listHead;
        for (int i = 0; i < pos - 1; i++) {
            it = it.next();
        }
        Node newNode = new Node(newValue);
        newNode.next(it.next());
        it.next(newNode);
    }

    public E remove(int pos) {
        Node it = listHead;
        for (int i=0; i<pos-1; i++) {
            it = it.next();
        }
        E removedEl = it.next().value();
        it.next(it.next().next());
        return removedEl;
    }

    private class Node {
        private E value;
        private Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this(value, null);
        }

        public Node() {}

        public void value(E value) {
            this.value = value;
        }

        public E value() {
            return value;
        }

        public Node next() {
            return next;
        }

        public void next(Node next) {
            this.next = next;
        }
    }
}

