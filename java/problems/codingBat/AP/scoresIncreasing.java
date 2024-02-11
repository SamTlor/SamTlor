public class  scoresIncreasing {
    public static void main(String[] args) {

        int[] first = {1,3,4};
        int[] second = {1,3,2};
        int[] third = {1,1,4};

        System.out.println(scoresIncreasing(first));
        System.out.println(scoresIncreasing(second));
        System.out.println(scoresIncreasing(third));
    }

    public static boolean scoresIncreasing(int[] scores){
        int old = scores[0];                                    //the first digit in the array

        for (int i = 1; i < scores.length; i++){
            if (scores[i] < old){                               //if the member of the array is less than the one that came before
                return false;                                   //the array doesn't increase
            }   
            old = scores[i];                                    //set old to be the the member of the array
        }
        return true;                                            //if true hasn't been returned yet
    }
}