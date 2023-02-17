import java.util.Scanner;

public class Queue {
    private int capacity, front;
   private static int rear;
    private int[] arr;

    public void ArrayQueue(int size) {
        capacity = size;
        front = -1;
        rear = -1;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        System.out.println("Enqueued item: " + item);
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        int item = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return item;
        
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();

        ArrayQueue queue = new ArrayQueue(capacity);

        while (true) {
            System.out.println("\n1. Enqueue an item");
            System.out.println("2. Dequeue an item");
            System.out.println("3. Peek at the front item");
            System.out.println("4. Check if queue is empty");
            System.out.println("5. Check if queue is full");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to enqueue: ");
                    int item = scanner.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    Integer dequeued = queue.dequeue();
                    if (dequeued != null) {
                        System.out.println("Dequeued item: " + dequeued);
                    }
                    break;
                case 3:
                    Integer front = queue.peek();
                    if (front != null) {
                        System.out.println("Front item: " + front);
                    }
                    break;
                case 4:
                    boolean isEmpty = queue.isEmpty();
                    System.out.println("Queue is empty: " + isEmpty);
                    break;
                case 5:
                    boolean isFull = queue.isFull();
                    System.out.println("Queue is full: " + isFull);
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}