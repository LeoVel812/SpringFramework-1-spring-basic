package com.lv.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBasicApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBasicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int[] numbers = {5, 2, 9, 1, 3, 50, 102};
        log.info("initial array: {}", Arrays.toString(numbers));
        int target = 102;
        log.info("target: {}", target);

        log.info("Running different sorting algorithms and comparing its execution times");
        List<SortAlgorithm> algorithms = List.of(new BubbleSortAlgorithm(),
                new DualPivotQuickSortAlgorithm());

        algorithms.forEach(algorithm ->
                runAlgorithms(algorithm, numbers.clone(), target));
    }

    public void runAlgorithms(SortAlgorithm algorithm, int[] numbers, int target) {
        BinarySearchImpl binarySearch = new BinarySearchImpl(algorithm);

        long time = System.nanoTime();
        int index = binarySearch.binarySearch(numbers, target);
        long finalTime = System.nanoTime();
        log.info("Element found at index: {}", index);
        log.info("nanos passed: {}", finalTime - time);

    }
}
