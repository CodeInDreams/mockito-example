package com.iwubida.demo.mockito.repositories;

/**
 * 消费者基础服务
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 17:06
 */

public interface CustomerBaseService {

    /**
     * 数据库查询
     *
     * @param customerId 消费者id
     * @return 消费者名称
     */
    String callRepository(Long customerId);
}
