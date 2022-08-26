package cn.huanzi.qch.baseadmin.numide.controller;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.numide.pojo.InputFeature;
import cn.huanzi.qch.baseadmin.numide.pojo.Strain;
import cn.huanzi.qch.baseadmin.numide.exception.repository.StrainRepository;
import cn.huanzi.qch.baseadmin.numide.service.NumideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/numide/")
public class NumideController {

    @Autowired
    public NumideService numideService;
    @Autowired
    public StrainRepository strainRepository;


    @GetMapping("index")
    public ModelAndView Numide(){
        return new ModelAndView("numide/index");
    }

    @GetMapping("query")
    public ModelAndView NumideQuery(){
        return new ModelAndView("numide/query");
    }

    // 测试成功
    @GetMapping("/test")
    public Result<List<Strain>> getNumideResult() throws Exception {
        InputFeature inputFeature = new InputFeature();
        // 测试使用默认数据 测试完后将输入导入inputfeature
        List<Strain> data = new ArrayList<>();
        data = strainRepository.findAll();
        return Result.of(data);
    }


}
