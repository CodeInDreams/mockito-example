package com.iwubida.demo.mockito.services.impl;

import com.iwubida.demo.mockito.services.CustomerService;
import org.springframework.stereotype.Service;

/**
 * 消费者服务实现
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 10:12
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public String getCustomerName(Long customerId) {
        return "消费者" + customerId;
    }
}
