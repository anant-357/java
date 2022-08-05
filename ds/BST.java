package ds;

public class BST {

    public static class Node {
        public int data;
        public Node left = null;
        public Node right = null;

        public Node(int key) {
            this.data = key;
        }

        public void addNode(int key) {
            if (this.data > key) {
                if (right == null) {
                    right = new Node(key);
                } else {
                    right.addNode(key);
                }
            } else {
                if (left == null) {
                    left = new Node(key);
                } else {
                    left.addNode(key);
                }
            }
        }

        public boolean search(int key) {

            if (data == key)
                return true;

            if (data > key) {
                return right == null ? false : right.search(key);
            } else {
                return left == null ? false : left.search(key);
            }
        }

        public void inorder() {
            if (left != null) {
                left.inorder();
            }
            System.out.print(data + " ");
            if (right != null) {
                right.inorder();
            }
        }

        public void preorder() {
            System.out.print(data + " ");
            if (left != null) {
                left.preorder();
            }
            if (right != null) {
                right.preorder();
            }
        }

        public void postorder() {
            if (left != null) {
                left.postorder();
            }
            if (right != null) {
                right.postorder();
            }
            System.out.print(data + " ");
        }

        public Node minimumNode() {
            if (left != null) {
                return left.minimumNode();
            } else {
                return this;
            }
        }

        public Node deleteNode(int key) {

            if (data > key) {
                if (right != null) {
                    right = right.deleteNode(key);
                } else {
                    return this;
                }
            } else if (data < key) {
                if (left != null) {
                    left = left.deleteNode(key);
                } else {
                    return this;
                }
            } else {
                if (left == null) {
                    Node temp = right;
                    return temp;
                } else if (right == null) {
                    Node temp = left;
                    return temp;
                }
                Node temp = right.minimumNode();

                data = temp.data;

                right = right.deleteNode(temp.data);
            }

            return this;

        }
    }

    public static void main(String... args) {
        Node root = new Node(20);
        root.addNode(25);
        root.addNode(15);
        root.addNode(30);
        root.addNode(10);
        root.addNode(22);

        root.inorder();
        System.out.println();
        System.out.println(root.search(10));
        root.deleteNode(10);
        root.inorder();
        System.out.println();
        System.out.println(root.search(10));
    }

}
