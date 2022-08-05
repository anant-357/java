package ds;

public class BST2 {

    public static void main(String... args) {
        BSTStructure root = new BSTStructure(20);
        root.insert(25);
        root.insert(15);
        root.insert(30);
        root.insert(10);
        root.insert(22);
        root.inorder();
        System.out.println(root.search(10));
        root.delete(10);
        root.inorder();
        System.out.println(root.search(10));

    }

}

class BSTStructure {
    private class Node {
        int data;
        Node left = null;
        Node right = null;

        public Node(int key) {
            data = key;
        }

    }

    Node root;

    BSTStructure() {
        root = null;
    }

    BSTStructure(int key) {
        root = new Node(key);
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    public Node insertRecursive(Node root, int key) {
        if (root == null) {
            return new Node(key);
        } else if (root.data < key) {
            root.right = insertRecursive(root.right, key);
        } else if (root.data > key) {
            root.left = insertRecursive(root.left, key);
        }
        return root;
    }

    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    public void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorder() {
        preorderRecursive(root);
        System.out.println();
    }

    public void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorder() {
        postorderRecursive(root);
        System.out.println();
    }

    public void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public Node minimumNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    public Node deleteRecursive(Node root, int key) {
        if (root.data < key) {
            root.right = deleteRecursive(root.right, key);
        } else if (root.data > key) {
            root.left = deleteRecursive(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node temp = minimumNode(root.right);
            root.data = temp.data;
            root.right = deleteRecursive(root.right, key);
        }
        return root;
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    public boolean searchRecursive(Node root, int key) {
        if (key > root.data) {
            if (root.right == null) {
                return false;
            } else {
                return searchRecursive(root.right, key);
            }
        } else if (key < root.data) {
            if (root.left == null) {
                return false;
            } else {
                return searchRecursive(root.left, key);
            }
        } else {
            return true;
        }

    }
}
