package com.iwubida.demo.mockito.repositories.impl;

import com.iwubida.demo.mockito.repositories.CustomerBaseService;
import org.springframework.stereotype.Service;

/**
 * 消费者基础服务实现
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 17:41
 */

@Service
public class CustomerBaseServiceImpl implements CustomerBaseService {
    @Override
    public String callRepository(Long customerId) {
        return "消费者" + customerId;
    }
}
