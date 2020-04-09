import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DFS {

    public static boolean check[];//check array
    public static int timeStart[];//time start array
    public static int timeEnd[];//time end array

    //Depth First Search [DFS] method
    public static void depthFirstSearch(int directedGraph[][],int source){
        System.out.print(source+" ");//prints out source
        timeStart[source]++;//value in index source of time start array incremented
        //loop for checking other nodes
        for(int i=0;i<directedGraph.length;i++){
            //if condition to see if node is = to 1 and unchecked
            if(directedGraph[source][i]==1 && check[i]==false){
                check[i]=true;
                depthFirstSearch(directedGraph,i);//recursion
            }
        }
        timeEnd[source]++;//value in index of source of time end array incremented
    }

    public static void main(String[] args)throws FileNotFoundException,IOException{
        //scans file
        Scanner sc = new Scanner(new File("add your file directory.txt"));
        int x = sc.nextInt()+1;//start
        int directedGraph[][] = new int[x][x];//directed graph adjacency matrix
        check=new boolean[x];//new check array of size x
        timeStart=new int[x];//new time start array of size x
        timeEnd=new int[x];//new time end array of size x
        //loop to read values in file
        while(sc.hasNextInt()){
            int a =sc.nextInt();//one int in file
            int b =sc.nextInt();//another int in file
            directedGraph[a][b]=1;//making adjacency matrix of a,b 1 form 0
        }
        System.out.println("Adjacency Matrix");
        System.out.print(" ");
        //loop for printing adjacency matrix top values
        for(int l=0;l<directedGraph.length;l++){
            System.out.print(l+" ");
        }
        System.out.println();
        //loop for making all nodes unchecked
        for(int j=0;j<directedGraph.length;j++){
            check[j]=false;
            System.out.print(j+" ");//printing out j
            //loop for printing out the matrix
            for(int k=0;k<directedGraph.length;k++){
                System.out.print(directedGraph[j][k]+" ");
            }
            System.out.println();
        }
        System.out.println("\nDiscovered Nodes: ");
        depthFirstSearch(directedGraph,1);//DFS method applied
        System.out.println();
    }
}
