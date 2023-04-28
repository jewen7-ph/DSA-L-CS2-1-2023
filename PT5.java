import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private Node insertHelper(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertHelper(current.left, value);
        } else if (value > current.value) {
            current.right = insertHelper(current.right, value);
        }

        return current;
    }

    public void inOrderTraversal() {
        inOrderTraversalHelper(root);
        System.out.println();
    }

    private void inOrderTraversalHelper(Node current) {
        if (current != null) {
            inOrderTraversalHelper(current.left);
            System.out.print(current.value + " ");
            inOrderTraversalHelper(current.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversalHelper(root);
        System.out.println();
    }

    private void preOrderTraversalHelper(Node current) {
        if (current != null) {
            System.out.print(current.value + " ");
            preOrderTraversalHelper(current.left);
            preOrderTraversalHelper(current.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversalHelper(root);
        System.out.println();
    }

    private void postOrderTraversalHelper(Node current) {
        if (current != null) {
            postOrderTraversalHelper(current.left);
            postOrderTraversalHelper(current.right);
            System.out.print(current.value + " ");
        }
    }
}

public class PT5 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Size of Tree: ");

        int userInput = scanner.nextInt();

        System.out.println("Enter Elements of the Tree: ");

        for(int x = 0; x < userInput; x++){
            int treeElement = scanner.nextInt();
            tree.insert(treeElement);
        }

        System.out.println("Select a traversal method:");
        System.out.println("[1] In-order traversal");
        System.out.println("[2] Pre-order traversal");
        System.out.println("[3] Post-order traversal");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("In-order traversal:");
                tree.inOrderTraversal();
                break;
            case 2:
                System.out.println("Pre-order traversal:");
                tree.preOrderTraversal();
                break;
            case 3:
                System.out.println("Post-order traversal:");
                tree.postOrderTraversal();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}