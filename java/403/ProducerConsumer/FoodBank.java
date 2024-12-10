/*
 * FoodBank.java
 * 
 * This is the class that FoodProducer and FoodConsumer use to instantiate their bank object.
 * it has an instance variable called food that is incremented by giveFood and decremented by
 * takeFood. if there isn't any food to be taken the takeFood function will wait until it is 
 * notified by the giveFood function.
 * 
 * Sam Taylor
 * 12/19/22
 * CMSC 403
 * 
 */

 package ProducerConsumer;

public class FoodBank {
    //private instance var
    private int food;

    //public default constructor
    public FoodBank(){
        food = 0;
    }

    //doesn't need to wait() for anything because there's no restrictions on adding food
    //only notify takeFood if takeFood needs to be notified
    synchronized public void giveFood(int x){
        food += x;
        System.out.println("The balance is now " + food);
        notify();
    }


    synchronized public void takeFood(int x){
        //if there's enough food then food gets taken. no muss no fuss
        if((food - x) > 0){
            System.out.println("Taking " + x + " items of food");
            food -= x;
        } else{
            System.out.println("Waiting to get food");
            //wait until giveFood sends notify() so that takeFood can try again
            try{
                wait();
            } catch(InterruptedException ex){}
        }
    }
}