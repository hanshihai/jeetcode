package jeet.code;

public class CircularLinkedList {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    //add a new node at the start of the linked list
    public void addNodeAtStart(int data) {
        System.out.println("Adding node " + data + " at start");
        Node n = new Node(data);
        if (size == 0) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            Node temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(int data) {
        if (size == 0) {
            addNodeAtStart(data);
        } else {
            Node n = new Node(data);
            tail.next = n;
            tail = n;
            tail.next = head;
            size++;
        }
        System.out.println("Node " + data + " is added at the end of the list");
    }

    public void deleteNodeFromStart() {
        if (size == 0) {
            System.out.println("\nList is Empty");
        } else {
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    public int elementAt(int index) {
        if (index > size) {
            return -1;
        }
        Node n = head;
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        return n.data;
    }

    //print the linked list
    public void print() {
        System.out.print("Circular Linked List:");
        Node temp = head;
        if (size <= 0) {
            System.out.print("List is empty");
        } else {
            do {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            while (temp != head);
        }
        System.out.println();
    }

    //get Size
    public int getSize() {
        return size;
    }

    //get head
    public Node getHead() {
        return head;
    }

    //remove the N element from circle, and set the N+1 as head
    public void removeN(int n) {
        if (n <= 0) {
            System.out.println("No remove as the number is " + n);
        }
        if (n == 1) {
            deleteNodeFromStart();
        } else {
            Node start = head;
            int i = 1;
            while (i < n - 1) {
                start = start.next;
                i++;
            }
            Node removed = start.next;
            head = removed.next;
            tail = start;
            tail.next = head;
            size--;
        }
    }

    public Node circle(int length) {
        for (int i = 1; i <= length; i++) {
            addNodeAtEnd(i);
        }
        while (true) {
            removeN(length);
            print();
            if (getSize() == 1) {
                break;
            }
        }
        return getHead();
    }

    public static void main(String[] args) {
        int length = Integer.valueOf(args[0]);
        CircularLinkedList c = new CircularLinkedList();
        Node left = c.circle(length);
        System.out.println("The left is : " + left.data);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}