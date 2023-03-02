package org.telran.lecture_5_Merge.practice.count_inversions;

import java.util.Arrays;

public class CountInversionsUseMergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    private static int mergeAndCount(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1); // Left subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); // Right subarray

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return swaps;
    }

    private static int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            // Left subarray count
            count += mergeSortAndCount(arr, l, m);
            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);
            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }
}
