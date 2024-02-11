package cmsc256;

import java.util.*;
import bridges.base.SLelement;
import bridges.connect.Bridges;

public class CustomStack<E> implements StackInterface<E> {

    private SLelement<E> top;
    private int size;

    public CustomStack(){                                       //constructors
        top = null;
        size = 0;
    }
    public CustomStack(int theSize){
        top = null;
        size = theSize;
    }

    public void push(E newEntry){                               //stack methods
        if (newEntry != null){
            top = new SLelement<E>(newEntry, top);
            size++;

            top.setLabel(newEntry.toString());
            top.setColor("darkkhaki");
            top.setShape("wye");
        }
    }

    public E pop(){                                         
        if (top == null){
            throw new EmptyStackException();
        }
        E it = top.getValue();
        top = top.getNext();
        size--;
        return it;
    }

    public E peek(){                                        
        if (isEmpty()){                                     //if empty
            throw new EmptyStackException();                //throw exception
        }
        return top.getValue();                              //if it's not empty get value
    }

    public boolean isEmpty(){                               //if the first space is waiting for something to be pushed
        if (size == 0){
            return true;                                    //then it's empty
        }
        return false;
    }

    public void clear(){                                    //tell it to start at the beginning
        top = null;
        size = 0;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            SLelement<E> current = top;                                     //so that we can increment without changing top
            StringBuffer output = new StringBuffer();      
            output.append("Top of stack: " + current.getValue() + "\n");

            while(current.getNext() != null) {
                current = current.getNext();                                //see? no changing top
                if(current.getNext() == null){
                    output.append("Stack bottom: ");
                } 
                else {
                    output.append("              ");
                }
                output.append(current.getValue() + "\n");
            }
            System.out.println(output.toString());
        }
    }

    public static boolean isBalanced(String expression){
        CustomStack theStack = new CustomStack<>();
        char[] starting = {'[', '{', '('};                                      //the limeters
        char[] ending = {']', '}', ')'};                                        //nothing else needs to change if you want to add <>

        char[] substring = expression.toCharArray();
        for (char letter : substring){                                          //for every character in the expression. called "letter"
            for(int i = 0; i < starting.length; i++){                           //for every delimeter in starting:    '[', '{', '('
                if(letter == starting[i]){                                      //if letter is the same as a delimeter
                    theStack.push(letter);                                      //add to the stack
                    continue;                                                   //skip to the next letter. doesn't need to check ending
                }
                if(letter == ending[i]){                                        //if letter is the same as a closing delimeter
                    try{
                        char var = String.valueOf(theStack.peek()).charAt(0);   //var = the last letter that was put on the stack
                        if (var == starting[i]){                                //if the delim just found matches the last one put on
                            theStack.pop();                                     //they're a pair. don't need to think about them anymore
                            break;
                        }
                        else {                                                  //if they're not a pair then it's not balanced
                            return false;                                       //cuz its something like [}
                        }
                    } catch(EmptyStackException e){
                        return false;
                    }
                }
            }
        }
        return theStack.isEmpty();
    }

    public static void main(String[] args){

        CustomStack showOffStack = new CustomStack<>();

        System.out.println("Pushed 256, 10, 18, 20, and 2018:\n");
        showOffStack.push(256);
        showOffStack.push(10);
        showOffStack.push(18);
        showOffStack.push(20);
        showOffStack.push(2018);
        showOffStack.display();

        Bridges bridges = new Bridges(0, "sam_tlor", "1134158751539");      //login to API
        bridges.setTitle("CMSC 256 Project 2 Sam Taylor");
        bridges.setDescription("wye with dark kahki undertones");
        bridges.setDataStructure(showOffStack.top);
        try{
            bridges.visualize();
        }catch(Exception e){
            System.out.println("thing didn't work");
        }

        System.out.println("called pop twice:");
        showOffStack.pop();
        showOffStack.pop();
        showOffStack.display();
        System.out.println("a call to peek returns " + showOffStack.peek() + "\n");
        System.out.println("called pop three times:");
        showOffStack.pop();
        showOffStack.pop();
        showOffStack.pop();
        showOffStack.display();
    }
}