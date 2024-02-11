/*
 * RACE CONDITIONS: when a program's execution path depends on arbitrary execution timing of threads
 *                  when two threads are started at about the same time. whichever finishes first
 *                  affects the program's outcome
 * 
 * CRITICAL SECTION: a region of code that can only be executed by one thread at a time
 *                      what if one thread changes it to be a certain value because it reads a num
 *                      and then another thread changes it to be a different value because it read
 *                      the same number
 * MUTUAL EXCLUSION: enforcing critical section. making sure that there is only one thread at a
 *                      time accessing a critical section
 * deadlock: a state where each thread is waiting for another thread and nothing happens forever.
 *              it's impossible to tell the difference between a deadlock state and a program taking
 *              a long time to run. YOU have to be responsible for avoiding deadlock
 * 
 * semaphores can be used to provide mutual exclusion and avoid deadlock
 * semaphores only have acquire and release
 * 
 * 
 * 
 * MONITOR: all java objects have one
 * objects that use the monitor are called synchronized objects
 * 
 * objects can be resposible for themselves when multiple threads call them
 * to say that only certain parts of the object can be used at a time
 * 
 * monitors have an associated wait cue to be able to use its operations
 * condition variables: shared variables within the monitor 
 *                      each one has a queue of processes waiting for the conditions
 *                      each one has associated SUSPEND and CONTINUE operations
 * 
 * there's no order which will go first unless you set the order
 * any unsynchronized methods may be executed without acquiring the lock or going thru the queue
 * 
 * WAIT and SLEEP are suspend operations
 * NOTIFY and NOTIFYALL are continue operations
 * 
 */


class WaitingSender{
    String message;

    synchronized public void send(String msg){
        if(message != null){
            try{
                wait();
            } catch(InterruptedException ex){}
        }

        System.out.println("Sending " + msg);
        message = msg;
    }

    synchronized public void receive(){
        System.out.println(message);
        message = null;
        notify();
    }
}


class WaitingMessageThread extends Thread{
    private WaitingSender sender;
    private String message;
    public WaitingMessageThread(WaitingSender aSender, String aMessage){
        sender = aSender;
        message = aMessage;
    }
    @Override
    public void run(){
        try{
            sender.send(message);
            sleep(1000);
            sender.receive();
        } catch(InterruptedException ex){}
    }
}


public class definitions_stuff {
    public static void main(String[] args){
        WaitingSender mySender = new WaitingSender();
        Thread oneMessage = new WaitingMessageThread(mySender, "Jello");
        Thread twoMessage = new WaitingMessageThread(mySender, "World");

        oneMessage.start();
        twoMessage.start();
    }
    
}

/*
 * JAVA REFLECTION
 * allows programmers to examine and modify the runtime behavior of a program running on vm
 * advantages:
 *      allows programmers to be more dynamic
 *      allows for objects to be modified at runtime regardless of access modifiers
 * 
 * disadvantages:
 *      subverts static typing
 *      makes programs radically unsafe
 */