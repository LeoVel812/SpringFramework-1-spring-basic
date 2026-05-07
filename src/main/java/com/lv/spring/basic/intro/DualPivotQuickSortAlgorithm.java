package com.lv.spring.basic.intro;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class DualPivotQuickSortAlgorithm implements SortAlgorithm {

    public int[] sort(int[] numbers) {
        return dualPivotQuickSort(numbers, 0, numbers.length - 1);
    }

    private static int[] dualPivotQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pivot1 is the left pivot, pivot2 is the right pivot
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
            int p1 = arr[low];
            int p2 = arr[high];

            // Pointers for partitioning
            int lt = low + 1;
            int gt = high - 1;
            int i = low + 1;

            while (i <= gt) {
                if (arr[i] < p1) {
                    swap(arr, i++, lt++);
                } else if (arr[i] > p2) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }

            // Move pivots to their final positions
            swap(arr, low, --lt);
            swap(arr, high, ++gt);

            // Recursively sort the three resulting segments
            dualPivotQuickSort(arr, low, lt - 1);
            dualPivotQuickSort(arr, lt + 1, gt - 1);
            dualPivotQuickSort(arr, gt + 1, high);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
