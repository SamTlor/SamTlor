package Labs.Lab11;

public class Lab11 {
    public static void main(String[] args){
        Book b1 = new Book();
        Book b2 = new Book("My delusional art piece", "Rolyat Leumas");
        Book b3 = new Book("My masterpiece", "SAm taylor");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString() + "\n");

        Bookshelf vase = new Bookshelf(3);
        vase.addBook(b1);
        vase.addBook(b2);
        vase.addBook(b3);

        for(Book i : vase.getBooks()){
            System.out.println(i.toString());
        }

        vase.emptyBookshelf();
        for(Book i : vase.getBooks()){
            System.out.println(i.toString());
        }
    }
}
