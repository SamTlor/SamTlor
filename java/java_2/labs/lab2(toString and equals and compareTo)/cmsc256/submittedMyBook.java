package cmsc256;
// replace the type parameter, T with the class name, MyBook
public class submittedMyBook implements Comparable<MyBook> {
   private String title, authorFirstName, authorLastName, ISBN10, ISBN13;
   // default constructor
   public submittedMyBook() {
      title = "None Given";
      authorFirstName = "None Given";
      authorLastName = "None Given";

      ISBN10 = "0000000000";
      ISBN13 = "0000000000000";
   }
   
   //Getters
   public String getTitle() {
      return title;
   }
   public String getAuthorFirstName() {
      return authorFirstName;
   }
   public String getAuthorLastName() {
      return authorLastName;
   }
   public String getISBN10() {
      return ISBN10;
   }
   public String getISBN13() {
      return ISBN13;
   }



   //Setters
   public void setTitle(String title){
      if (title == null) {
         throw new IllegalArgumentException("The title can not be null");
      }
      this.title = title;
   }
   public void setAuthorFirstName(String authorFirstName){
      if (authorFirstName == null) {
         throw new IllegalArgumentException("The author's first name can not be null");
      }
      this.authorFirstName = authorFirstName;
   }
   public void setAuthorLastName(String authorLastName){
      if (authorLastName == null) {
         throw new IllegalArgumentException("The author's last name can not be null");
      }
      this.authorLastName = authorLastName;
   }
   public void setISBN10(String ISBN10){
      if (ISBN10 == null) {
         throw new IllegalArgumentException("ISBN cannot be null.");
      }
      if (ISBN10.length() != 10) {
         throw new IllegalArgumentException("The ISBN10 must have 10 digits.");
      }

      for (int i = 0; i < ISBN10.length(); i++){
         char ch = ISBN10.charAt(i);
         if (!Character.isDigit(ch))
            throw new IllegalArgumentException("The ISBN10 must have all digits");
      }
      this.ISBN10 = ISBN10;
   }
   public void setISBN13(String ISBN13){
      if (ISBN13 == null) {
         throw new IllegalArgumentException("ISBN cannot be null.");
      }
      if (ISBN13.length() != 13) {
         throw new IllegalArgumentException("The ISBN13 must have 13 digits.");
      }

      for (int i = 0; i < ISBN13.length(); i++){
         char ch = ISBN13.charAt(i);
         if (!Character.isDigit(ch))
            throw new IllegalArgumentException("The ISBN13 must have all digits");
      }
      this.ISBN13 = ISBN13;
   }

   // parameterized overloaded constructor

   public submittedMyBook(String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13) {
      setTitle(title);
      setAuthorFirstName(authorFirstName);
      setAuthorLastName(authorLastName);
      setISBN10(ISBN10);
      setISBN13(ISBN13);
   }

   // toString() method
   public String toString() {
      return "Title: " + getTitle() + "\nAuthor: " + getAuthorFirstName() + " " + getAuthorLastName() + "\nISBN10: " + getISBN10() + "\nISBN13: " + getISBN13(); 
   }

   public boolean equals(Object obj) {
    // are the variables referencing the same object?
     if(this == obj){
         return true;
     }

    // is the parameter a MyBook object?
     if(obj == null || !(obj instanceof MyBook)){
         return false;
     }
     MyBook otherBook = (MyBook) obj;
     if (!ISBN10.equals(otherBook.getISBN10())) {
          return false;
     }

     if (!ISBN13.equals(otherBook.getISBN13())){
          return false;
     }
    return true;
   }


   @Override
   public int compareTo(MyBook other) {
      int result = getAuthorLastName().compareTo(other.getAuthorLastName());
      if (result == 0) {
         result = getAuthorFirstName().compareTo(other.getAuthorFirstName());
      }

      if (result == 0) {
         result = getTitle().compareTo(other.getTitle());
      }
      return result;

   }




    public static void main(String[] args){
        submittedMyBook infinite = new submittedMyBook();
        System.out.println(infinite);
    }

}