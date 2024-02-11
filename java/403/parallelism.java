/*
 * concurrent programming: when several computations are running at the same time
 *                          and maybe interacting with each other. does the program have the 
 *                          capability of parallelism
 * parallel computing: when many calculations are executed simultaneously. problems can be divided 
 *                      into many smaller chunks. actually running seperate chunks at the same time.
 *                      the act of exploiting concurrency
 * 
 * 
 * concurrency is about structure parallelism is about execution
 * 
 * processes generally have a private collection of run-time resources and memory space
 * a PROGRAM is a PROCESS that has a single THREAD which executes code statements
 *      but it can have multiple threads
 * 
 * 
 * hardware parallelism: executes simultaneously on the hardware
 * software parallelism: hardware may be executing computations simultaneously or small amounts of
 *                          each computation at a time while switching between computations
 * 
 * 
 * All java programs are run on the main thread which is initialized and run by the JVM
 * for the programmer to create a thread instantiate a Thread object and defining a run method
 * do this by:
 *      extend Thread through inheritance and override the empty Thread.run mehtod
 *      instantiate an object of a class that implements the Runnable interface and pass 
 *          it to the thread constructor
 * 
 * 
 * 
 * THREAD METHODS:
 * start: begins running the thread and calls the run method
 * join: makes a thread wait for another thread to finish before continuing
 * interrupt: sets an internal flag in the thread that recieved the interrupt
 *              allows a thread to do some cleanup before exiting
 *              if the target thread never checks it tho the interrupt has no effect
 * 
 * 
 * 
 * stop and suspend have been deprecated because they're inherently unsafe
 *      killing a thread might delete all of its resources that other threads need
 */

import java.util.*;
import java.util.stream.Collectors;

public class parallelism {
    public static void main(String[] args) throws InterruptedException {
        /*                                                      //classic thread example
        Thread myThread = new Thread(() -> {
            try{
                while(true) {
                    System.out.println("Task 1 is running");
                    Thread.sleep(200);
                }
            } catch(InterruptedException ex) {}
        });
        */

        //creates thread and runs the method
        Thread taskThread = new Thread(taskThatFinishesEarlyOnInterruption());

        //starts the thread
        taskThread.start();

        //does other stuff while the thread is running
        Thread.sleep(1000);

        //asks the thread to stop because the other stuff is done
        taskThread.interrupt();

        //waits for the thread to stop
        taskThread.join();

        //now the thread has stopped
        System.out.println();
        System.out.println("Program over");
    }

    private static Runnable taskThatFinishesEarlyOnInterruption() {
        return () -> {
            int i = 0;
            while (true) {
                System.out.println(i +  " ");     
                i++;
                if(Thread.currentThread().isInterrupted()){
                    break;
                }            
            }
        };
    }
}