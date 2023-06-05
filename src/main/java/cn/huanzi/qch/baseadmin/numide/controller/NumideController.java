package cn.huanzi.qch.baseadmin.numide.controller;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.numide.controller.pojo.FormEntity;
import cn.huanzi.qch.baseadmin.numide.controller.pojo.InputFeature;
import cn.huanzi.qch.baseadmin.numide.controller.pojo.QueryEntity;
import cn.huanzi.qch.baseadmin.numide.repository.QueryRepository;
import cn.huanzi.qch.baseadmin.numide.repository.StrainRepository;
import cn.huanzi.qch.baseadmin.numide.service.NumideService;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultVo;
import com.google.gson.Gson;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/numide/")
public class NumideController {

    @Autowired
    public NumideService numideService;
    @Autowired
    public StrainRepository strainRepository;
    @Autowired
    public QueryRepository queryRepository;


    @GetMapping("index")
    public ModelAndView Numide() {
        return new ModelAndView("numide/index");
    }

    @GetMapping("query")
    public ModelAndView NumideQuery() {
        return new ModelAndView("numide/query");
    }

    @GetMapping("/querydata")
    public Result<List<QueryEntity>> QueryData() {
        return Result.of(queryRepository.findAll());
    }


    //     获取输入信息
    @PostMapping(value = "/getForm")
    public String getForm(@RequestBody String str) throws Exception {

        Gson gson = new Gson();
        FormEntity formEntity = gson.fromJson(str, FormEntity.class);
        System.out.println(formEntity);

        InputFeature inputFeature = numideService.getInputFeatureFromForm(formEntity);
        // 计算结果
        OutputResultVo outputResultVo = numideService.getOutputResult(inputFeature);
        // 存储查询
        numideService.saveQueryEntity(formEntity, outputResultVo);
        Result data = Result.of(outputResultVo);
        String dataJson = gson.toJson(data);
        Response response = new Response();
        response.setMessage(dataJson);
        //回传数据


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

    @PostMapping("/upload")
    String Upload(MultipartFile file) throws IOException {
//         获取项目根路径
        String currentPath = System.getProperty("user.dir");
        File upload = new File(currentPath, "static/images/upload/");
        if (!upload.exists()) upload.mkdirs();
        System.out.println("upload url:" + upload.getAbsolutePath());
        //获得路径
        String path = upload.getPath();
        //创建文件夹
        File fold = new File(path);
        while (!fold.exists()) {
            fold.mkdirs();
        }
        String oldname1 = file.getOriginalFilename();
        // 新文件名
        file.transferTo(new File(fold, oldname1));

        return oldname1;
    }

    @PostMapping("/addSystem")
    public void AddSystemInforamtion(@RequestBody String str){

    }


    @GetMapping("/addPage")
    public ModelAndView AddSystem() {
        return new ModelAndView("numide/addPage");
    }
}
