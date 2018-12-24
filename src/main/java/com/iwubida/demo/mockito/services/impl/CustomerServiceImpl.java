package com.iwubida.demo.mockito.services.impl;

import com.iwubida.demo.mockito.repositories.CustomerBaseService;
import com.iwubida.demo.mockito.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消费者服务实现
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 10:12
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerBaseService customerBaseService;

    @Override
    public String getCustomerName(Long customerId) {
        return customerBaseService.callRepository(customerId);
    }
}
