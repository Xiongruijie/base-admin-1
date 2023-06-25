package cn.huanzi.qch.baseadmin.numide.controller;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.numide.controller.pojo.*;
import cn.huanzi.qch.baseadmin.numide.repository.QueryRepository;
import cn.huanzi.qch.baseadmin.numide.repository.StrainRepository;
import cn.huanzi.qch.baseadmin.numide.repository.SystemInfoRepository;
import cn.huanzi.qch.baseadmin.numide.service.NumideService;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultVo;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    public SystemInfoRepository systemInfoRepository;


    @GetMapping("index")
    public ModelAndView Numide() {
        return new ModelAndView("numide/index");
    }
    @GetMapping("begin")
    public ModelAndView begin() {
        return new ModelAndView("numide/begin");
    }

    @GetMapping("getAll")
    public List<BeginEntity> GetAllInfo() {
        List<SystemInfo> systemInfoList = systemInfoRepository.findAll();
        List<BeginEntity> beginEntities = new ArrayList<BeginEntity>();
        for (SystemInfo systemInfo : systemInfoList) {
            BeginEntity beginEntity = new BeginEntity(systemInfo.getSystem_num(), systemInfo.getSystem_name());
            beginEntities.add(beginEntity);
        }
        return (beginEntities);
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
        GetInput getInput = gson.fromJson(str, GetInput.class);
        System.out.println(getInput);
//
//        InputFeature inputFeature = numideService.getInputFeatureFromForm(formEntity);
//        // 计算结果
//        OutputResultVo outputResultVo = numideService.getOutputResult(inputFeature);
//        // 存储查询
//        numideService.saveQueryEntity(formEntity, outputResultVo);
//        Result data = Result.of(outputResultVo);
//        String dataJson = gson.toJson(data);
//        Response response = new Response();
//        response.setMessage(dataJson);
        //回传数据


        return str;
    }




    @PostMapping("/upload")
    public List<String> Upload(@RequestParam("systemName") String systemName, @RequestParam("file") MultipartFile file) throws IOException, CsvException {
//         获取项目根路径
        String currentPath = System.getProperty("user.dir");
        File upload = new File(currentPath, "src/main/java/cn/huanzi/qch/baseadmin/numide/controller/");
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
        String filelocal = upload.getAbsolutePath() + "\\" + oldname1;
        //分离出界面实验的名字
        String csvPath = currentPath + "\\src\\main\\java\\cn\\huanzi\\qch\\baseadmin\\numide\\controller\\" + oldname1;
        String fileOrignName = oldname1.split("\\.")[0];
        System.out.println(fileOrignName);
        String line = "";
        List<String> strings = new ArrayList<>();
        boolean SelectBegin = false;
        boolean SelectEnd = false;
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            while ((line = br.readLine()) != null) {

                if (SelectBegin && (!SelectEnd) && (!line.equals("%end%"))) {
                    String s = line.split(",")[1];
                    strings.add(s);
                }
                if (line.equals("%dict_sele_name%")) {
                    SelectBegin = true;
                }
                if (line.equals("%end%") && SelectBegin == true) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //存储系统信息到数据库
        SystemInfo systemInfo = new SystemInfo((int) systemInfoRepository.count()+1, systemName, filelocal, strings.toString());
        systemInfoRepository.save(systemInfo);
        try {
            // 指定要执行的命令
            String command = "python3 gen_db.py "+fileOrignName+".csv "+fileOrignName+".py";

            // 创建进程构建器
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

            // 启动进程并获取输入流
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // 读取命令的输出
            String lines;
            while ((lines = reader.readLine()) != null) {
                System.out.println(lines);
            }

            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("命令执行完成，退出码：" + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return strings;
    }

    /**
     * @Author: Xiongruijie
     * @Param:
     * @return:
     * @Author: Xiongruijie
     * @date: 2023/6/13
     * @time: 19:57
     * @description: 发送数据库数据
     */
    @GetMapping("/getSystemInfo")
    public List<SystemInfo> sendSystemInfo() {
        return systemInfoRepository.findAll();
    }

    @PostMapping("/numide/getSelect")
    public List<String> sendSelect(@RequestBody InitRequstData requstData){
        int num = requstData.getNum();
        SystemInfo systemInfo = systemInfoRepository.getOne(num);

        List<String> strings = Arrays.asList(systemInfo.getSelect_exp().split(","));
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            str = str.replaceAll("^[\\[\\]\\s]+$", ""); // 使用正则表达式去除方括号
            System.out.println(str);
            strings.set(i, str);
        }


        return strings;
    }
    @PostMapping("/getSelect")
    public List<String> sendSelect1(@RequestBody InitRequstData requstData){
        int num = requstData.getNum();
        SystemInfo systemInfo = systemInfoRepository.getOne(num);
        List<String> strings = Arrays.asList(systemInfo.getSelect_exp().split(","));
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            str = str.replaceAll("[\\[\\]\\s]+", ""); // 使用正则表达式去除方括号
            strings.set(i, str);
        }
        return strings;
    }




    @GetMapping("/addPage")
    public ModelAndView AddSystem() {
        return new ModelAndView("numide/addPage");
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
    @GetMapping("template")
    public ModelAndView template() {
        return new ModelAndView("numide/template");
    }
}




