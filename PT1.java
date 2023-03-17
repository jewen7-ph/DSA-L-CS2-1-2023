//Eusebio, Alain Eleazar V.     
//BSCS 2-1                                     
//PT1 DSA 2023 

import java.util.Scanner;

public class PT1 {
    static Scanner sc = new Scanner(System.in);

    static class Node { //Variables for DOubly Linked List 
        int data;
        Node next;
        Node prev;

        Node(int data) { //To run Doubly Linked List
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node head;

    public static void main(String[] args) {
        int choice, item;
        do {
            System.out.println("\nDoubly Linked List \n\n1.Create\n2.Traverse\n3.Search\n4.Delete\n5.Exit\nEnter your choice: "); //Main Menu
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter the item: ");
                    item = sc.nextInt();
                    create(item);
                    break;

                case 2:
                    traverse();
                    break;

                case 3:
                    search();
                    break;

                case 4:
                    System.out.println("Enter the item to be deleted: ");
                    item = sc.nextInt();
                    delete(item);
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
            }
        } while (choice != 5);
    }

    static void create(int item) {
        Node ptr = new Node(item);

        if (head == null) { //Insert numbers to the head
            ptr.next = null;
            ptr.prev = null;
            head = ptr;
        } else {
            ptr.prev = null;
            ptr.next = head;
            head.prev = ptr;
            head = ptr;
        }
        System.out.println("Node inserted.");
    }

    static void traverse() { //Display inserted numbers
        if (head == null) {
            System.out.println("Empty list.");
            return;
        }

        System.out.print("List: ");
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static void search() { //Display inserted number and its position (Number must be equal to user input)
        if (head == null) {
            System.out.println("Empty list."); //If no user input made into the program
            return;
        }

        System.out.println("Enter item to be searched: ");
        int item = sc.nextInt();
        Node ptr = head;
        int i = 1;
        boolean flag = false;
        while (ptr != null) {
            if (ptr.data == item) {
                System.out.println("Item Location: " + i);
                flag = true;
                break;
            }
            i++;
            ptr = ptr.next;
        }
        if (!flag) {
            System.out.println("Item not found.");
        }
    }

    static void delete(int item) { //Delete number inserted (Number must be equal to user input)
        if (head == null) {
            System.out.println("List is Empty."); //If no user input made into the program
            return;
        }

        Node ptr = head;
        while (ptr != null && ptr.data != item) {
            ptr = ptr.next;
        }
        if (ptr == null) {
            System.out.println("Item not found.");
            return;
        }
        if (ptr == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (ptr.next == null) {
            ptr.prev.next = null;
        } else {
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
        System.out.println("Node deleted.");
    }
}