import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MST_Prim {

    public static int[][] graph = new int[6][6];
    public static int[] parent = new int[6];
    public static int[] key = new int[6];
    public static boolean[] check = new boolean[6];
    public static String[] city;

    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File ("add your file location.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
        }

        catch(IOException e){
            System.out.println("File not found");
        }

        String s = sc.nextLine();
        city = s.split(" ");

        while(sc.hasNextInt()){
            for(int i = 0 ; i < graph.length ; i++){
                for(int j = 0 ; j < graph.length ; j++){
                    graph[i][j] = sc.nextInt();
                }
            }
        }

        mst_prim(graph , 0);
    }

    public static void mst_prim(int[][] graph , int r){
        for (int i = 0 ; i < graph.length ; i++){
            key[i] = 5000;
            parent[i] = -1;
            check[i] = false;
        }

        key[r] = 0;
        //check[r] = true;

        for(int i = 0 ; i < graph.length ; i++){
            int minKey = min(key , check);
            check[minKey] = true;
            for(int j = 0 ; j < graph.length ; j++){
                if (check[j] == false && graph[minKey][j] < key[j]){
                    parent[j] = minKey;
                    key[j] = graph[minKey][j];
                }
            }
        }

        int i = 0;
        for (int j = 1; j < graph.length; j++){
            System.out.println(city[i]+ " -- " + city[j] + "\t"+ key[j]);
            i++;
        }
    }

    public static int min (int[] key , boolean[] check){
        int min = 50000 , minIndex = -1 ;
        for(int i = 0 ; i <key.length ; i++){
            if(check[i] == false && key[i] < min){
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

