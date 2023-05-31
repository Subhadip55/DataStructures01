package com.sj.adt;

public class BalancedTree<T> {
    private Node<T> root;

    public BalancedTree(Node<T> root) {
        this.root = root;
    }

    // Balance factor
    public int balanceFactor(Node<T> node) {
        int balance_factor  = height(node.right) - height(node.left);
        return balance_factor;
    }
    /*
    * This method determines the height of the node that is being passed.
    * */
    public int height(Node<T> node) {
        if(node == null) {
            return 0;
        }
        else {
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    // left rotation
    /*
    * 1. Make root's right node as root
    * 2. Left child of new root is assigned as a right node of old root
    * 3. New root's left will be the old root
    *
    */
    public Node<T> leftRotation(Node<T> node, boolean isRoot) {

//         1st check whether the argument's balance factor is greater than 1 or not.
//         if it is  greater than rotation needs to execute to balance.
//         for root node, balance factor greater than 1
//        for child node, balance factor greater equal to 1

        int bfactor = balanceFactor(node);
        if ((bfactor > 1 && isRoot) || (bfactor >= 1 && !isRoot)) {  // that means right side is heavier than left
//            equals to is only for right-left / left-right rotation
//`           here left rotation will be executed
            Node<T> temp = node;     // temp = old root, node = new root

            node = node.right;      // 1st instruction executed

            temp.right = node.left; // 2nd instruction executed

            node.left = temp;       // 3rd instruction executed

            System.out.println("Left Rotation successful");

            return node;

        }
        // else no left rotation is needed.
        else {
            System.out.println("Not needed to execute left rotation.");
            return node;
        }
    }

    /*
    * Right rotation:
    *   1. Left child of the root will be new root
    *   2. Right child of the new root will be assigned to the left of the old root
    *   3. Make the old root as the right child of the new root.
    */

    // right rotation
    public Node<T> rightRotation(Node<T> node, boolean isRoot) {

//         1st check whether the argument's balance factor is less than -1 or not.
//         if it is less than rotation needs to execute to balance.

//         for root node, balance factor greater than 1
//        for child node, balance factor greater equal to 1

        int bfactor = balanceFactor(node);
        if((bfactor < -1 && isRoot) || (bfactor <= -1 && !isRoot)) {  // that means left side is heavier than left
//            equals to is only for right-left / left-right rotation
//`           here right rotation will be executed
            Node<T> temp = node;    // temp = old root, node = new root

            node = node.left;      // 1st instruction executed

            temp.left = node.right; // 2nd instruction executed

            node.right = temp;       // 3rd instruction executed

            System.out.println("Right Rotation successful");

            return node;

        }
        // else no right rotation is needed.
        else {
            System.out.println("Not needed to execute right rotation.");
            return node;
        }
    }
    // Right-Left rotation
    /*
        Right rotation of left rotated tree.
        a.  Left rotation of left child of the root node
        b.  Right rotation the root.
    */
    public Node<T> rightLeftRotation(Node<T> node) {
//        leftRotation(node.left);
        /*
        * Point to remember:
        *   We can simply use leftRotataion(node.left) to get things done
        *   But, left/right rotation will execute when balance factor(modulous) is more than 1
        *   In case of tree having left height 1, this method will not execute
        *   actually the tree having height of 2
        *
        * For that scenario, we have to re-implementy the rotation method
        * ensure that rotation will execute even if balance factor is 1
        *
        * To tackle that I passed a parameter named isRoot so that we can know
        * the passing parameter is root or not.
        * */

        node.left = leftRotation(node.left, false);
        return rightRotation(node, true);
    }


    // Left-Right rotation
    /*
    Left rotation of a right rotated tree
        a.  Right rotate the right child of the root node
        b.  Left rotate the root.
    * */
    public Node<T> leftRightRotation(Node<T> node) {
        node.right = rightRotation(node.right, false);
        return leftRotation(node, true);
    }

//   To balance tree automatically
    public Node<T> balance(Node<T> node) {
        /*
        *   If the tree is left heavy and if the left child is right heavy,
                then perform Right-Left rotation
            otherwise perform right rotation
        * */
        if (balanceFactor(node) < -1) {
            if (balanceFactor(node.left) >= 1) {
                // do Right-Left rotation
                return rightLeftRotation(node);
            }
            else {
                return rightRotation(node, true);
            }
        }
        /*
            If the tree is right heavy and it's right child is left heavy
                then perform Left-Right rotation
            otherwise perform left rotation
        */
        else if (balanceFactor(node) > 1) {
            if (balanceFactor(node.right) <= -1) {
                // do Left-Right rotation
                return leftRightRotation(node);
            }
            else {
                return leftRotation(node, true);
            }
        }
        else {
            System.out.println("Hurrah!! The tree is already balanced.");
            return node;
        }




        /*
            If the tree is neither left  or right heavy
                then the tree is balanced
        */
    }

}
