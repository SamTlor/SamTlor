import java.util.Arrays;

public class GenericDemo {
	public static void main(String[] args) {
		int[] numArray = {2020, 42, 7, 99, 1, 11, 3, 46};               		            // original array of integers
		// write a method to reverse the elements in this array, call it,
		// and display the results
		int[] numArrayReversed = reverseNumArray(numArray);
        System.out.println(Arrays.toString(numArrayReversed));


		String[] strArray = {"apples", "tomatoes", "bananas", "guavas", "pineapples"};		// original String array
		// write a method to reverse the elements in this array, call it,
		// and display the results
		String[] strArrayReversed = reverseStringArray(strArray);
        System.out.println(Arrays.toString(strArrayReversed));


		// reversing with generic method requires Integer[]
		Integer[] numArrayIntegers =  {2020, 42, 7, 99, 1, 11, 3, 46};
		Object[] genericNumReversal = reverseArrayGeneric(numArrayIntegers);
        System.out.println(Arrays.toString(genericNumReversal));

		// reversing with generic method
		Object[] genericStringReversal = reverseArrayGeneric(strArray);
        System.out.println(Arrays.toString(genericStringReversal));

	}

	private static int[] reverseNumArray(int[] numArray) {
        int[] reversed = new int[numArray.length];
        int j = numArray.length - 1;

        for (int i = 0; i < numArray.length; i++){
            reversed[j--] = numArray[i];
        }
        return reversed;
	}

	private static String[] reverseStringArray(String[] strArray) {
        String[] reversed = new String[strArray.length];
        int j = strArray.length - 1;

        for (int i = 0; i < strArray.length; i++){
            reversed[j--] = strArray[i];
        }
        return reversed;
	}

	// write a generic method to reverse an array, then refactor the main method to call this method
    private static <T> T[] reverseArrayGeneric(T[] genArr){
        //CAN'T MAKE A NEW GENERIC ARRAY
        // so we make an Object Array--------------------------------------------
        // and turn that into a generic Array									|
		//				\/														|
        T[] reversal = (T[]) new Object[genArr.length];//						|
		//				          /\											|
		//						   |--------------------------------------------
        int j = genArr.length - 1;

        for (int i = 0; i < genArr.length; i++){
            reversal[j--] = genArr[i];
        }
        return reversal;
    }



	/****************************************************************
	 *	linearSearch - finds position of an element in an array
	 *
	 *	usage - linear_search(array, key)
	 *
	 *	parameters -
	 *	array  	the array we're searching
	 *  key  	the integer we're searching for
	 *
	 *	result -
	 *	if the key is found, returns the position in the array of
	 *	that key. Otherwise, -1 is returned
	 *
	 **************************************************************/
	public static int linearSearch(int[] list, int key) {
		for (int i = 0; i < list.length; i++)
			if (key == list[i])
				return i;
		return -1;
	}

	// convert the linear search method into a generic method.
    public static <T> int linearSearchGeneric(T[] list, T key){
        for (int i = 0; i < list.length; i++){
            return i;
        }
        return -1;
    }

}
