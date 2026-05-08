package com.lv.spring.basic;

import com.lv.spring.basic.cdi.SomeCdiBusiness;
import com.lv.spring.basic.cdi.SomeCdiDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SomeCdiBusinessTest {
    //Inject main bean
    @InjectMocks
    SomeCdiBusiness business;

    //Inject mock, dependency of main bean
    @Mock
    SomeCdiDao daoMock;

    @Test
    void testBasicScenario() {
        Mockito.when(daoMock.getData()).thenReturn(new int[]{2, 4});
        assertEquals(4, business.findGreatest());
    }

    @Test
    void testBasicScenario_NoElements() {
        Mockito.when(daoMock.getData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, business.findGreatest());
    }

    @Test
    void testBasicScenario_EqualElements() {
        Mockito.when(daoMock.getData()).thenReturn(new int[]{2, 2});
        assertEquals(2, business.findGreatest());
    }
}
