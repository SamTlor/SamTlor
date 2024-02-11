/*
  Name: Kim Long Ly
  Project 5 - Binary Search Tree Implementation
  Course: CMSC-256-901-FA2021
  Date: 10/28/2021 Fall 2021
  THis project will implement a Binary Search Tree using bridges.base.BinTreeElement<E> as the node and by implementing the provided BinTreeInterface<E>.
 */


package cmsc256;

import bridges.connect.Bridges;
import bridges.base.BinTreeElement;

public class kims_BinSearchTree<E extends Comparable<? super E>> implements BinTreeInterface<E> {
    private BinTreeElement<E> root;
    private int size = 0;

    //Constructor
    public kims_BinSearchTree(){
        clear();
    }


    /** Returns the root of this tree
     */
    @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }


    /** Insert element into the binary tree
     * Return true if the element is inserted successfully
     */
    @Override
    public boolean add(E element) {
        BinTreeElement<E> node = new BinTreeElement<E>(element.toString(), element);   //create a new node with a label
        boolean wasAdded = true;

        if (root == null) {
            root = node;
        } else {
            wasAdded = addToParent(root, node);
        }

        if (wasAdded) {
            size++;
        }
        return wasAdded;
    }


    private boolean addToParent(BinTreeElement<E> parentNode, BinTreeElement<E> addNode) {
        int compare = parentNode.getValue().compareTo(addNode.getValue());
        boolean wasAdded = false;

        if (compare > 0) {
            // if parent has no left node, add new node as left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(addNode);
                wasAdded = true;
            }
            else {
                // otherwise, add to parentNode's left (recursive)
                wasAdded = addToParent(parentNode.getLeft(), addNode);
            }
        }
        else if (compare < 0) {
            // if parent has no right node, add new node as right
            if (parentNode.getRight() == null) {
                parentNode.setRight(addNode);
                wasAdded = true;
            }
            else {
                // otherwise, add to parentNode's right (recursive)
                wasAdded = addToParent(parentNode.getRight(), addNode);
            }
        }
        return wasAdded;
    }


    /** Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    @Override
    public boolean remove(E element) {
        if (root == null) {
            return false;
        }
        if (root.getValue().compareTo(element) == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            }
            else if (root.getRight() == null) {
                root = root.getLeft();
            }
            else {
                BinTreeElement<E> formerRight = root.getRight();
                root = root.getLeft();
                addToParent(root, formerRight);
            }
            size--;
            return true;
        }
        return removeSubNode(root, element);
    }

    private boolean removeSubNode(BinTreeElement<E> parent, E removeValue) {
        int compareParent = parent.getValue().compareTo(removeValue);
        BinTreeElement<E> subTree = null;

        if (compareParent > 0)

            subTree = parent.getLeft();

        else

            subTree = parent.getRight();

        if (subTree == null) {
            return false;
        }

        if (subTree.getValue().compareTo(removeValue) == 0) {
            BinTreeElement<E> replacement;
            if (subTree.getLeft() == null) {
                replacement = subTree.getRight();
            }
            else if (subTree.getRight() == null) {
                replacement = subTree.getLeft();
            }
            else {
                BinTreeElement<E> formerRight = subTree.getRight();
                replacement = subTree.getLeft();
                addToParent(replacement, formerRight);
            }

            if (compareParent > 0) {
                parent.setLeft(replacement);
            }
            else {
                parent.setRight(replacement);
            }

            size--;
            return true;
        }
        return removeSubNode(subTree, removeValue);
    }


    /** Returns the number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }


    /** Return true if the tree is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }


    /** Removes all nodes from the tree
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    /** Return true if the element is in the tree
     */
    @Override
    public boolean search(E target) {
        return find(root, target) != null;
    }


    //Find the element in the tree
    private E find(BinTreeElement<E> element, E key){
        if (element == null)
            return null;

        if (element.getValue().compareTo(key) > 0)
            return find(element.getLeft(), key);

        else if (element.getValue().compareTo(key) == 0)
            return element.getValue();

        else
            return find(element.getRight(), key);
    }


    /** Inorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
    @Override
    public String inorder() {
        return inorder(root);
    }


    private String inorder(BinTreeElement<E> element){
        String result = "";
        if (element != null) {
            result = result + inorder(element.getLeft());
            result = result + element.getValue() + "  ";
            result = result + inorder(element.getRight());
        }
        return result;
    }


    /** Postorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
    @Override
    public String postorder() {
        return postorder(root);
    }


    private String postorder(BinTreeElement<E> element){
        String result = "";
        if (element != null) {
            result = result + postorder(element.getLeft());
            result = result + postorder(element.getRight());
            result = result + element.getValue() + "  ";
        }
        return result;
    }


    /** Preorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
    @Override
    public String preorder() {
        return preorder(root);
    }


    private String preorder(BinTreeElement<E> element){
        String result = "";
        if (element != null) {
            result = result + element.getValue() + "  ";
            result = result + preorder(element.getLeft());
            result = result + preorder(element.getRight());
        }
        return result;
    }


    /** Return the height of this binary tree */
    public int height() {
        return height(root);
    }


    private int height(BinTreeElement<E> root){
        if (root == null)
            return -1;

        if (root.getLeft() == null && root.getRight() == null)
            return 0;

        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }


    /** Returns true if the tree is a full binary tree */
    public boolean isFullBST() {
        return isFullBST(root);
    }


    private boolean isFullBST(BinTreeElement<E> root){
        if(root == null)
            return false;

        if(root.getLeft() == null && root.getRight() == null)
            return true;

        if((root.getLeft() != null) && (root.getRight() != null))
            return (isFullBST(root.getLeft()) && isFullBST(root.getRight()));

        return false;
    }


    /** Return the number of leaf nodes */
    public int getNumberOfLeaves() {
        return getNumberOfLeaves(root);
    }


    private int getNumberOfLeaves(BinTreeElement<E> root){
        if(root == null)
            return 0;

        if(root.getLeft() == null && root.getRight() == null)
            return 1;

        return getNumberOfLeaves(root.getLeft()) + getNumberOfLeaves(root.getRight());
    }


    /** Return the number of non-leaf nodes */
    public int getNumberOfNonLeaves() {
        return getNumberOfNonLeaves(root);
    }


    private int getNumberOfNonLeaves(BinTreeElement<E> root){
        if (root == null)
            return 0;

        if (root.getLeft() == null && root.getRight() == null)
            return 0;

        return 1 + getNumberOfNonLeaves(root.getLeft()) + getNumberOfNonLeaves(root.getRight());
    }

    //main method that adds elements to the tree and visualize the tree in Bridges
    public static void main(String[] args) throws Exception{

        //create the Bridges object
        Bridges bridges = new Bridges(5, "lyk4", "909236433996");

        // title, description
        bridges.setTitle("CMSC 256 Project 5 Kim Long Ly");
        bridges.setDescription("Sample Display on Bridges with labels");

        BinSearchTree<String> names = new BinSearchTree<>();

        names.add("Frodo");

        names.add("Dori");

        names.add("Bilbo");

        names.add("Kili");

        names.add("Gandalf");

        names.add("Fili");

        names.add("Thorin");

        names.add("Nori");

        // visualize the tree
        bridges.setDataStructure(names.getRoot());
        bridges.visualize();

        System.out.println("The root of this tree is " + names.getRoot().getValue() + "\n");
        System.out.println("Is Gandalf in this tree? " + names.search("Gandalf") + "\n");
        System.out.println("Is Kim in this tree? " + names.search("Kim") + "\n");
        System.out.println("The height of the tree is " + names.height() + "\n");
        System.out.println("The number of leaves is " + names.getNumberOfLeaves() + "\n");
        System.out.println("The number of non leaves is " + names.getNumberOfNonLeaves() + "\n");
        System.out.println("Is this a full binary tree? " + names.isFullBST() + "\n");
        System.out.println("Inorder traversal from the root: " + names.inorder() + "\n");
        System.out.println("Preorder traversal from the root: " + names.preorder() + "\n");
        System.out.println("Postorder traversal from the root: " + names.postorder()+ "\n");
    }
}
