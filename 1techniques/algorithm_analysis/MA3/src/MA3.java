import java.io.File;
import java.util.Scanner;

public class MA3 {
    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);



        int total = scan.nextInt();
        int m = scan.nextInt();



        //locations for points to cut
        // + 2 for point 0 and point total
        int[] locs = new int[m + 2];
        locs[0] = 0;
        for (int i = 1; i <= m; i++){
            locs[i] = scan.nextInt();
        }
        locs[m+1] = total;
        //0 and the length of the original rod are added because those are technically cut points as well

        scan.close();


        
        //matrix is going to hold the results of all the other subrods potentials
        int[][] matrix = new int[m + 2][m + 2];

        
        for (int i = m + 1; i >= 0; --i){
            for(int j = i + 1; j < m + 2; ++j){
                for(int k = i + 1; k < j; ++k){
                    //if the pairing of these two cuts is impossible 
                    //set it to max value
                    if (matrix[i][j] == 0){
                        System.out.print(i + "\t");
                        System.out.println(j);
                        matrix[i][j] = Integer.MAX_VALUE;
                    }
                    
                    //current fastest connection or
                    //bottom up: right side of the rod minus left side of the rod
                    //           plus the results of the subrods that are created
                    //           by cutting at i and j
                    matrix[i][j] = Math.min(matrix[i][j], locs[j] - locs[i] + matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int a = 0; a < m+2; a++){
            for (int b = 0; b < m+2; b++){
                System.out.print(matrix[a][b] + "\t");
            }
            System.out.println();
        }

        System.out.println(matrix[0][m + 1]);
    }
}