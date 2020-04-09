public class MergeSort {
    public static void main(String[] args) {
        int ara[] = {70, 50, 60, 10, 20, 40, 20};
        sort(ara, 0, ara.length - 1);
        for (int x:ara
        ) {
            System.out.print(x+ ",");

        }
    }

    private static void sort(int[] ara, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(ara, l, m);
            sort(ara, m + 1, r);
            merge(ara, l, m,r);
        }
    }

    public static void merge(int ara[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = ara[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = ara[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                ara[k] = L[i];
                i++;
            } else {
                ara[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            ara[k] = L[i];
            i++;
            k++;
        }

    }
}
