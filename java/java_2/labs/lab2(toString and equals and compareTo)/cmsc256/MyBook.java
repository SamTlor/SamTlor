package cmsc256;
public class MyBook implements Comparable<MyBook> {

    //instance variables
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String ISBN10;
    private String ISBN13;


    //default constructor
    public MyBook(){
        title = "None Given";
        authorFirstName = "None Given";
        authorLastName = "None Given";
        ISBN10 = "0000000000";
        ISBN13 = "0000000000000";
    }

    //getters
    public String getTitle(){
        return this.title;
    }
    public String getAuthorFirstName(){
        return this.authorFirstName;
    }
    public String getAuthorLastName(){
        return this.authorLastName;
    }
    public String getISBN10(){
        return this.ISBN10;
    }
    public String getISBN13(){
        return this.ISBN13;
    }

    //setters
    public void setTitle(String newTitle){
        if (newTitle == null){
            throw new IllegalArgumentException("No nulls");
        }
        this.title = newTitle;
    }
    public void setAuthorFirstName(String newAuthorFirstName){
        if (newAuthorFirstName == null){
            throw new IllegalArgumentException("No nulls");
        }
        this.authorFirstName = newAuthorFirstName;
    }
    public void setAuthorLastName(String newAuthorLastName){
        if (newAuthorLastName == null){
            throw new IllegalArgumentException("No nulls");
        }
        this.authorLastName = newAuthorLastName;
    }
    public void setISBN10(String newISBN10){
        check_if_digits(newISBN10, 10);

        this.ISBN10 = newISBN10;
    }
    public void setISBN13(String newISBN13){
        check_if_digits(newISBN13, 13);
        
        this.ISBN10 = newISBN13;
    }

    //validates the isbn setters
    public void check_if_digits(String numbers, int howLong){ 
        if (numbers == null){
            throw new IllegalArgumentException("No nulls");
        }
        if (numbers.length() != howLong){
            throw new IllegalArgumentException("has to be 10 characters");
        }

        for (int i = 0; i < numbers.length(); i++){
            char ch = numbers.charAt(i);
            if (!Character.isDigit(ch)){
                throw new IllegalArgumentException("Must be all digits");
            }
        }
    }
    
    //parameterized constructor
    public MyBook(String Title, String AuthorFirstName, String AuthorLastName, String ISBN10, String ISBN13){
        setTitle(Title);
        setAuthorFirstName(AuthorFirstName);
        setAuthorLastName(AuthorLastName);
        setISBN10(ISBN10);
        setISBN13(ISBN13);
    }

    public String toString(){
        return "Title: " + getTitle() + " \nAuthor: " + getAuthorFirstName() + " " + getAuthorLastName() + "\nISBN10:" + getISBN10() + "\nISBN13:" + getISBN13();
    } 

    public boolean equals(Object otherBook){
        //if this is being compared to itself
        if (this == otherBook){
            return true;
        }

        //if this is null or the other object isn't the same type of object as this
        if (otherBook == null || !(otherBook instanceof MyBook) ){
            return false;
        }
        
        //
        MyBook other = (MyBook) otherBook;
        if (!ISBN10.equals(other.getISBN10())){
            return false;
        }
        if (!ISBN13.equals(other.getISBN13())){
            return false;
        }
        return true;
    }


    @Override
    public int compareTo(MyBook other){
        int result = ( this.getAuthorLastName() ).compareTo( other.getAuthorLastName() );

        if (result == 0){
            result = ( this.getAuthorFirstName() ).compareTo( other.getAuthorFirstName() );
        }
        if (result == 0){
            result = ( this.getTitle() ).compareTo( other.getTitle() );
        }

        return result;
    }


    public static void main(String[] args){
        MyBook infinite = new MyBook();
        System.out.println(infinite);
    }

}