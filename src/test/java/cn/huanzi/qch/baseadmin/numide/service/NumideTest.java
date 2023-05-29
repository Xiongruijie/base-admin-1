package cn.huanzi.qch.baseadmin.numide.service;

import cn.huanzi.qch.baseadmin.numide.controller.pojo.InputFeature;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringJUnit4ClassRunner.class)
//@Slf4j
public class NumideTest extends TestCase {

    @Autowired
    NumideService numideService;

    @Test
     public void testGetNumideResultTest() throws Exception {
//        System.out.println("he");
        InputFeature inputFeature = new InputFeature();
//        System.out.println(numideService.getNumideResultTest(inputFeature));
    }
}
