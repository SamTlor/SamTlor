//MILLISECOND VERSION

public class AlgorithmAnalysisPractice {
    public static void main(String[] args) {

        int n = 5;

        long startTime = System.nanoTime();
        // Fragment 1
        for (int i = 0; i < n; i++){
            try{
                Thread.sleep(1);
            } catch(Exception e){
                System.out.println(e);
            }
        }
        long endTime = System.nanoTime();
        long diff =  endTime - startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");



        startTime = System.nanoTime();
        // Fragment 2
        for (int i = 0; i < n; i += 2){
            try{
                Thread.sleep(1);
            } catch(Exception e){
                System.out.println(e);
            }
        }

        startTime = System.nanoTime();
        // Fragment 3
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                try{
                Thread.sleep(1);
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        endTime = System.nanoTime();
        diff =  endTime -  startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");

        startTime = System.nanoTime();
        // Fragment 4
        for (int i = 0; i < n; i++)
            try{
                Thread.sleep(1);
            } catch(Exception e){
                System.out.println(e);
            }
        for (int j = 0; j < n; j++)
            try{
                Thread.sleep(1);
            } catch(Exception e){
                System.out.println(e);
            }
        endTime = System.nanoTime();
        diff =  endTime -  startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");

        
        startTime = System.nanoTime();
        // Fragment 5
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n * n; j++){
                try{
                    Thread.sleep(1);
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        endTime = System.nanoTime();
        diff =  endTime -  startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");

        startTime = System.nanoTime();
        // Fragment 6
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                try{
                    Thread.sleep(1);
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        endTime = System.nanoTime();
        diff =  endTime -  startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");

        startTime = System.nanoTime();
        // Fragment 7
        for (int i = 1; i < n; i = i * 2){
            try{
                Thread.sleep(1);
            } catch(Exception e){
                System.out.println(e);
            }
        }

        endTime = System.nanoTime();
        diff =  endTime -  startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");
        
        startTime = System.nanoTime();
        // Fragment 8
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n * n; j++){
                for (int k = 0; k < j; k++){
                    try{
                        Thread.sleep(1);
                    } catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }

        endTime = System.nanoTime();
        diff =  endTime -  startTime;

        System.out.println("Time to compute Fragment was " + diff + " milliseconds.");
    }
}