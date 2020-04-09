import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt() ;
        int e = sc.nextInt();

        int matrix [][] = new int [v][v] ;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                matrix[i][j] = -1 ;
            }
        }
        if(e < (int)Math.pow(10,5)) {
            for (int i = 0; i < e; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int weight = sc.nextInt();
                matrix[v1][v2] = weight;
            }
        }
        dijkstra(matrix,2);
    }

    private static void dijkstra(int[][] matrix,int source) {
        int v = matrix.length;
        boolean visited [] = new boolean[v];
        int distance [] = new int[v];
        distance[source] = 0 ;

        for (int i = 1; i < distance.length ; i++)
            distance[i] = Integer.MAX_VALUE;

        for (int i = 0; i < v ; i++) {
            //find vertex with minimum distance
            int minVertex =  findMinVertex(distance,visited);
            visited[minVertex] = true ;
            //explore neighbours
            for (int j = 0; j < v ; j++) {
                if(matrix[minVertex][j] != -1 && !visited[j] ){
                    int newDistance =  distance[minVertex] + matrix[minVertex][j] ;
                    if(newDistance < distance[j]){
                        distance[j] = newDistance ;
                    }
                }
            }
        }

        for (int i = 0; i <v ; i++) {
            System.out.println(i + " "+ distance[i]);
        }


    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1 ;
        for (int i = 0; i <distance.length ; i++) {
            if(!visited[i] && (minVertex == -1 || distance [i] < distance [minVertex]) ){
                minVertex = i ;
            }
        }
        return minVertex ;
    }
}