package cmsc256;

public class BinarySearchTree <E extends Comparable<? super E>>{

    private int size = 0;
    private BinaryNode root = null;

    class BinaryNode{
        protected E value;
        protected BinaryNode right;
        protected BinaryNode left;

        BinaryNode(E theValue){
            value = theValue;
        }
    }


    private boolean addToParent(BinaryNode parentNode, BinaryNode theNode){
        int compare = parentNode.value.compareTo(theNode.value);
        boolean wasAdded = false;

        if (compare > 0){
            if (parentNode.left == null){
                parentNode.left = theNode;
                wasAdded = true;
            }
            else{
                wasAdded = addToParent(parentNode.left, theNode);
            }
        }
        else if(compare < 0){
            if (parentNode.right == null){
                parentNode.right = theNode;
                wasAdded = true;
            }
            else{
                wasAdded = addToParent(parentNode.right, theNode);
            }
        }
        return wasAdded;
    }

    public boolean add(E inValue){
        BinaryNode node = new BinaryNode(inValue);
        boolean wasAdded = true;

        if (root == null){
            root = node;
        }
        else{
            wasAdded = addToParent(root, node);
        }

        size++;
        return wasAdded;
    }

    public boolean remove(E removeValue){
        if (root == null){                              //tree is empty return false
            return false;
        }
        if (root.value.compareTo(removeValue) == 0) {   //if root is the remove value
            if (root.left == null) {                    //if the value on the left is blank then make the right value the new root
                root = root.right;
            }
            else if (root.right == null) {              //if the value on the right is blank then make the left value the new root
                root = root.left;
            }
            else {                                      //if neither the left nor right is blank
                BinaryNode formerRight = root.right;    //store the right node
                root = root.left;                       //make the left node the root node
                addToParent(root, formerRight);         //add the right node that I stored to the new root
            }
            size--;
            return true;
        }
        return removeSubNode(root, removeValue);
    }

    private boolean removeSubNode(BinaryNode parent, E removeValue){
        int compareParent = parent.value.compareTo(removeValue);
        
        BinaryNode subtree = null;
        if (compareParent > 0){                         //if parent alphabetically comes after 'remove value'
            subtree = parent.left;                      //subtree to store is the left one
        }
        else {
            subtree = parent.right;                     //otherwise the subtree to store is the right one
        }

        if (subtree == null){                           //if subtree is null then the remove value isn't in
            return false;                               //the binary tree so just return false
        }


        if (subtree.value.compareTo(removeValue) == 0){
            BinaryNode replacement;             
            if (subtree.left == null){                  //if the left node is blank
                replacement = subtree.right;            //use replacement to put the right one in
            }
            else if(subtree.right == null){             //if the right node is blank
                replacement = subtree.left;             //use replacement to put the left one in
            }
            else{                                       //if niether of them is blank
                BinaryNode formerRight = subtree.right; //store the right one
                replacement = subtree.left;             //use replacement to put the left one in ...but
                addToParent(replacement, formerRight);  //...but add the right one to the left one
            }

            if (compareParent > 0){
                parent.right = replacement;
            }
            else{
                parent.left = replacement;
            }

            size--;
            return true;
        }

        return removeSubNode(subtree, removeValue);
    }

    public int size(){
        return size;
    }
    public BinaryNode getRoot(){
        return root;
    }
    public void clear(){
        root = null;
        size = 0;
    }
}