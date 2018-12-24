package com.iwubida.demo.mockito;

import com.iwubida.demo.mockito.controllers.ShopController;
import com.iwubida.demo.mockito.services.CustomerService;
import com.iwubida.demo.mockito.services.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Controller单元测试，不使用Spring容器
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 10:38
 */

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ShopControllerUnitTest {

    private static long testBeginTime;
    private static int testCount;

    /**
     * 默认调用原有方法，除非mock某个方法
     */
    @Spy
    private ShopService shopService;

    /**
     * stub所有方法，调用方法前必须mock
     */
    @Mock
    private CustomerService customerService;

    /**
     * 注入依赖
     */
    @Spy
    @InjectMocks
    private ShopController shopController;

    /**
     * 所有测试前执行
     */
    @BeforeClass
    public static void beforeAllTests() {
        testBeginTime = System.currentTimeMillis();
    }

    /**
     * 所有测试后执行
     */
    @AfterClass
    public static void afterAllTests() {
        long testEndTime = System.currentTimeMillis();
        log.info("测试结束，共执行{}个用例，用时{}ms", testCount, testEndTime - testBeginTime);
    }

    /**
     * 每个测试前执行
     */
    @Before
    public void beforeEachTest() {
        doReturn("店铺30").when(shopService).getShopName(1L);
        when(customerService.getCustomerName(any())).thenReturn("消费者16");
    }

    /**
     * 每个测试后执行
     */
    @After
    public void afterEachTest() {
        ++testCount;
        verify(shopController, atLeastOnce()).getShopCustomerStatistics(anyLong(), anyLong());
    }

    @Test
    public void getShopCustomerStatisticsTest_validInput() {
        String result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals(result, "\n\t店铺：店铺30\n\t消费者：消费者16\n\tblablabla");
        verify(customerService).getCustomerName(1L);
        verify(shopService).getShopName(anyLong());
    }

    @Test
    public void getShopCustomerStatisticsTest_mockShop() {
        doReturn("\n\t店铺：店铺30").when(shopController).getShopDesc(anyLong());

        String result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals(result, "\n\t店铺：店铺30\n\t消费者：消费者16\n\tblablabla");
        verify(customerService).getCustomerName(1L);
        verify(shopService, never()).getShopName(anyLong());
    }

    @Test
    public void getShopCustomerStatisticsTest_doAnswer() {
        doAnswer(new Answer() {
            int count = 0;

            @Override
            public Object answer(InvocationOnMock invocation) {
                return (++count & 1) == 1 ? "店铺1" : "店铺2";
            }
        }).when(shopService).getShopName(anyLong());

        String result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals(result, "\n\t店铺：店铺1\n\t消费者：消费者16\n\tblablabla");
        verify(customerService).getCustomerName(1L);
        verify(shopService).getShopName(anyLong());

        result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals(result, "\n\t店铺：店铺2\n\t消费者：消费者16\n\tblablabla");
        verify(customerService, times(2)).getCustomerName(1L);
        verify(shopService, times(2)).getShopName(anyLong());
    }

    @Test
    public void getShopCustomerStatisticsTest_reset() {
        doAnswer(new Answer() {
            int count = 0;

            @Override
            public Object answer(InvocationOnMock invocation) {
                return (++count & 1) == 1 ? "店铺1" : "店铺2";
            }
        }).when(shopService).getShopName(anyLong());

        String result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals(result, "\n\t店铺：店铺1\n\t消费者：消费者16\n\tblablabla");
        verify(customerService).getCustomerName(1L);
        verify(shopService).getShopName(anyLong());

        reset(shopService);

        result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals(result, "\n\t店铺：null\n\t消费者：消费者16\n\tblablabla");
        verify(customerService, times(2)).getCustomerName(1L);
        verify(shopService).getShopName(anyLong());
    }
}
