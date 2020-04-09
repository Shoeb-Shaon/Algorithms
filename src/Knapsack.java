
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author SHoeb_Shaon
 */
public class Knapsack {

    public static int value[] = new int[5];
    public static int weight[] = new int[5];
    public static int bagWeight = 7;
    public static String items[] = {"Laptop", "Phone", "Speaker","Necklace","Watch"};

    public static void main(String[] args){

        File file = new File ("Add your input file directory.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }

        int i = 0;
        while(sc.hasNextInt()){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
            i++;
        }

        knapsack(bagWeight);

    }

    public static void knapsack(int n){

        int[][] k = new int[weight.length+1][n+1];

        for(int i = 0 ; i <= n ; i++){
            k[0][i] = 0;
        }

        for(int i = 0 ; i <= weight.length ; i++){
            k[i][0] = 0;
        }

        for(int i = 1 ; i <= weight.length ; i++){
            for(int j = 1 ; j <= n ; j++){

                if(weight[i-1] > j){                                                      //0
                    k[i][j] = k[i-1][j];
                }
                else{
                    k[i][j] = Math.max(k[i-1][j], (k[i-1][j-weight[i-1]]) + value[i-1]);  //1
                }
            }
        }

        System.out.println("Item(s) Picked:");
        int i = items.length - 1;
        int j = n;
        while (i > 0) {
            if (k[i][j] != k[i - 1][j]) {
                System.out.println("selected item:"+items[i - 1]);
                j -= weight[i - 1];
            }
            i -= 1;
        }
        System.out.println("Total Value: "+k[weight.length][n]);
    }
}

