public class DeleteKthNode {

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

    // Delete every k-th node
    public void deleteEveryKthNode(int k) {
        if (k <= 1) {
            // If k is 1 or less, delete entire list
            head = null;
            return;
        }
        if (head == null) return;

        Node curr = head;
        Node prev = null;
        int count = 1;

        while (curr != null) {
            if (count % k == 0) {
                // Delete current node
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
            count++;
        }
    }

    // Display list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        DeleteKthNode list = new DeleteKthNode();

        for (int i = 1; i <= 10; i++) {
            list.append(i);
        }

        System.out.println("Original list:");
        list.display();

        int k = 3;
        list.deleteEveryKthNode(k);

        System.out.println("After deleting every " + k + "-th node:");
        list.display();
    }
}
