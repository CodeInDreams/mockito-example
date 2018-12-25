package com.iwubida.demo.mockito;

import com.iwubida.demo.mockito.controllers.ShopController;
import com.iwubida.demo.mockito.services.CustomerService;
import com.iwubida.demo.mockito.services.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller接口测试
 * 
 * @author Zhang Yanhui
 * @date 2018/12/24 17:52
 */

@RunWith(SpringRunner.class)
@WebMvcTest(ShopController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class ShopControllerWebMvcTest {

    @MockBean
    private ShopService shopService;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getShopCustomerStatisticsTest_normal() throws Exception {
        doReturn("店铺3").when(shopService).getShopName(3L);
        doReturn("消费者5").when(customerService).getCustomerName(5L);
        mockMvc.perform(get("/statistics/3/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("\n\t店铺：店铺3\n\t消费者：消费者5\n\tblablabla"));
    }

}
