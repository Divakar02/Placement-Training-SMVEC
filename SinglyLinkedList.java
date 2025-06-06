// Basic implementation of Singly Linked List in Java

public class SinglyLinkedList {

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

    // Add a node at the end
    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add a node at the beginning
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Delete first occurrence of a value
    public void delete(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Print the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the linked list
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.display();

        list.prepend(5);
        list.display();

        list.delete(20);
        list.display();
    }
}
