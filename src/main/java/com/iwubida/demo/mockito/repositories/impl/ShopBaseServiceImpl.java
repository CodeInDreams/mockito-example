package com.iwubida.demo.mockito.repositories.impl;

import com.iwubida.demo.mockito.repositories.ShopBaseService;
import org.springframework.stereotype.Service;

/**
 * 店铺基础服务实现
 *
 * @author Zhang Yanhui
 * @date 2018/12/24 17:42
 */

@Service
public class ShopBaseServiceImpl implements ShopBaseService {

    @Override
    public String callRepository(Long shopId) {
        return "店铺" + shopId;
    }
}
