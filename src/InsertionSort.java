class InsertionSort {
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort obj = new InsertionSort();
        obj.sort(arr);
        for (int x:
                arr) {
            System.out.print(x+",");

        }
    }

    void sort(int arr[]) {
        for (int i = 0; i <arr.length  ; i++) {
            int k = 1;
            for (int j = 0; j < arr.length ; j++) {
                if(arr[k] < arr[j]){
                    int temp = arr[j];
                    arr[j] =arr[k];
                    arr[k] = temp ;
                }
                k++;
                if(k>=arr.length)
                    break;
            }
        }
    }

} 