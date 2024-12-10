/*
 * FoodBankPatrons.java
 * 
 * This program creates and starts 2 Thread classes using FoodProducer and FoodConsumer which
 * both use a FoodBank class object to instantiate themselves. It then runs the two threads
 * 
 * 
 * Sam Taylor
 * 12/19/22
 * CMSC 403
 * 
 */

 package ProducerConsumer;


public class FoodBankPatrons{
    public static void main(String[] args){
        FoodBank theBank = new FoodBank();

        Thread producer = new FoodProducer(theBank);
        Thread consumer = new FoodConsumer(theBank);

        producer.start();
        consumer.start();
    }

}