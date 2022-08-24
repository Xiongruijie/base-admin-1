package cn.huanzi.qch.baseadmin.numide.controller;

import cn.huanzi.qch.baseadmin.numide.pojo.InputFeature;
import cn.huanzi.qch.baseadmin.numide.pojo.NumideResult;
import cn.huanzi.qch.baseadmin.numide.service.NumideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/numide/")
public class NumideController {

    @Autowired
    public NumideService numideService;


    @GetMapping("index")
    public ModelAndView Numide(){
        return new ModelAndView("numide/index");
    }

    @GetMapping("query")
    public ModelAndView NumideQuery(){
        return new ModelAndView("numide/index");
    }

    @GetMapping("/test")
    public NumideResult getNumideResult() throws Exception {
        InputFeature inputFeature = new InputFeature();
        // 测试使用默认数据 测试完后将输入导入inputfeature


        return numideService.getNumideResult(inputFeature);
    }


}
