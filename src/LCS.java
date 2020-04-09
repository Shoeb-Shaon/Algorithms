/**
 *
 * @author Shoeb_Shaon
 */
public class LCS {
    public static int[][] c;
    public static int[][] b;
    public static void main(String[] args) {

        String a = "BATMAN";
        String b = "BINLADEN";

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();

        LCSmatrix(a,b);
        lcs_length(x,y);
        lcs_seq(a,b);
    }

    public static int[][] LCSmatrix(String X, String Y) {
        //we ignore the top most row and left most column in this matrix
        //so we add 1 and create a matrix with appropriate row and column size 
        int m = X.length() + 1, n = Y.length() + 1;

        int[][] c = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //since we added 1 to row size and column size,
                // we substract 1 from i,j to find the char at that index
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = c[i][j - 1];
                }
            }
        }
        printMatrix(c);
        return c;
    }

    public static void printMatrix(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void lcs_length(char[] x , char[] y){

        int m = x.length+1;
        int n = y.length+1;

        c = new int[m][n];
        b = new int[m][n];

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(x[i-1] == y[j-1]){              //Diagonal
                    c[i][j] = c[i-1][j-1] + 1;

                    b[i][j] = 1;
                }

                else if (c[i-1][j] >= c[i][j-1]){  //Up <= Left
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }

                else{
                    c[i][j] = c[i][j-1];          //Left >= Up
                    b[i][j] = 3;
                }
            }
        }

        System.out.println("Length of Longest Subsequence: "+ c[m-1][n-1]);
    }

    public static void lcs_seq(String a, String b)
    {
        int x = a.length();
        int y = b.length();

        int[][] arr = new int[x + 1][y + 1];

        for (int i = x - 1; i >= 0; i--)
        {
            for (int j = y - 1; j >= 0; j--)
            {
                if (a.charAt(i) == b.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < x && j < y)
        {
            if (a.charAt(i) == b.charAt(j))
            {
                sb.append(a.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1])
                i++;
            else
                j++;
        }
        System.out.println(sb.toString());
    }

}