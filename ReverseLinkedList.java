public class ReverseLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    Node head;

    // Add node at end
    public void append(int val) {
        Node newNode = new Node(val);
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

    // Reverse linked list iteratively
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;  // save next
            curr.next = prev;  // reverse pointer
            prev = curr;       // move prev forward
            curr = next;       // move curr forward
        }

        head = prev;  // reset head to new first node
    }

    // Print list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Test the reverse
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original list:");
        list.display();

        list.reverse();

        System.out.println("Reversed list:");
        list.display();
    }
}
