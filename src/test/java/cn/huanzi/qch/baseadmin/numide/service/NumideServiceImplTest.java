package cn.huanzi.qch.baseadmin.numide.service;

import cn.huanzi.qch.baseadmin.numide.pojo.InputFeature;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class NumideServiceImplTest extends TestCase {

    @Autowired
    NumideService numideService;


    @Test
    public void testGetNumideResult() throws Exception {
        InputFeature inputFeature = new InputFeature();
        System.out.println(numideService.getNumideResult(inputFeature).getSupplement());
    }
}
