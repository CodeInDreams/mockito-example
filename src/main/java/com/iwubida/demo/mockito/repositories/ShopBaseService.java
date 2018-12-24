package com.iwubida.demo.mockito.repositories;

/**
 * 店铺基础服务
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 17:06
 */

public interface ShopBaseService {

    /**
     * 数据库查询
     *
     * @param shopId 店铺id
     * @return 店铺名称
     */
    String callRepository(Long shopId);
}
