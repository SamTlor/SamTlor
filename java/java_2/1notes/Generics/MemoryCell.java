// MemoryCell class
//  Object read( )         -->  Returns the stored value
//  void write( Object x ) -->  x is stored
public class MemoryCell{
    // Private internal data representation
       private Object storedValue;
   
       public void write (Object obj){
           storedValue = obj;
       }
   
       public Object read (){
           return storedValue;
       }
   
       public static void main(String[] args){
           MemoryCell mem = new MemoryCell();
           mem.write("42");
           String val = (String)mem.read();
           System.out.println("Contentes are: " + val);
           
           try{
            mem.write(42);
            String val2 = (String)mem.read();
            System.out.println("Contentes are: " + val2);
           } catch(ClassCastException a){
               System.out.println("String cast to an integer not an object");
           }
       }
   }