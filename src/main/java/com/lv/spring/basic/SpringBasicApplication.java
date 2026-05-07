package com.lv.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBasicApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBasicApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBasicApplication.class, args);
        //Bean scope: by default it's a singleton bean
        BinarySearchImpl binarySearchBean = applicationContext.getBean(BinarySearchImpl.class);
        BinarySearchImpl binarySearchBean2 = applicationContext.getBean(BinarySearchImpl.class);
        log.info("bean1: {}", binarySearchBean);
        log.info("bean2: {}", binarySearchBean2);
        log.info("using Spring Dependency Injection to run the BinarySearchImpl: {}", binarySearchBean.binarySearch(new int[]{5, 7, 93, 1, 9, 70}, 9));
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
