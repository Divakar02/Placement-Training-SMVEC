public class MiddleOfLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    Node head;

    // Add node to end
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    // Find middle element
    public int findMiddle() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Print the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        MiddleOfLinkedList list = new MiddleOfLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        list.display();

        int mid = list.findMiddle();
        System.out.println("Middle Element: " + mid);
    }
}
