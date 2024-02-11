package maxarea;

class Solution {
    public int maxArea(int[] height) {

        int base, tall, max, area;
        base = tall = max = area = 0;

        int theStart, end;
        for ( theStart = 0, end = height.length - 1; theStart < end; ) {
            base = end - theStart;

            if (height[theStart] > height[end]){
                tall = height[end];
                end--;
            } else {
                tall = height[theStart];
                theStart++;
            }

            area = base * tall;

            if (area > max) {
                max = area;
            }
        } 
        
        
        return max;
    }
}




public class Main {
    public static void main(String[] args) {


        Solution test1 = new Solution();
        System.out.println(test1.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}