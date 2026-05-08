package com.lv.spring.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// SpringExtension integrates the Spring TestContext Framework
// into the JUnit Jupiter testing framework
// It's analogous to @SpringBootTest
@ExtendWith(SpringExtension.class)
//load the context
@ContextConfiguration(classes = SpringBasicApplication.class)
class SpringBasicApplicationTests {

    @Test
    void contextLoads() {
    }

}
