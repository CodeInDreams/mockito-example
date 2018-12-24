package com.iwubida.demo.mockito.services;

/**
 * 消费者服务
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 9:51
 */

public interface CustomerService {

    /**
     * 获取消费者姓名
     *
     * @param customerId 消费者id
     * @return 消费者姓名
     */
    String getCustomerName(Long customerId);
}
