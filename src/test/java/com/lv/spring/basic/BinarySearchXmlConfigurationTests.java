package com.lv.spring.basic;

import com.lv.spring.basic.intro.BinarySearchImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringJUnitConfig is a composed annotation that combines @ExtendWith(SpringExtension.class)
// from JUnit Jupiter with @ContextConfiguration from the Spring TestContext Framework.
// It's analogous to @SpringBootTest
@SpringJUnitConfig(locations = "/testContext.xml")
class BinarySearchXmlConfigurationTests {
    //get the bean from the context
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    void testHappyPath() {
        int[] numbers = {5, 2, 9, 1, 3, 50, 102, 152};
        int target = 152;
        int index = binarySearch.binarySearch(numbers, target);
        assertEquals(7, index);
    }

}
