package com.sj.adt;

/* <T> is not supported as in binary search tree we have to compare keys
    so, T will be int, char, String, boolean everything
    so, comparison will not happen, so we have to type cast T with int
*/

class Node<T> {
    T key;
    Node<T> left, right;
    public Node(T value) {
        key = value;
        left = right = null;
    }
}
public class BinarySearchTree<T> {
    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    //    this method is basically returns the key of a node that is being passes as parameter.
    public T getNodeKey(Node<T> node) {
       return node.key;
    }

    // add one node
    public void addNode(T data) {
        if(root == null) {
            root = new Node<>(data);
            return;
        }
        else {
            Node<T> temp = root;
            while(temp != null) {
                if((Integer)data < (Integer)temp.key) {
                    if(temp.left == null) {
                        temp.left = new Node<>(data);
                        break;
                    }
                    else {
                        temp = temp.left;
                    }
                }
                else {
                    if(temp.right == null) {
                        temp.right = new Node<>(data);
                        break;
                    }
                    else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    // Traversing the tree
    /*
    * 1. In-order: left - root - right
    * 2. Pre-order: root - left - right
    * 3. Post-order: left - right - root
    * */

    public void inOrderTraversing(Node node) {
        if(node == null) {
            return;
        }
        inOrderTraversing(node.left);
        System.out.print(node.key + " ");
        inOrderTraversing(node.right);
    }

    public void preOrderTraversing(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.key + " ");
        preOrderTraversing(node.left);
        preOrderTraversing(node.right);
    }

    public void postOrderTraversing(Node node) {
        if(node == null) {
            return;
        }
        postOrderTraversing(node.left);
        postOrderTraversing(node.right);
        System.out.print(node.key+" ");
    }

    // delete node
    /*
    * 1. deleting leaf node
    * 2. deleting node having one child
    * 3. deleting node having 2 child
    * */

    // Given a binary search tree and a key, this
    // function deletes the key and returns the
    // new root, t = O(h)
    public Node<T> deleteNode(Node<T> node, T k) {
        // Base case
        if (node == null)
            return null;

        // Recursive calls for ancestors of
        // node to be deleted
        if ((Integer)node.key > (Integer)k) {
            node.left = deleteNode(node.left, k);
            return node;
        }
        else if ((Integer)node.key < (Integer)k) {
            node.right = deleteNode(node.right, k);
            return node;
        }

        // We reach here when 'node'
        // will be deleted.

        // If one of the children is empty
        if (node.left == null) {
            Node<T> temp = node.right;
            return temp;
        }
        else if (node.right == null) {
            Node<T> temp = node.left;
            return temp;
        }

        // If both children exist
        else {
            Node<T> succParent = node;

            // Find successor
            Node<T> succ = node.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Delete successor. Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ->right to succParent->right
            if (succParent != node)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            // Copy Successor Data to root
            node.key = succ.key;

            return node;
        }
    }

    // search
    public boolean find(Node node, T data) {
        if(node == null) {
            return false;
        }
        if(node.key == data) {
            return true;
        }
        else if((Integer)node.key > (Integer)data) {
            if(find(node.left, data))
                return true;
        }
        else {
            if(find(node.right, data))
                return true;
        }
        return false;   // when data is not present
    }
}

/*
*main method
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        tree.addNode(3);
//        tree.addNode(1);
//        tree.addNode(4);
//        tree.addNode(2);
//        tree.addNode(5);
        tree.addNode(50);
        tree.addNode(70);
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(40);
        tree.addNode(80);
        tree.addNode(60);

        System.out.print("Inorder : ");
        tree.inOrderTraversing(tree.getRoot());
        System.out.println();
//        System.out.print("Preorder : ");
//        tree.preOrderTraversing(tree.getRoot());
//        System.out.println();
//        System.out.print("Postorder : ");
//        tree.postOrderTraversing(tree.getRoot());

        if(tree.find(tree.getRoot(), 2))
            System.out.println("Present");
        else
            System.out.println("Absent");

        tree.deleteNode(tree.getRoot(), 20);
        System.out.print("Inorder : ");
        tree.inOrderTraversing(tree.getRoot());
        System.out.println();

        tree.deleteNode(tree.getRoot(), 30);
        System.out.print("Inorder : ");
        tree.inOrderTraversing(tree.getRoot());
        System.out.println();

        tree.deleteNode(tree.getRoot(), 50);
        System.out.print("Inorder : ");
        tree.inOrderTraversing(tree.getRoot());
        System.out.println();
* */
