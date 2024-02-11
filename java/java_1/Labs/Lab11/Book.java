/*
 *
 * Fan.java
 *
 * this program creates a class with instance variables, no-arg and parameterized constructors,
 * getter and setter methods, and a method to return a description of the class
 *
 * Sam Taylor
 * 4/7/2021
 * CMSC 255
 *
 */

package Labs.Lab11;

public class Book {
    private String title;                                       //private instance variables
    private String author;

    public Book(){                                                     //no arg constructor
        title = "Test";                                         //null wrote a really good book called "Test"
        author = null;
    }
    public Book(String theTitle, String theAuthor){                    //theAuthor wrote a really good book called theTitle
        title = theTitle;
        author = theAuthor;
    }
                                                                //getters
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
                                                                //setters
    public void setTitle(String theTitle){
        title = theTitle;
    }
    public void setAuthor(String theAuthor){
        author = theAuthor;
    }
                                                                //use \ to escape quotation marks
    public String toString(){
        return ("\"" + title + "\"" + " by " + author);
    }
}