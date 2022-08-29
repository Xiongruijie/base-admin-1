package cn.huanzi.qch.baseadmin.numide.controller;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.numide.pojo.FormEntity;
import cn.huanzi.qch.baseadmin.numide.pojo.InputFeature;
import cn.huanzi.qch.baseadmin.numide.repository.StrainRepository;
import cn.huanzi.qch.baseadmin.numide.service.NumideService;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultVo;
import com.google.gson.Gson;
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

    // 测试成功
    @GetMapping("/test")
    public Result<OutputResultVo> getNumideResult() throws Exception {
        InputFeature inputFeature = new InputFeature();
        // 测试使用默认数据 测试完后将输入导入inputfeature
        OutputResultVo outputResultVo = numideService.getOutputResult(inputFeature);
//        NumideResult numideResult = numideService.getNumideResult(inputFeature);
        System.out.println(outputResultVo);
        return Result.of(outputResultVo);
    }

//     获取输入信息
    @PostMapping(value = "/getForm")
    public Result<String > getForm(@RequestBody String str) throws Exception {
        Gson gson = new Gson();
        FormEntity formEntity = gson.fromJson(str, FormEntity.class);
        InputFeature inputFeature = numideService.getInputFeatureFromForm(formEntity);
        System.out.println(inputFeature);
        OutputResultVo outputResultVo = numideService.getOutputResult(inputFeature);
        String outputJson = gson.toJson(outputResultVo);

        System.out.println(outputJson);
        return Result.of(outputJson);
    }

//    @GetMapping("/numide/POST?UserName={UserName}&inputDate={inputDate}&sampleType={sampleType}&sampleNumber={sampleNumber}&sampleSource={sampleSource}&remark={remark}&one={one}&two={two}&three={three}&four={four}&five={five}&six={six}&seven={seven}&eight={eight}")
//    public String getFormEntiy(@PathVariable("UserName") String userName,
//                           @PathVariable("inputDate") String inputDate,
//                           @PathVariable("sampleType") String sampleType,
//                           @PathVariable("sampleNumber") String sampleNumber,
//                           @PathVariable("sampleSource") String sampleSource,
//                           @PathVariable("remark") String remark,
//                           @PathVariable("one") Integer one,
//                           @PathVariable("two") Integer two,
//                           @PathVariable("three") Integer three,
//                           @PathVariable("four") Integer four,
//                           @PathVariable("five") Integer five,
//                           @PathVariable("six") Integer six,
//                           @PathVariable("seven") Integer seven,
//                           @PathVariable("eight") Integer eight){
//        FormEntity formEntity = new FormEntity(userName,inputDate,sampleType,sampleNumber,sampleSource,remark,one,two,three,four,five,six,seven,eight);
//        System.out.println(formEntity.toString());
//        return "formEntity";
//    }

    //http://192.168.154.1:8888/numide/POST?
    // UserName=544065797%40qq.com&
    // inputDate=2022-08-05&
    // sampleType=2&
    // sampleNumber=2&
    // sampleSource=2&
    // remark=2

}
