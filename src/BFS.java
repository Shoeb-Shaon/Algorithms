import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class BFS {

    //method for Breadth First Search [BFS]
    //parameters 2d array and start
    public static void breadthFirstSearch(int q[][], int s) {
        String color[] = new String[q.length];//array of color of length of 2d matrix
        int parent[] = new int[q.length];//array of parent of length of 2d matrix
        int distance[] = new int[q.length];//array of distance of length of 2d matrix
        Queue<Integer> queue = new LinkedList<>();//Queue of linkedlist
        int i, j;//counters

        //loop for making all nodes of graph white,infinite distance,and no parents
        for (i = 1; i < q.length; i++) {
            color[i] = "white";
            distance[i] = 999999;
            parent[i] = -1;
        }

        //as start point given so changing color,distance,parent(null as start point)
        // s = 1
        color[s] = "gray";
        distance[s] = 0;
        parent[s] = -1;
        queue.add(s); //adding it to queue

        //loop for changing color,distance,parents of other nodes
        while (!queue.isEmpty()) {
            int k = queue.poll();//taking out the start node

            //loop for changing color,distance,parents of other nodes
            for (j = 1; j < q.length; j++) {
                if (q[k][j] == 1 && color[j].equals("white")) {
                    color[j] = "gray";
                    distance[j] = distance[k] + 1;
                    parent[j] = k;
                    queue.add(j);//adding new nodes each time loop runs
                }
            }
            color[k] = "black";//changing start node color
        }
        print(parent, distance);//printing method of parameters parent[] and distance[]
    }

    //method to print output
    public static void print(int parent[], int distance[]) {
        int i;//counter
        //loop for printing output
        //direction method used and is given below
        for (i = 1; i < parent.length; i++) {
            System.out.println(i + " : distance from the source - " + distance[i] + ", path -> " + direction(parent, i));
        }
    }

    //direction method to print the nodes based on distance
    public static String direction(int parent[], int i) {
        String full = "";//temporary string
        int temp = i;//temporary counter
        //loop for finding all the nodes
        while (parent[i] != -1) {
            String x = "" + parent[i];
            full = x + "," + full;
            i = parent[i];
        }
        full = full + temp;//full string
        return full;//return string
    }

    //mainmethod to run BFS
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Scans the new file given diectly
        Scanner sc = new Scanner(new File("add your file directory.txt"));
        int x = sc.nextInt() + 1;//taking next integer
        int[][] undirectedMatrix = new int[x][x];//matrix for undirected graph
        //loop for filling matrix with coordinates given in file by using 1
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //two as undirected {1 if it was directed}
            undirectedMatrix[a][b] = 1;
            undirectedMatrix[b][a] = 1;
        }
        //using the BFS method given above
        breadthFirstSearch(undirectedMatrix, 1);
    }

}
