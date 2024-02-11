/*
 *
 * Fan.java
 *
 * this program creates a class with instance variables(one of them being an ArrayList of Book objects
 * from Book.java), no-arg and parameterized constructors, getter methods, a method to add to the ArrayList,
 * a method to remove the first item of the ArrayList and a method to remove all items from the ArrayList
 *
 * Sam Taylor
 * 4/7/2021
 * CMSC 255
 *
 */

package Labs.Lab11;

import java.util.ArrayList;                                             //so that i can use ArrayLists

public class Bookshelf {
    private int size;                                                   //private instance variables
    private ArrayList<Book> books = new ArrayList<Book>();              //ArrayList<type> = new ArrayList<type>

    public Bookshelf(){                                                        //no arg constructor
        size = 2;                                                       //books is already initialized by the class
    }
    public Bookshelf(int theSize){                                             //arg constructor
        size = theSize;
    }
                                                                        //getters
    public int getSize(){
        return size;
    }
    public ArrayList<Book> getBooks(){
        return books;
    }

    public void addBook(Book theBook){
        if(books.size() < size) {       //if the length of the books ArrayList is less than the size instance variable
            books.add(theBook);         //add the book to books
        }
    }
    public Book removeBook(){
        if (books.size() == 0){                     //as long as the bookshelf is not empty
            return null;
        } else {
            Book temp = books.get(0);               //set a temp variable to save the return value
            books.remove(0);                  //remove the first element of books
            return temp;                            //return the temp because the first element doesn't exist anymore
        }
    }
    public void emptyBookshelf(){                   //see title of method for description of what this method does
        books.clear();
    }
}
