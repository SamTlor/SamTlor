/*
 * FoodConsumer.java
 * 
 * This program calls FoodBank's takeFood function and then sleeps for 100 milliseconds as 
 * described in the instructions
 * 
 * Sam Taylor
 * 12/19/22
 * CMSC 403
 * 
 */


package ProducerConsumer;
import java.util.Random;


public class FoodConsumer extends Thread{
    //instance vars have to be private
    private FoodBank bank;

    //default constructor
    public FoodConsumer(FoodBank newBank){
        bank = newBank;
    }

    //override run
    @Override
    public void run(){
        System.out.println("Starting Consumer thread");
        //import random
        Random rand = new Random();
        //loop infinitely
        while(true){
            //sleep throws InterruptedException so it has to be in try
            try{
                bank.takeFood(rand.nextInt(100));
                sleep(100);
            } catch(InterruptedException ex){}
        }
    }
}