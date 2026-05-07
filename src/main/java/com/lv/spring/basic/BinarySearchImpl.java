package com.lv.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Scope("prototype") // to create a new bean every time it's requested
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // to create a new bean every time it's requested
public class BinarySearchImpl {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // Field injection:
    private final SortAlgorithm sortAlgorithm;

    // Constructor injection:
    // Another way for multiple bean candidates, using  @Qualifier
    public BinarySearchImpl(@Qualifier("quick") SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    // Setter injection:
    // @Autowired
//    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }


    public int binarySearch(int[] arr, int target) {
        //First sort the array, but with no tied algorithm:
        log.info("input array before being sorted: {}", Arrays.toString(arr));
        int[] sortedNumbers = sortAlgorithm.sort(arr);
        log.info("sortAlgorithm used: {}", sortAlgorithm.getClass().getSimpleName());
        log.info("Sorted array: {}", Arrays.toString(sortedNumbers));

        // search logic:
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Find the middle index. Using this formula avoids integer overflow for large arrays.
            int mid = low + (high - low) / 2;

            if (sortedNumbers[mid] == target) {
                return mid; // Found it!
            } else if (sortedNumbers[mid] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        return -1; // Target not found
    }

}
