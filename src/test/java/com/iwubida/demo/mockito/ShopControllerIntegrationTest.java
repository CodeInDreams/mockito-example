package com.iwubida.demo.mockito;

import com.iwubida.demo.mockito.controllers.ShopController;
import com.iwubida.demo.mockito.repositories.CustomerBaseService;
import com.iwubida.demo.mockito.repositories.ShopBaseService;
import com.iwubida.demo.mockito.services.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Controller集成测试，使用Spring容器
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 17:52
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopControllerIntegrationTest {

    @SpyBean
    private ShopBaseService shopBaseService;

    @MockBean
    private CustomerBaseService customerBaseService;

    @SpyBean
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopController shopController;

    @Test
    public void getShopCustomerStatisticsTest() {
        doReturn("消费者16").when(customerBaseService).callRepository(1L);

        String result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals("\n\t店铺：店铺1\n\t消费者：消费者16\n\tblablabla", result);
        verify(shopBaseService).callRepository(anyLong());
        verify(customerBaseService).callRepository(1L);
    }

    @Test
    public void getShopCustomerStatisticsTest_mockShop() {
        doReturn("店铺30").when(shopService).getShopName(anyLong());
        doReturn("消费者16").when(customerBaseService).callRepository(1L);

        String result = shopController.getShopCustomerStatistics(1L, 1L);

        assertEquals("\n\t店铺：店铺30\n\t消费者：消费者16\n\tblablabla", result);
        verify(shopBaseService, never()).callRepository(anyLong());
        verify(customerBaseService).callRepository(1L);
    }
}
