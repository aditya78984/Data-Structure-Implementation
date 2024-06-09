// video solution
// https://www.youtube.com/watch?v=fSsMqlUiaQg&list=PLfqp6HACKhJtsdznHSzfVNpuYq2pM_3oj&index=19

import java.util.Scanner;

public class Rearrange {
    static void rotate(int arr[], int start, int end) {
        int lastVal = arr[end];

        for (int i = end - 1; i >= start; i--) {
            arr[i + 1] = arr[i];
        }

        // copy last val to first
        arr[start] = lastVal;
    }

    static void rearrangeArrayElement(int arr[], int n) {
        int k = 0;  // -ve indx-even, 0 U +ve indx-odd
        while (k < n) {
            if ((k % 2 == 0 && arr[k] < 0) || (k % 2 != 0 && arr[k] >= 0)) {
                k++;
                continue;
            }

            if (k % 2 == 0 && arr[k] >= 0) {
                int i = k, j = k;
                while (i < n && arr[i] >= 0) i++;
                if (i >= n) return;
                rotate(arr, j, i);
            } else if (k % 2 != 0 && arr[k] < 0) {
                int i = k, j = k;
                while (j < n && arr[j] < 0) j++;
                if (j >= n) return;
                rotate(arr, i, j);
            }
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        rearrangeArrayElement(arr, n);

        // print all arr
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
