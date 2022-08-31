package cn.huanzi.qch.baseadmin.numide.controller;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.numide.pojo.FormEntity;
import cn.huanzi.qch.baseadmin.numide.pojo.InputFeature;
import cn.huanzi.qch.baseadmin.numide.repository.StrainRepository;
import cn.huanzi.qch.baseadmin.numide.service.NumideService;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultVo;
import com.google.gson.Gson;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/numide/")
public class NumideController  {

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



//     获取输入信息
    @PostMapping(value = "/getForm")
    public String getForm(@RequestBody String str) throws Exception {
        Gson gson = new Gson();
        FormEntity formEntity = gson.fromJson(str, FormEntity.class);
        InputFeature inputFeature = numideService.getInputFeatureFromForm(formEntity);
        OutputResultVo outputResultVo = numideService.getOutputResult(inputFeature);

        Result data = Result.of(outputResultVo);
        String dataJson = gson.toJson(data);
        Response response = new Response();
        response.setMessage(dataJson);



        return dataJson;
    }


    // 测试成功
    @GetMapping("/test")
    public Result<OutputResultVo> getNumideResult() throws Exception {
        InputFeature inputFeature = new InputFeature();
        // 测试使用默认数据 测试完后将输入导入inputfeature
        OutputResultVo outputResultVo = numideService.getOutputResult(inputFeature);
        // NumideResult numideResult = numideService.getNumideResult(inputFeature);
        System.out.println(outputResultVo);
        return Result.of(outputResultVo);
    }

}
