import java.util.*;

public class Main {

    public static long inversions = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[]A = new long[n];

        for (int i = 0; i < n; i++){
            A[i] = scanner.nextLong();
        }

        MergeSort(A, 0, n - 1);

        System.out.println(inversions);
    }

    public static void MergeSort(long[] A, int l, int r){
        if (l < r){
            int m = (l + r) / 2;
            MergeSort(A, l, m);
            MergeSort(A, m + 1, r);
            Merge(A, l, m, r);
        }
    }

    public static void Merge(long[] array, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        long[] left = new long [n1];
        long[] right = new long [n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            left[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = array[m + 1+ j];

        int i = 0, j = 0, k = l;

        while (i != n1 && j != n2){
            if (left[i] <= right[j]){
                array[k] = left[i];

                i++;
                k++;
            }

            else{
                array[k] = right[j];

                j++;
                k++;
                inversions += n1 - i;
            }
        }

        while (j < n2) {
            array[k] = right[j];

            k++;
            j++;
        }


        while (i < n1) {
            array[k] = left[i];

            k++;
            i++;
        }

    }
}
