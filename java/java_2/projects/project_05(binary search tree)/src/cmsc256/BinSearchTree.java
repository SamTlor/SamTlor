/*
* Sam Taylor
* Project 5 - Binary Search Tree Implementation 
* 11/2/21
* CMSC256
* 
* This project implements the BinTreeInterface to be able to create a binary tree that can be added to, removed from, and searched.
* It can also return information about the tree such as the height of the tree, whether or not the tree is a full binary tree, the number
* of leaves or elements that are not leaves. It can also print all of the elements of the tree in preorder, inorder, and postorder.
*/

package cmsc256;
import bridges.base.BinTreeElement;
import bridges.connect.Bridges;

public class BinSearchTree<E> implements BinTreeInterface<E>{

    private int size = 0;                                                               //instance variables
    private BinTreeElement root = null;


    public BinTreeElement<E> getRoot(){                                                 //getter no setters
        return root;
    }

    public boolean addToParent(BinTreeElement parentElement, BinTreeElement element){   //this is how we did it in lab 9 so...
        int compare = parentElement.compareTo(element);                                 //compare parent to element to add
        boolean wasAdded = false;                                                       //if we can't add it we have a boolean to return

        if (compare > 0){                                                               //if the element goes on the left side
            if (parentElement.getLeft() == null){                                       //see if the closest left side is empty
                parentElement.setLeft(element);                                         //if it is empty put the element there
                wasAdded = true;                                                        //return true
            }
            else{
                wasAdded = addToParent(parentElement.getLeft(), element);               //if it's not empty add it to left element
            }                                                                           //call it recursively to add it correctly
        }
        else if(compare < 0){                                                           //if the element goes on the right side
            if (parentElement.getRight() == null){                                      //see if the closest right side is empty
                parentElement.setRight(element);                                        //if it is empty put the element there
                wasAdded = true;                                                        //return true
            }
            else{
                wasAdded = addToParent(parentElement.getRight(), element);              //if it's not empty add it to the left element
            }                                                                           //call it recursively to add it correctly
        }
        return wasAdded;                                                                //final return
    }

    public boolean add(E element){                                                      //implementing BinTreeInterface
        BinTreeElement<String> inGoer = new BinTreeElement(element.toString(), element);//create a BinTreeElement so addToParent works
        boolean wasAdded = true;                                                        //final final return

        if (root == null){                                                              //if root is empty just change root to E element
            root = inGoer;
        } 
        else{
            wasAdded = addToParent(root, inGoer);                                       //otherwise call addToParent to do the real work
        }

        size++;                                                                         //size has changed 
        return wasAdded;                                                                //return boolean to end
    }

    public boolean remove(E element){                                                   //implementing BinTreeInterface
        if (root == null){                                                              //if it's empty
            return false;                                                               //nothing can be removed
        }
        
        BinTreeElement<String> removeElement = new BinTreeElement(element);             //create a BinTreeElement so removeSubNode works
        removeElement.setLabel(element.toString());                                     //set label so removeSubNode works

        if(root.compareTo(removeElement) == 0){                                         //make sure that root isn't the element to remove
            if (root.getLeft() == null){                                                //if the left child is empty
                root = root.getRight();                                                 //move up the right element

            } else if(root.getRight() == null){                                         //if the right child is empty
                root = root.getLeft();                                                  //move up the left element

            }else{                                                                      //if neither one is empty
                BinTreeElement formerRight = root.getRight();                           //save the right child
                root = root.getLeft();                                                  //move up the left element
                addToParent(root, formerRight);                                         //add the right child to the left one(now the root)
            }
            size--;                                                                     //change the size
            return true;                                                                //return a boolean
        }


        if(search(element)){                                                            //if the element to remove is in the tree
            return removeSubNode(root, removeElement);                                  //call removeSubNode to do the real work
        }else{                                                                          //otherwise
            return false;                                                               //say you can't remove the item
        }
    }

    public boolean removeSubNode(BinTreeElement parent, BinTreeElement removeElement){  
        int compareParent = parent.compareTo(removeElement);                            //compare parent element to the element to remove
        BinTreeElement subtree = null;                                                  //subtree will store subtrees in the future
        if (compareParent > 0){                                                         //if the element to remove is on the left
            subtree = parent.getLeft();                                                 //save the left element
        }
        else{                                                                           //if the element to remove is on the right
            subtree = parent.getRight();                                                //save the right element
        }                                                                               //i don't need to check if subtree is null
                                                                                        //because i used search in remove()

        if(subtree.compareTo(removeElement) == 0){                                      //element to remove is FOUND 
            BinTreeElement replacement;                                                 //replacement will be used to move up a child elem
            if (subtree.getLeft() == null){                                             //if removeElement's left child is empty
                replacement = subtree.getRight();                                       //move up the right child
            }
            else if(subtree.getRight() == null){                                        //if removeElement's right child is empty
                replacement = subtree.getLeft();                                        //move up the left child
            }
            else{                                                                       //if neither one is empty
                BinTreeElement formerRight = subtree.getRight();                        //save the right child
                replacement = subtree.getLeft();                                        //move up the left element
                addToParent(replacement, formerRight);                                  //add the right child to the left one
            }

            if(compareParent > 0){                                                      //remember which side the remove element
                parent.setLeft(replacement);                                            //is supposed to go on
            }
            else{                                                                       //i could prolly do this with addToParent
                parent.setRight(replacement);                                           //somehow but i'm lazy
            }

            size--;                                                                     //size has changed
            return true;                                                                //return boolean ending
        }
        return removeSubNode(subtree, removeElement);
    }

    public int size(){                                                                  //getter
        return size;
    }

    public boolean isEmpty(){                                                           //if the tree is empty
        return size == 0 && root == null;
    }
    
    public void clear(){                                                                //make the tree be empty
        root = null;
        size = 0;
    }

    public boolean search(E target){                                                    //this is my laziest implementation function yet
        BinTreeElement<String> temp = new BinTreeElement<>(target.toString());          //create a BinTreeElement so real_search works
        temp.setLabel(target.toString());                                               //set label so real_search works
        return real_search(root, temp);                                                 //call real search
    }

    public boolean real_search(BinTreeElement element, BinTreeElement target){          //takes a starting element and a target element
        if (element == null){                                                           //if the starting element is empy then
            return false;                                                               //it's not going to check an empty element's
        }                                                                               //children

        if (element.compareTo(target) == 0){                                            //if the target element is found
            return true;                                                                //mission accomplished let's go home
        }

        if (real_search(element.getLeft(), target)){                                    //recursively search starting with this
            return true;                                                                //element's left child
        } else {                                                                        //otherwise check the right child
            return real_search(element.getRight(), target);                             //nothing else to check after the right child
        }                                                                               //so this is the final final return
    }

    public String inorder(){                                                            //binTreeInterface implementation
        return inorder_withStart(root);
    }

    public String inorder_withStart(BinTreeElement start){
        if(start == null)                                                               //if the tree is empty no need to 
            return "";                                                                  //do the rest of the function

        String ending = "";                                                             //ending return string

        ending += inorder_withStart(start.getLeft());                                   
        ending += start.getValue() + "  ";                                              //inorder has the root in the middle
        ending += inorder_withStart(start.getRight());

        return ending;                                                                  //return ending return string
    }

    public String postorder(){                                                          //binTreeInterface implementation
        return postorder_withStart(root);
    }

    public String postorder_withStart(BinTreeElement start){
        if(start == null)                                                               //if the tree is empty no need to 
            return "";                                                                  //do the rest of the function

        String ending = "";                                                             //ending return string

        ending += postorder_withStart(start.getLeft());
        ending += postorder_withStart(start.getRight());
        ending += start.getValue() + "  ";                                              //post order has the root post the children

        return ending;
    }

    public String preorder(){                                                           //binTreeInterface implementation
        return preorder_withStart(root);
    }

    public String preorder_withStart(BinTreeElement start){
        if(start == null)                                                               //if the tree is empty no need to 
            return "";                                                                  //do the rest of the function

        String ending = "";                                                             //ending return string

        ending += start.getValue() + "  ";                                              //preorder has the root pre the children
        ending += preorder_withStart(start.getLeft());
        ending += preorder_withStart(start.getRight());

        return ending;
    }


    public int height(){
        return real_height(root) - 1;                                                   //real_height starts at 0 so change the final ans
    }
    public int real_height(BinTreeElement element){
        if(element == null){                                                            //if real_height is called on an empty element
            return 0;                                                                   //don't add to the height because that's not an
        }                                                                               //element
        int leftHeight = real_height(element.getLeft());                                //check if there is a left child
        int rightHeight = real_height(element.getRight());                              //check if there is a right child
        return Math.max(leftHeight, rightHeight) + 1;                                   //return whichever side has the more children
    }

    public boolean isFullBST(){                                                         //THIS is the laziest binTreeInterface implement
        return real_isFullBST(root);
    }
    public boolean real_isFullBST(BinTreeElement element){
        if (element == null){                                                           //pretty much just for if root is empty
            return false;
        }
        if (element.getLeft() == null && element.getRight() == null){                   //if an element is a leaf
            return true;                                                                //it is a part of a full tree
        }
        if (element.getLeft() != null && element.getRight() != null){                   //if the left and right elements aren't empty
            return real_isFullBST(element.getLeft()) && real_isFullBST(element.getRight());//check their children recursively
        }
        return false;                                                                   //if one child is null and the other isn't
    }

    public int getNumberOfLeaves(){
        return real_getNumberOfLeaves(root);                                            //no comment
    }
    public int real_getNumberOfLeaves(BinTreeElement element){
        if (element == null){                                                           //if an element doesn't exist it's not a leaf
            return 0;                                                                   //don't count it
        }
        else if (element.getLeft() == null  &&  element.getRight() == null){            //if both of an element's kids are null
            return 1;                                                                   //then that's what a leaf is so count it
        }
        else{                                                                           //if an element has children
            return real_getNumberOfLeaves(element.getLeft()) + real_getNumberOfLeaves(element.getRight());//go through the children
        }
    }
    public int getNumberOfNonLeaves(){                                                  //an element can or cannot be a leaf
        return size - real_getNumberOfLeaves(root);                                     //so if it's only two options and i'm already
    }                                                                                   //counting one of the options total - leaves = 


    public static void main(String args[]){
        BinSearchTree <String> names = new BinSearchTree<>();

        names.add("Frodo");
        names.add("Dori");
        names.add("Bilbo");
        names.add("Kili");
        names.add("Gandalf");
        names.add("Fili");
        names.add("Thorin");
        names.add("Nori");
        names.add("Daenerys");

        System.out.println(names.postorder());
        System.out.println(names.preorder());
        System.out.println(names.inorder());

        Bridges bridges = new Bridges(0, "sam_tlor", "1134158751539");                  //login to API
        bridges.setTitle("CMSC 256 project 5 Sam Taylor");
        bridges.setDataStructure(names.root);

        try{
            bridges.visualize();
        }catch(Exception e){
            System.out.println("didn't work");
        }
    }
}