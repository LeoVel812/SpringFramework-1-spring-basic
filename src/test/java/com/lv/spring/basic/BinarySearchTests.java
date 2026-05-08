package com.lv.spring.basic;

import com.lv.spring.basic.intro.BinarySearchImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringJUnitConfig is a composed annotation that combines @ExtendWith(SpringExtension.class)
// from JUnit Jupiter with @ContextConfiguration from the Spring TestContext Framework.
// It's analogous to @SpringBootTest
@SpringJUnitConfig(classes = SpringBasicApplication.class)
class BinarySearchTests {
    //get the bean from the context
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    void testHappyPath() {
        int[] numbers = {1539, 1000, 5, 2, 9, 4, 1, 3, 50, 102, 152};
        int target = 1000;
        int index = binarySearch.binarySearch(numbers, target);
        assertEquals(9, index);
    }

}
