class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int m = num1.length;
        int n = num2.length;

        int[] arr = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (num1[i] < num2[j]) {
                arr[k] = num1[i];
                i++;
                k++;
            } else {
                arr[k] = num2[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            arr[k] = num1[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = num2[j];
            j++;
            k++;
        }

        int len = m + n;

        
        if (len % 2 == 1) {
            return arr[len / 2];
        }

        
        return ((double) arr[len / 2 - 1] + arr[len / 2]) / 2;
    }
}