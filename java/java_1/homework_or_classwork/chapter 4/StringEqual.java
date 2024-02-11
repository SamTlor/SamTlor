/* 
* StringEqual.java
* 
* tests to see if a string is equal to another string after the first string has been concatonated
* 
* Sam Taylor
* 2/24/21
* CMSC 255
*/

public class StringEqual {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abcdefg";
        String str3 = str1 + "efg";

        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);

        // but if it results in a 0 they're the same
        if (str2.compareTo(str3) == 0){
            System.out.println("The strings st2 and str3 are the same");
        } else {
            System.out.println("The strings str2 and str3 are not the same");
        }
    }
}