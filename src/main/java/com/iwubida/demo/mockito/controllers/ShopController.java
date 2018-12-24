package com.iwubida.demo.mockito.controllers;

import com.iwubida.demo.mockito.services.CustomerService;
import com.iwubida.demo.mockito.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺API
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 9:51
 */

@RestController
public class ShopController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ShopService shopService;

    /**
     * 查询店铺指定用户的交易概述
     *
     * @param shopId     店铺id
     * @param customerId 消费者id
     * @return 概述
     */
    @GetMapping("trade-statistics/{shopId}/{customerId}")
    public String getTradeStatistics(@PathVariable("shopId") Long shopId, @PathVariable("customerId") Long customerId) {
        return "\n\t店铺：" + shopService.getShopName(shopId)
                + "\n\t消费者：" + customerService.getCustomerName(customerId)
                + "\n\tblablabla";
    }
}
