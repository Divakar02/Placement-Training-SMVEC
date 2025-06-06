public class ReverseInGroups {

    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    Node head;

    // Add node at the end
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

    // Reverse linked list in groups of size k
    public Node reverseInGroups(Node head, int k) {
        if (head == null) return null;

        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse first k nodes
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // next is now pointing to (k+1)th node
        // Recursively call for the list starting from next
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }

        // prev is new head of reversed group
        return prev;
    }

    // Utility to display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Test the reverse in groups function
    public static void main(String[] args) {
        ReverseInGroups list = new ReverseInGroups();

        for (int i = 1; i <= 10; i++) {
            list.append(i);
        }

        System.out.println("Original list:");
        list.display();

        int k = 3;
        list.head = list.reverseInGroups(list.head, k);

        System.out.println("List after reversing in groups of " + k + ":");
        list.display();
    }
}
