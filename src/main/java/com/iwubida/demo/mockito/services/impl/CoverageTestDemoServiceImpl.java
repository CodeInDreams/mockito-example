package com.iwubida.demo.mockito.services.impl;

import com.iwubida.demo.mockito.services.CoverageTestDemoService;
import org.springframework.stereotype.Service;

/**
 * 代码覆盖测试Demo服务实现
 *
 * @author Zhang Yanhui
 * @date 2018/12/25 9:23
 */

@Service
public class CoverageTestDemoServiceImpl implements CoverageTestDemoService {

    @Override
    public void methodWithLotsOfBranches(int a, int b, int c) {
        switch (a) {
            case 1:
                if (b > c) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
                break;
            case 2:
                if (b == c) {
                    System.out.println(2);
                } else {
                    System.out.println(3);
                }
                break;
            case 3:
                if (b + c < 5) {
                    System.out.println(4);
                } else {
                    System.out.println(5);
                }
                break;
            default:
                System.out.println(6);
        }
    }
}
