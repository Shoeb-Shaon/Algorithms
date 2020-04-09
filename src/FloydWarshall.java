import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Shoeb_Shaon
 */
public class FloydWarshall {
    static final int N = 11;
    public static int[][] graph = new int[11][11];
    public static String[] city = { "A" , "B" , "C" , "D", "E" , "F" , "G" , "H" , "I" , "J" , "K" };
    public static void main(String[] args) {
        // TODO code application logic here
        File file1 = new File ("Add your file directory.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file1);
        }

        catch(IOException e){
            System.out.println("File not found");
        }
        for(int j = 0 ; j < graph.length ; j++){
            for(int k = 0 ; k< graph.length ; k++){
                if(j == k){
                    graph[j][k] = 0;
                }
                else{
                    graph[j][k] = 999;
                }
            }
        }

        while(sc.hasNext()){
            String a = sc.next();
            int p = 0;
            for(int i = 0 ; i < city.length ; i++){
                if(a.equals(city[i])){
                    p = i;
                }
            }

            a = sc.next();
            int q = 0;
            for(int i = 0 ; i < graph.length ; i++){
                if(a.equals(city[i])){
                    q = i;
                }
            }
            graph[p][q] = sc.nextInt();
        }
        System.out.println("Matrix to find the shortest path of.");
        printMatrix(graph);
        System.out.println("Shortest Path Matrix.");
        printMatrix(FloydAlgo(graph));
    }

    public static int[][] FloydAlgo(int[][] M) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // to keep track.;
                    if (M[i][k] + M[k][j] < M[i][j]) {
                        M[i][j] = M[i][k] + M[k][j];
                    }
                    // or not to keep track.
                    //M[i][j] = min(M[i][j], M[i][k] + M[k][j]);
                }
            }
        }
        return M;
    }


    public static int min(int i, int j) {
        if (i > j) {
            return j;
        }
        return i;
    }

    public static void printMatrix(int[][] Matrix) {
        System.out.print("\n\t");
        for (int j = 0; j < N; j++) {
            System.out.print(city[j] + "\t");
        }
        System.out.println();
        for (int j = 0; j < 200; j++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(city[i] + " |\t");
            for (int j = 0; j < N; j++) {
                System.out.print(Matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
}

