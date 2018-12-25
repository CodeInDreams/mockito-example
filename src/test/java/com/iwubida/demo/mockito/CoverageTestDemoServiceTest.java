package com.iwubida.demo.mockito;

import com.iwubida.demo.mockito.services.impl.CoverageTestDemoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoverageTestDemoServiceTest {

    @Spy
    private CoverageTestDemoServiceImpl coverageTestDemoService;

    @Test
    public void methodWithLotsOfBranchesTest_allCombinations() {
        for (int a = 1; a < 5; ++a) {
            for (int b = 2; b < 5; ++b) {
                for (int c = 2; c < 5; ++c) {
                    coverageTestDemoService.methodWithLotsOfBranches(a, b, c);
                }
            }
        }
    }

    @Test
    public void methodWithLotsOfBranchesTest_one() {
        coverageTestDemoService.methodWithLotsOfBranches(1, 2, 3);
    }
}