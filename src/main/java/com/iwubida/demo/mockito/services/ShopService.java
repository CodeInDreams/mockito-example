package com.iwubida.demo.mockito.services;

/**
 * 店铺服务
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 10:12
 */

public interface ShopService {

    /**
     * 获取店铺名称
     *
     * @param shopId 店铺id
     * @return 店铺名称
     */
    String getShopName(Long shopId);
}
