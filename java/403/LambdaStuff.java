import javax.swing.JButton;

/*
 * Java has no way to pass a function or function definition to an object 
 * and have the object execute the given function 
 * 
 * sometimes a class needs to only exist once in a program
 * if for example when 
 *      JButton is pressed 
 *      it calls the method actionPerformed
 *      which calls all attached actionListener objects
 * 
 * what if there are multiple JButtons? do we have to have multiple classes and multiple files
 * NO
 * TOO much work so we have ANONYMOUS INNER CLASSES
 * 
 * 
 * 
 * ANONYMOUS INNER CLASS: a class without a name for which only a single object is created
 * 
 * 
 * 
 * 
 * JButton testButton = new JButton("Test Button");
    testButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Click by Anon class");
        }

    });
 * 
 * 
 * 
 * still very verbose so now we have LAMBDA
 * lambda has three parts:
 *      argument list
 *      arrow
 *      body
 * 
 *                 \/ arrow
 *  (int x, int y) -> x + y
 *   ^ argument list  ^token body
 * 
 * 
 * LAMBDA EXPRESSIONS: anonymous methods that implement an anonymous object which implements a 
 *                      functional interface
 * 
 * FUNCTIONAL INTERFACE: an interface with a single abstract method
 * 
 * 
 * doesn't do functions as data but uses infrences to do pretty much the same thing
 */

public class LambdaStuff{
    public static void main(String[] args) {
        //anonymous inner class version
        Runnable r1 = new Runnable(){                               //Runnable is the class w/o name
            @Override                                               //r1 is the object created
            public void run(){                                      //single abstract method
                System.out.println("Hello world one!");
            }
        };


        //runnable is an anonymous object with one anonymous method, run
        //that's why it doesn't have to be defined in r2. it's just a part of the Runnable class
        Runnable r2 = () -> System.out.println("Hello world two!"); //lambda version

        r1.run();
        r2.run();
    }   
}

/*
 * 
 * Definitions:
 *
 * ANONYMOUS INNER CLASS: a class without a name for which only a single object is created
 * LAMBDA EXPRESSIONS: anonymous methods that implement an anonymous object which implements a 
 *                      functional interface
 * FUNCTIONAL INTERFACE: an interface with a single abstract method
 * 
 * 
 * 
 * 
 * 
 * also btw lamda can't replace anon inner class 100% of the time because they can only override
 * one method NOT MULTIPLE
 * 
 */