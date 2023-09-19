
public class DoublyLinkedList {

    Node head;

    public class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value)
        {
            this.value = value;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;
        node.next = null;

        if (head ==  null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int value) {
        Node prev = find(after);
        if (prev == null) {
            System.out.println("DOES NOT EXIST");
            return;
        }
        Node node = new Node(value);
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        if (node.next != null)
            node.next.prev = node;
    }

    public void display() {
        Node node = head;
        Node last = null;

        while (node != null) {
            System.out.print(node.value + " " );
            last = node;
            node = node.next;
        }
        System.out.println();

        System.out.println("Print in Reverse : ");
        while (last != null) {
            System.out.print(last.value + " ");
            last = last.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DoublyLinkedList dList = new DoublyLinkedList();

        dList.insertFirst(18);
        dList.insertFirst(62);
        dList.insertFirst(56);
        dList.insertFirst(34);
        dList.insertLast(90);
        dList.insert(62, 5);
        dList.display();
    }
}