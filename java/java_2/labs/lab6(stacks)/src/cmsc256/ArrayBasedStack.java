package cmsc256;

import java.util.*;

public class  ArrayBasedStack<T> implements StackInterface<T> {

    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;  

    public ArrayBasedStack(int userDefinedInitialCapacity){
        if (userDefinedInitialCapacity <= 0){
            throw new IllegalArgumentException("Array initial size error.");
        }
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[userDefinedInitialCapacity]; 
        data = tempStack;
        topOfStack = -1;
    }

    public ArrayBasedStack(){
        clear();
    }


    private void expandArray(){
        data = Arrays.copyOf(data, data.length * 2);
    }

    private boolean isArrayFull(){
        if (topOfStack >= data.length){
            return true;
        }
        return false;
    }

    


    //stack interface implementations
    // Adds a new entry to the top of this stack.
    public void push(T newEntry){
        topOfStack += 1;
        if(topOfStack == data.length){
            expandArray();
        }
        data[topOfStack] = newEntry;
    }
    
    /** Removes and returns this stack's top entry.
         @return  The object at the top of the stack. 
        @throws  EmptyStackException if the stack is empty before the operation. */
    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T temp = data[topOfStack];
        data[topOfStack] = null;
        topOfStack--;
        return temp;

    }
    
    /** Retrieves this stack's top entry.
         @return  The object at the top of the stack.
        @throws  EmptyStackException if the stack is empty. */
    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        } 
        return data[topOfStack];
    }
    
    /** Detects whether this stack is empty.
        @return  True if the stack is empty. */
    // returns true if there are no elements in the stack and false otherwise. 
    //that returns true if the topOfStack exceeds the largest index value in the array 
    public boolean isEmpty(){
        if (topOfStack < 0){
            return true;
        }
        return false;
    }
    
    /** Removes all entries from this stack. */
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
        data = tempStack;
        topOfStack = -1;
   }
}
