/*
 * FoodBankPatrons.java
 * 
 * This program calls FoodBank's giveFood function and then sleeps for 100 milliseconds as 
 * described in the instructions
 * 
 * Sam Taylor
 * 12/19/22
 * CMSC 403
 * 
 */

 package ProducerConsumer;
import java.util.Random;

//extend Thread
public class FoodProducer extends Thread{
    //instance vars have to be private
    private FoodBank bank;

    //default constructor
    public FoodProducer(FoodBank newBank){
        bank = newBank;
    }

    //override run
    @Override
    public void run(){
        System.out.println("Starting Producer thread");
        //import random
        Random rand = new Random();
        //loop infinitely
        while(true){
            //sleep throws InterruptedException so it has to be in try
            try{
                bank.giveFood(rand.nextInt(100));
                sleep(100);
            } catch(InterruptedException ex){}
        } 
    }
}