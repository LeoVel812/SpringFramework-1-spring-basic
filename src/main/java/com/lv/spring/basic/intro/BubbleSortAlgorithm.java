package com.lv.spring.basic.intro;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        int n = numbers.length;
        boolean swapped;

        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparisons
            // After each pass, the largest element 'bubbles' to the end,
            // so we can reduce the comparison range by 'i'
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swap elements
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: if no elements were swapped, the array is already sorted
            if (!swapped) break;
        }
        return numbers;
    }
}
