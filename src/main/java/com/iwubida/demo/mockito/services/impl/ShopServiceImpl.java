package com.iwubida.demo.mockito.services.impl;

import com.iwubida.demo.mockito.services.ShopService;
import org.springframework.stereotype.Service;

/**
 * 店铺服务实现
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 10:12
 */

@Service
public class ShopServiceImpl implements ShopService {

    @Override
    public String getShopName(Long shopId) {
        return "店铺" + shopId;
    }
}
