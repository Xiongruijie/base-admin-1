package cn.huanzi.qch.baseadmin.numide.service;


import cn.huanzi.qch.baseadmin.numide.controller.pojo.*;
import cn.huanzi.qch.baseadmin.numide.repository.BiochemicalTestRepository;
import cn.huanzi.qch.baseadmin.numide.repository.QueryRepository;
import cn.huanzi.qch.baseadmin.numide.repository.StrainRepository;
import cn.huanzi.qch.baseadmin.numide.repository.StrainTestRepository;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultElementVo;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Slf4j
public class NumideServiceImpl implements NumideService {

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private StrainRepository strainRepository;

    @Autowired
    private StrainRepository numideRepository;

    @Autowired
    private StrainTestRepository strainTestRepository;

    @Autowired
    private BiochemicalTestRepository biochemicalTestRepository;

    @Override
    public List<StrainTest> findAll() {
        List<StrainTest> strainTestList = strainTestRepository.findAll();
        return strainTestList;
    }

    @Override
    public StrainTest findOne(Integer index) {
        StrainTest strainTestList = strainTestRepository.getOne(index);
        return strainTestList;
    }


    /**
     * @Param: StrainTest strainTest
     * @return: void
     * @Author: Xiongruijie
     * @date: 17:09
     * // 对StrainTest对象预处理
     * // 将0和100转换为1和99
     */
    public void PreCompute(StrainTest strainTest) throws IllegalAccessException {
        Class cls = strainTest.getClass();
        Field[] fields = cls.getDeclaredFields();
        Integer integer0 = 0;
        Integer integer100 = 100;
        Integer integer1 = 1;
        Integer integer99 = 99;
        for (Field field : fields) {
            //开启私有化成员权限,private属性默认权限为false.
            // 从这可以看出private只是逻辑上的私有化，实际上通过反射机制依然可以获取到值。所以IllegalAccessException异常不会报出
            field.setAccessible(true);
            //获取数量类型 如 String Integer
            String type_name = field.getType().getTypeName();
            if (!(field.getName().equals("strainId"))) {
                //开始对Integer类型的属性进行处理
                Integer integer = (Integer) field.get(strainTest);

                // 初步校验
                if (integer.equals(integer0)) {
                    //操作
                    field.set(strainTest, integer1);
                } else if (integer.equals(integer100)) {
                    field.set(strainTest, integer99);
                }
            }
            System.out.println(field.getName());
        }
    }

    /**
     * @Author: Xiongruijie
     * @Param: List<StrainTest> strainTestList
     * @return:
     * @Author: Xiongruijie
     * @date: 2022/8/22
     * @time: 10:34
     * @description:
     */
    public List<StrainTest> PreCompute(List<StrainTest> strainTestList) throws IllegalAccessException, CloneNotSupportedException {
        Integer integer1 = 1;
        Integer integer0 = 0;
        Integer integer100 = 100;
        Integer integer99 = 99;
        List<StrainTest> strainTestListBackup = new ArrayList<>();
        for (StrainTest strainTest: strainTestList){
            StrainTest strainTest1 = new StrainTest();
            strainTest1 = (StrainTest) strainTest.clone();
            strainTestListBackup.add(strainTest1);
        }
        for (StrainTest strainTest : strainTestListBackup) {
            Class cls = strainTest.getClass();
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                //开启私有化成员权限,private属性默认权限为false.从这可以看出private只是逻辑上的私有化，实际上通过反射机制依然可以获取到值。
                field.setAccessible(true);
                //获取数量类型 如 String Integer
                String type_name = field.getType().getTypeName();
                if (!(field.getName().equals("strainId"))) {
                    //开始对integer类型的属性进行处理

                    Integer integer = (Integer) field.get(strainTest);
                    // 初步校验
                    if (integer.equals(integer0)) {
                        //操作
                        field.set(strainTest, integer1);
                    } else if (integer.equals(integer100)) {
                        field.set(strainTest, integer99);
                    }
                }
            }
        }
        return strainTestListBackup;
    }

    /**
     * @Param: List<StrainTest>
     * @return: List<ComputePrepare>
     * @Author: Xiongruijie
     * @date: 17:09
     * * 生成计算准备对象
     * * 实际上计算只需要24个生化实验，根本不需要47个生化实验的数据
     * * 该函数目的是为了将24个生化实验的数据摘出来
     */
    public List<ComputePrepare> GenerateComputePrepareList(List<StrainTest> strainTestList) {
        List<ComputePrepare> computePrepareList = new ArrayList<ComputePrepare>();
        for (StrainTest strainTest : strainTestList) {
            ComputePrepare computePrepare = new ComputePrepare();
            computePrepare.setStrain_id(strainTest.getStrainId());
            computePrepare.setPhe(strainTest.getExperiment7());
            computePrepare.setXyl(strainTest.getExperiment47());
            computePrepare.setRaf(strainTest.getExperiment41());
            computePrepare.setInd(strainTest.getExperiment1());
            computePrepare.setSuc(strainTest.getExperiment45());
            computePrepare.setOrn(strainTest.getExperiment10());
            computePrepare.setLac(strainTest.getExperiment34());
            computePrepare.setONPG(strainTest.getExperiment22());
            computePrepare.setUre(strainTest.getExperiment6());
            computePrepare.setCit(strainTest.getExperiment4());
            computePrepare.setMalt(strainTest.getExperiment35());
            computePrepare.setLys(strainTest.getExperiment8());
            computePrepare.setMalo(strainTest.getExperiment14());
            computePrepare.setSor(strainTest.getExperiment44());
            computePrepare.setDul(strainTest.getExperiment30());
            computePrepare.setAra(strainTest.getExperiment27());
            computePrepare.setMel(strainTest.getExperiment38());
            computePrepare.setRha(strainTest.getExperiment42());
            computePrepare.setEsc(strainTest.getExperiment15());
            computePrepare.setMR(strainTest.getExperiment2());
            computePrepare.setH2S(strainTest.getExperiment5());
            computePrepare.setTre(strainTest.getExperiment46());
            computePrepare.setCel(strainTest.getExperiment29());
            computePrepare.setOx(strainTest.getExperiment21());
            computePrepareList.add(computePrepare);
        }
        return computePrepareList;
    }

    /**
     * @Param: List<StrainTest>
     * @return: List<ComputeResult>
     * @Author: Xiongruijie
     * @date: 17:07
     * ComputeResultList的strain_id初始化
     */
    public List<ComputeResult> InitComputeResultList(List<StrainTest> strainTestList) {
        List<ComputeResult> computeResultList = new ArrayList<ComputeResult>();

        for (StrainTest strainTest : strainTestList) {
            ComputeResult computeResult = new ComputeResult();
            computeResult.setStrainId(strainTest.getStrainId());
            computeResultList.add(computeResult);
        }

        return computeResultList;
    }

    /**
     * @Param: List<ComputePrepare>, InputFeature, List<ComputeResult>
     * @return: void
     * @Author: Xiongruijie
     * @date: 17:10
     * 根据用户输入InputFeature修改ComputePrepareList的值
     * 计算Identification存入ComputeResultList中
     */
    public void ComputeIdentification(List<ComputePrepare> computePrepareList, InputFeature inputFeature, List<ComputeResult> computeResultList) throws Exception {

        Double totalFrequency = Double.valueOf(1.0);
        int computePrepareIndex = 0;
        int computeResultIndex = 0;
        for (ComputePrepare computePrepare : computePrepareList) {
            // computePrepareList是整个实验数据库的记录
            // computePrepare是一个菌种的记录
            Class computePrepareClass = computePrepare.getClass();
            Class inputFeatureClass = inputFeature.getClass();
            // 结果列表中取computePrepareIndex同索引的对象，如果不对还需要在改改
            ComputeResult computeResult = computeResultList.get(computePrepareIndex);
            Double itemIdentification = Double.valueOf(1.0);

            Field[] computePrepareClassDeclaredFields = computePrepareClass.getDeclaredFields();
            Field[] inputFeatureClassDeclaredFields = inputFeatureClass.getDeclaredFields();

            //判定Result和ComputePrepare是否为同一个id
            if (!computeResult.getStrainId().equals(computePrepare.getStrain_id())) {
                log.info("StrainId不匹配");
                System.out.println("computeResultID:" + computeResult.getStrainId() + "\n"
                        + "computePrepareID:" + computePrepare.getStrain_id()
                );
            }
            for (Field inputFeatureClassDeclaredField : inputFeatureClassDeclaredFields) {
                inputFeatureClassDeclaredField.setAccessible(true);
            }
            for (Field computePrepareClassDeclaredField : computePrepareClassDeclaredFields) {
                computePrepareClassDeclaredField.setAccessible(true);
                if (computePrepareClassDeclaredField.getName().equals("strain_id") || computePrepareClassDeclaredField.getName().equals("TSum")) {
                    continue;
                }
                if (computePrepareClassDeclaredField.getName().equals("sum")) {
                    // TODO: 2022/8/18
                    // 将结果存入 computePrepare
//                    computePrepare.setSum(itemIdentification);
                    computePrepare.computeSum();
                    continue;
                }
                // 根据反射得到computePrepare的get和set方法
                String featureName = computePrepareClassDeclaredField.getName();
                Character feature = (Character) inputFeatureClass.getDeclaredField(computePrepareClassDeclaredField.getName()).get(inputFeature);
                Method methodGet = computePrepareClass.getDeclaredMethod("get" + featureName, null);
                Method methodSet = computePrepareClass.getDeclaredMethod("set" + featureName, Integer.class);
                // 根据输入feature判定频率是否应该计算100-x
                if (feature == '+') {
                    methodSet.invoke(computePrepare, (Integer) methodGet.invoke(computePrepare, null));
                } else if (feature == '-') {
                    methodSet.invoke(computePrepare, 100 - (Integer) methodGet.invoke(computePrepare, null));
                } else if (feature == '?') {
                    //methodSet.invoke(computePrepare,null);
                    methodSet.invoke(computePrepare, (Integer)1);


                } else {
                    throw new Exception("输入错误，非？-+三个字符中任意一个");
                }

            }

            // TODO: 2022/8/17  鉴定百分率计算

            computeResultIndex = computeResultIndex + 1;
            computePrepareIndex = computePrepareIndex + 1;
            totalFrequency = totalFrequency + computePrepare.getSum();
        }

        // 保存值
        for (int i = 0; i < computeResultList.size(); i++) {
            computeResultList.get(i).setIdentification((float) (computePrepareList.get(i).getSum() / totalFrequency * 100.0));
//             System.out.println("computeResultList"+i+":"+(double)computePrepareList.get(i).getSum()+"/"+totalFrequency+"="+computeResultList.get(i).getIdentification());
        }
    }

    /**
     * @Param: List<ComputePrepare>, InputFeature, List<ComputeResult>
     * @return: void
     * @Author: Xiongruijie
     * @date: 17:10
     * 计算T_Value存入ComputeResultList中
     */
    public void ComputeT_Value(List<ComputePrepare> computePrepareList, InputFeature inputFeature, List<ComputeResult> computeResultList) throws Exception {

        int computePrepareIndex = 0;
        int computeResultIndex = 0;
        for (ComputePrepare computePrepare : computePrepareList) {
            // computePrepareList是整个实验数据库的记录
            // computePrepare是一个菌种的记录
            Class computePrepareClass = computePrepare.getClass();
            Class inputFeatureClass = inputFeature.getClass();
            // 结果列表中取computePrepareIndex同索引的对象，如果不对还需要在改改
            ComputeResult computeResult = computeResultList.get(computePrepareIndex);
            Double itemIdentification = Double.valueOf(1.0);

            Field[] computePrepareClassDeclaredFields = computePrepareClass.getDeclaredFields();
            Field[] inputFeatureClassDeclaredFields = inputFeatureClass.getDeclaredFields();

            //判定Result和ComputePrepare是否为同一个id
            if (!computeResult.getStrainId().equals(computePrepare.getStrain_id())) {
                log.info("StrainId不匹配");
                System.out.println("computeResultID:" + computeResult.getStrainId() + "\n"
                        + "computePrepareID:" + computePrepare.getStrain_id()
                );
            }
            for (Field inputFeatureClassDeclaredField : inputFeatureClassDeclaredFields) {
                inputFeatureClassDeclaredField.setAccessible(true);
            }

            for (Field computePrepareClassDeclaredField : computePrepareClassDeclaredFields) {
                computePrepareClassDeclaredField.setAccessible(true);
                if (computePrepareClassDeclaredField.getName().equals("strain_id") || computePrepareClassDeclaredField.getName().equals("TSum")) {
                    continue;
                }
                if (computePrepareClassDeclaredField.getName().equals("sum")) {
                    continue;
                }
                // 根据反射得到computePrepare的get和set方法
                String featureName = computePrepareClassDeclaredField.getName();
                Character feature = (Character) inputFeatureClass.getDeclaredField(computePrepareClassDeclaredField.getName()).get(inputFeature);
                Method methodGet = computePrepareClass.getDeclaredMethod("get" + featureName, null);
                Method methodSet = computePrepareClass.getDeclaredMethod("set" + featureName, Integer.class);
                // 根据数值判定频率是否应该计算100-x
                if ((Integer) methodGet.invoke(computePrepare, null) <= 50) {
                    methodSet.invoke(computePrepare, 100 - (Integer) methodGet.invoke(computePrepare, null));
                }
            }
            computePrepare.computeTSum();
            computeResultIndex = computeResultIndex + 1;
            computePrepareIndex = computePrepareIndex + 1;
        }
        // 存结果
        for (int i = 0; i < computeResultList.size(); i++) {
            computeResultList.get(i).setT_value((float) (computePrepareList.get(i).getSum() / computePrepareList.get(i).getTSum() * 100.0));
//            System.out.println("computeResultList.TValue("+computePrepareList.get(i).getStrain_id()+"):"+(double)computePrepareList.get(i).getSum()+"/"+computePrepareList.get(i).getTSum() +"="+computeResultList.get(i).getT_value());
        }
    }

    /**
     * @Param: List<ComputeResult> computeResultList
     * @return: void
     * @Author: Xiongruijie
     * @date: 22:13
     * 对ComputeResult排序
     */
    public void sortComputeResult(List<ComputeResult> computeResultList) {
        computeResultList.sort(new Comparator<ComputeResult>() {
            @Override
            public int compare(ComputeResult o1, ComputeResult o2) {
                Float identification1 = o1.getIdentification();
                Float identification2 = o2.getIdentification();
                return identification2.compareTo(identification1);
            }
        });
        computeResultList = computeResultList.subList(0, 5);
    }

    /**
     * @Author: Xiongruijie
     * @Param: List<ComputeResult> computeResultList
     * @return: List<ComputeResult>
     * @Author: Xiongruijie
     * @date: 2022/8/19
     * @time: 23:29
     * @description: 返回鉴定百分率前五的ComputeResult数据
     */
    public List<ComputeResult> getTopFiveNumideResult(List<ComputeResult> computeResultList) {
        List<ComputeResult> topFiveComputeResult = computeResultList.subList(0, 5);
        return topFiveComputeResult;
    }


    /**
     * @Author: Xiongruijie
     * @Param: List<ComputeResult> computeResultList, InputFeature inputFeature
     * @return: Map<BiochemicalTest, InconsistentRecord>
     * @Author: Xiongruijie
     * @date: 2022/8/23
     * @time: 5:27
     * @description: 遍历24个生化反应找到数据库值>75 输入为阴性或者数据库值<25 输入为阳性
     */
    public Map<BiochemicalTest, InconsistentRecord> getInconsistentList(List<ComputeResult> computeResultList, InputFeature inputFeature) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<BiochemicalTest, InconsistentRecord> inconsistentRecordMap = new HashMap<BiochemicalTest, InconsistentRecord>();
        // 创建游标
        int index = 0;
        for (ComputeResult computeResult : computeResultList) {
            // 遍历ResultList
            // 获得当前result的strain_test对象
            StrainTest strainTest = strainTestRepository.getOne(computeResult.getStrainId());
            // 遍历24个生化实验是否有不符合阴/阳的情况
            //            Phe  7
            if ((strainTest.getExperiment7() > 75 & inputFeature.getPhe() == '-') | (strainTest.getExperiment7() < 25 & inputFeature.getPhe() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(7);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(7))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment7())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment7())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Xyl  47
            if ((strainTest.getExperiment47() > 75 & inputFeature.getXyl() == '-') | (strainTest.getExperiment47() < 25 & inputFeature.getXyl() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(47);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(47))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment47())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment47())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Raf  41
            if ((strainTest.getExperiment41() > 75 & inputFeature.getRaf() == '-') | (strainTest.getExperiment41() < 25 & inputFeature.getRaf() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(41);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(41))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment41())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment41())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Ind  1
            if ((strainTest.getExperiment1() > 75 & inputFeature.getInd() == '-') | (strainTest.getExperiment1() < 25 & inputFeature.getInd() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(1);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(1))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment1())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment1())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Suc  45
            if ((strainTest.getExperiment45() > 75 & inputFeature.getSuc() == '-') | (strainTest.getExperiment45() < 25 & inputFeature.getSuc() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(45);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(45))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment45())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment45())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Orn  10
            if ((strainTest.getExperiment10() > 75 & inputFeature.getOrn() == '-') | (strainTest.getExperiment10() < 25 & inputFeature.getOrn() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(10);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(10))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment10())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest
                    );
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment10())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Lac  34
            if ((strainTest.getExperiment34() > 75 & inputFeature.getLac() == '-') | (strainTest.getExperiment34() < 25 & inputFeature.getLac() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(34);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(34))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment34())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment34())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            ONPG  22
            if ((strainTest.getExperiment22() > 75 & inputFeature.getONPG() == '-') | (strainTest.getExperiment22() < 25 & inputFeature.getONPG() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(22);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(22))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment22())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment22())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Ure  6
            if ((strainTest.getExperiment6() > 75 & inputFeature.getUre() == '-') | (strainTest.getExperiment6() < 25 & inputFeature.getUre() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(6);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(6))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment6())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment6())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Cit  4
            if ((strainTest.getExperiment4() > 75 & inputFeature.getCit() == '-') | (strainTest.getExperiment4() < 25 & inputFeature.getCit() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(4);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(4))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment4())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment4())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Malt  35
            if ((strainTest.getExperiment35() > 75 & inputFeature.getMalt() == '-') | (strainTest.getExperiment35() < 25 & inputFeature.getMalt() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(35);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(35))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment35())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment35())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Lys  8
            if ((strainTest.getExperiment8() > 75 & inputFeature.getLys() == '-') | (strainTest.getExperiment8() < 25 & inputFeature.getLys() == '+')) {
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(8);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(8))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment8()));
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment8()));
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Malo  14
            if ((strainTest.getExperiment14() > 75 & inputFeature.getMalo() == '-') | (strainTest.getExperiment14() < 25 & inputFeature.getMalo() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(14);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(14))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment14())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment14())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Sor  44
            if ((strainTest.getExperiment44() > 75 & inputFeature.getSor() == '-') | (strainTest.getExperiment44() < 25 & inputFeature.getSor() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(44);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(44))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment44())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment44())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Dul  30
            if ((strainTest.getExperiment30() > 75 & inputFeature.getDul() == '-') | (strainTest.getExperiment30() < 25 & inputFeature.getDul() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(30);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(30))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment30())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment30())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Ara  27
            if ((strainTest.getExperiment27() > 75 & inputFeature.getAra() == '-') | (strainTest.getExperiment27() < 25 & inputFeature.getAra() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(27);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(27))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment27())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment27())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Mel  38
            if ((strainTest.getExperiment38() > 75 & inputFeature.getMel() == '-') | (strainTest.getExperiment38() < 25 & inputFeature.getMel() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(38);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(38))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment38())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment38())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Rha  42
            if ((strainTest.getExperiment42() > 75 & inputFeature.getRha() == '-') | (strainTest.getExperiment42() < 25 & inputFeature.getRha() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(42);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(42))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment42())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment42())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Esc  15
            if ((strainTest.getExperiment15() > 75 & inputFeature.getEsc() == '-') | (strainTest.getExperiment15() < 25 & inputFeature.getEsc() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(15);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(15))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment15())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment15())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            MR  2
            if ((strainTest.getExperiment2() > 75 & inputFeature.getMR() == '-') | (strainTest.getExperiment2() < 25 & inputFeature.getMR() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(2);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(2))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment2())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment2())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            H2S  5
            if ((strainTest.getExperiment5() > 75 & inputFeature.getH2S() == '-') | (strainTest.getExperiment5() < 25 & inputFeature.getH2S() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(5);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(5))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment5())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment5())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Tre  46
            if ((strainTest.getExperiment46() > 75 & inputFeature.getTre() == '-') | (strainTest.getExperiment46() < 25 & inputFeature.getTre() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(46);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(46))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment46())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment46())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Cel  29
            if ((strainTest.getExperiment29() > 75 & inputFeature.getCel() == '-') | (strainTest.getExperiment29() < 25 & inputFeature.getCel() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(29);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(29))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment29())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment29())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
//            Ox  21
            if ((strainTest.getExperiment21() > 75 & inputFeature.getOx() == '-') | (strainTest.getExperiment21() < 25 & inputFeature.getOx() == '+')) {
                // 改
                BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(21);
                if (!inconsistentRecordMap.containsKey(biochemicalTestRepository.getOne(21))) {
                    // 创建新记录对象
                    InconsistentRecord inconsistentRecord = new InconsistentRecord();
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    inconsistentRecord.setBiochemicalTest(biochemicalTest);
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment21())); // 改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                } else {
                    InconsistentRecord inconsistentRecord = inconsistentRecordMap.get(biochemicalTest);
                    Class inconsistentRecordClass = inconsistentRecord.getClass();
                    Method methodSet = inconsistentRecordClass.getDeclaredMethod("setNum" + index, Integer.class);
                    methodSet.invoke(inconsistentRecord, (strainTest.getExperiment21())); //改
                    inconsistentRecordMap.put(biochemicalTest, inconsistentRecord);
                }
            }
            index += 1;
        }


        return inconsistentRecordMap;
    }

    /**
     * @Author: Xiongruijie
     * @Param:
     * @return:
     * @Author: Xiongruijie
     * @date: 2022/8/23
     * @time: 5:30
     * @description:
     */
    public String getResultEvaluation(List<ComputeResult> computeResultList) {
        List<ComputeResult> top3Result = computeResultList.subList(0, 3);
        // 第一种情况：前三条目族类完全相同
        if ((strainRepository.getOne(top3Result.get(0).getStrainId()).getStrainClass().equals(strainRepository.getOne(top3Result.get(1).getStrainId()).getStrainClass())) & (strainRepository.getOne(top3Result.get(0).getStrainId()).getStrainClass().equals(strainRepository.getOne(top3Result.get(2).getStrainId()).getStrainClass()))) {
            if (top3Result.get(0).getIdentification() < 80) {
                if ((top3Result.get(0).getIdentification() + top3Result.get(1).getIdentification() + top3Result.get(2).getIdentification()) > 80) {
                    return "很好的鉴定结果";
                }
            } else {
                return "很好的鉴定结果";
            }
        }
        // 第二种情况：前三条目族不相同
        if ((top3Result.get(0).getIdentification() >= 95) & (top3Result.get(0).getT_value() >= 75)) {
            return "极好的鉴定结果";
        } else if ((top3Result.get(0).getIdentification() >= 80) & (top3Result.get(0).getT_value() >= 50)) {
            return "很好的鉴定结果";
        } else if ((top3Result.get(0).getIdentification() >= 60) & (top3Result.get(0).getT_value() >= 50)) {
            return "好的鉴定结果";
        } else if ((top3Result.get(0).getIdentification() >= 90) & (top3Result.get(0).getT_value() >= 0) ||
                (top3Result.get(0).getIdentification() >= 80) & (top3Result.get(0).getIdentification() <= 90) & (top3Result.get(0).getT_value() >= 0.01) ||
                (top3Result.get(0).getIdentification() >= 60) & (top3Result.get(0).getIdentification() <= 80) & (top3Result.get(0).getT_value() >= 10)) {
            return "可接受的鉴定结果";
        } else if ((top3Result.get(0).getIdentification() >= 60) & (top3Result.get(0).getIdentification() <= 80) & (top3Result.get(0).getT_value() >= 0.01)) {
            return "可疑的鉴定结果";
        } else if ((top3Result.get(0).getIdentification() < 60) & (top3Result.get(0).getT_value() <= 0.01)) {
            return "不可接受的鉴定结果";
        }


        return "不可接受的鉴定结果";
    }

    /**
     * @Author: Xiongruijie
     * @Param: List<ComputeResult> computeResultList,InputFeature inputFeature
     * @return: List<Supplement>
     * @Author: Xiongruijie
     * @date: 2022/8/25
     * @time: 20:58
     * @description: List<ComputeResult> computeResultList size必须为5
     */
    public Supplement getSupplement(List<ComputeResult> computeResultList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (computeResultList.size() != 5) {
            log.error("错误结果列表大小不为5！");
            return null;
        }

        List<SupplementCompute> supplementComputeList = new ArrayList<>();
        for (ComputeResult computeResult : computeResultList) {
            SupplementCompute supplementCompute = new SupplementCompute();
            supplementCompute.ExtractFeature(strainTestRepository.getOne(computeResult.getStrainId()));
            supplementComputeList.add(supplementCompute);
        }


        // 补充生化反应这里准备只取区分指标最大的第一条实验

        Class<? extends SupplementCompute> supplementComputeClass = SupplementCompute.class;

        List<SupplementResult> supplementResultList = new ArrayList<>();
        for (int i = 1; i <= 47; i++) {
            Method methodGet = supplementComputeClass.getDeclaredMethod("getExperiment" + i, null);
            SupplementResult supplementResult = new SupplementResult();
            // supplementResult是关于5个菌群47个实验补充实验评判标准结果集
            // 设置实验id
            supplementResult.setStrain_id(i);

            for (int j = 0; j < 5; j++) {
                // 第i个实验的第j个结果
                if (supplementResult.getNaN() == true) {
                    continue;
                }
                if ((Character) methodGet.invoke(supplementComputeList.get(j), null) == '?') {
                    supplementResult.setNaN(true);
                } else if ((Character) methodGet.invoke(supplementComputeList.get(j), null) == '+') {
                    if (supplementResult.getPositive() == 0) {
                        supplementResult.setPositive(1);
                    } else {
                        supplementResult.setPositive(supplementResult.getPositive() + 1);
                    }
                } else {
                    if (supplementResult.getNegative() == null) {
                        supplementResult.setNegative(1);
                    } else {
                        supplementResult.setNegative(supplementResult.getNegative() + 1);
                    }
                }
            }
            supplementResult.getValue();
            supplementResultList.add(supplementResult);
        }
//        Collections.sort(supplementResultList);
        supplementResultList.sort(new Comparator<SupplementResult>() {
            @Override
            public int compare(SupplementResult o1, SupplementResult o2) {
                Integer o1Value = o1.getValue();
                Integer o2Value = o2.getValue();
                return o2Value.compareTo(o1Value);
            }
        });
        SupplementResult supplementResult = supplementResultList.get(0);
        Integer topId = supplementResult.getStrain_id();
        Supplement supplement = new Supplement();
        BiochemicalTest biochemicalTest = biochemicalTestRepository.getOne(supplementResult.getStrain_id());
        supplement.setBiochemicalTest(biochemicalTest);

        Method methodGet0 = StrainTest.class.getDeclaredMethod("getExperiment" + topId, null);
        supplement.setNum0((Integer) methodGet0.invoke(strainTestRepository.getOne(computeResultList.get(0).getStrainId())));

        Method methodGet1 = StrainTest.class.getDeclaredMethod("getExperiment" + topId, null);
        supplement.setNum1((Integer) methodGet1.invoke(strainTestRepository.getOne(computeResultList.get(1).getStrainId())));

        Method methodGet2 = StrainTest.class.getDeclaredMethod("getExperiment" + topId, null);
        supplement.setNum2((Integer) methodGet2.invoke(strainTestRepository.getOne(computeResultList.get(2).getStrainId())));

        Method methodGet3 = StrainTest.class.getDeclaredMethod("getExperiment" + topId, null);
        supplement.setNum3((Integer) methodGet3.invoke(strainTestRepository.getOne(computeResultList.get(3).getStrainId())));

        Method methodGet4 = StrainTest.class.getDeclaredMethod("getExperiment" + topId, null);
        supplement.setNum4((Integer) methodGet4.invoke(strainTestRepository.getOne(computeResultList.get(4).getStrainId())));

        return supplement;
    }

    /**
     * @Author: Xiongruijie
     * @Param: InputFeature inputFeature
     * @return: NumideResult numideResult
     * @Author: Xiongruijie
     * @date: 2022/8/22
     * @time: 10:29
     * @description: numide总运算，返回结果集NumideResult
     */
    public NumideResult getNumideResult(InputFeature inputFeature) throws Exception {
        NumideResult numideResult = new NumideResult();
        List<StrainTest> strainTestList = this.findAll();
        strainTestList = PreCompute(strainTestList);
        List<ComputeResult> computeResultList = this.InitComputeResultList(strainTestList);
        List<ComputePrepare> computePrepareList = GenerateComputePrepareList(strainTestList);
        ComputeIdentification(computePrepareList, inputFeature, computeResultList);
        ComputeT_Value(computePrepareList, inputFeature, computeResultList);
        this.sortComputeResult(computeResultList);
        computeResultList = getTopFiveNumideResult(computeResultList);

        // 存结果
        // 第一个结果 存numideResultElementList到NumideResult
        List<NumideResultElement> numideResultElementList = new ArrayList<NumideResultElement>();
        for (ComputeResult computeResult : computeResultList) {
            NumideResultElement numideResultElement = new NumideResultElement();
            numideResultElement.setStrain(strainRepository.getOne(computeResult.getStrainId()));
            numideResultElement.setComputeResult(computeResult);
            numideResultElementList.add(numideResultElement);
        }
        numideResult.setNumideResultElementList(numideResultElementList);

        // 第二个结果 存不一致实验Map到NumideResult
        Map<BiochemicalTest, InconsistentRecord> inconsistentRecordMap = this.getInconsistentList(computeResultList, inputFeature);
        numideResult.setInconsistentRecordMap(inconsistentRecordMap);

        // 第三个结果 存补充实验
        Supplement supplement = new Supplement();
        supplement = getSupplement(computeResultList);
        numideResult.setSupplement(supplement);

        // 第四个结果 存实验评价
        numideResult.setResultEvaluation(this.getResultEvaluation(computeResultList));

        return numideResult;
    }


    public OutputResultVo getOutputResult(InputFeature inputFeature) throws Exception {
        OutputResultVo outputResultVo = new OutputResultVo();
        NumideResult numideResult = this.getNumideResult(inputFeature);
        System.out.println(numideResult);

        List<OutputResultElementVo> outputResultElementList = new ArrayList<>();
        OutputResultElementVo StrainName = new OutputResultElementVo();

        // 英文名
        for (int i = 1; i < 6; i++) {
            Method methodSet = OutputResultElementVo.class.getDeclaredMethod("setElement" + i, String.class);
            Method methodGet = OutputResultElementVo.class.getDeclaredMethod("getElement" + i, null);
            methodSet.invoke(StrainName, numideResult.getNumideResultElementList().get(i - 1).getStrain().getStrainName());
        }
        outputResultElementList.add(StrainName);


        // 中文名
        OutputResultElementVo StrainChName = new OutputResultElementVo();
        for (int i = 1; i < 6; i++) {
            Method methodSet = OutputResultElementVo.class.getDeclaredMethod("setElement" + i, String.class);
            methodSet.invoke(StrainChName, numideResult.getNumideResultElementList().get(i - 1).getStrain().getStrainChName());
        }
        outputResultElementList.add(StrainChName);
        // strainName 设置
        outputResultVo.setStrainName(outputResultElementList);

        // computeValue设置
        List<OutputResultElementVo> computeValue = new ArrayList<>();
        // 鉴定百分数
        OutputResultElementVo identification = new OutputResultElementVo();
        for (int i = 0; i < 6; i++) {
            Method methodSet = OutputResultElementVo.class.getDeclaredMethod("setElement" + i, String.class);
            if (i == 0) {
                methodSet.invoke(identification, "鉴定百分数：");
                continue;
            }
            methodSet.invoke(identification, numideResult.getNumideResultElementList().get(i - 1).getComputeResult().getIdentification().toString() + "%");
        }
        computeValue.add(identification);
        // T值
        OutputResultElementVo T_value = new OutputResultElementVo();
        for (int i = 0; i < 6; i++) {
            Method methodSet = OutputResultElementVo.class.getDeclaredMethod("setElement" + i, String.class);
            if (i == 0) {
                methodSet.invoke(T_value, "T值：");
                continue;
            }
            if (numideResult.getNumideResultElementList().get(i - 1).getComputeResult().getT_value() < 0.01) {
                methodSet.invoke(T_value, "<0.01%");
            } else {
                methodSet.invoke(T_value, numideResult.getNumideResultElementList().get(i - 1).getComputeResult().getT_value().toString() + "%");
            }
        }
        computeValue.add(T_value);
        outputResultVo.setComputeValue(computeValue);

        // inconsistent
        Map<BiochemicalTest, InconsistentRecord> inconsistentRecordMap = numideResult.getInconsistentRecordMap();
        List<OutputResultElementVo> inconsistent = new ArrayList<>();

        for (Map.Entry<BiochemicalTest, InconsistentRecord> entry : inconsistentRecordMap.entrySet()) {
            OutputResultElementVo inconsistentElement = new OutputResultElementVo();
            inconsistentElement.setElement0(entry.getValue().getBiochemicalTest().getBiochemicalCh());
            inconsistentElement.setElement1((entry.getValue().getNum0() != null) ? entry.getValue().getNum0().toString() : null);
            inconsistentElement.setElement2((entry.getValue().getNum1() != null) ? entry.getValue().getNum1().toString() : null);
            inconsistentElement.setElement3((entry.getValue().getNum2() != null) ? entry.getValue().getNum2().toString() : null);
            inconsistentElement.setElement4((entry.getValue().getNum3() != null) ? entry.getValue().getNum3().toString() : null);
            inconsistentElement.setElement5((entry.getValue().getNum4() != null) ? entry.getValue().getNum4().toString() : null);
            inconsistent.add(inconsistentElement);
        }
        outputResultVo.setInconsistent(inconsistent);
        // 补充实验
        List<OutputResultElementVo> supplementList = new ArrayList<>();
        OutputResultElementVo supplement = new OutputResultElementVo();
        Supplement numideResultSupplementsupplement = numideResult.getSupplement();
        supplement.setElement0(numideResultSupplementsupplement.getBiochemicalTest().getBiochemicalCh());
        supplement.setElement1(numideResultSupplementsupplement.getNum0().toString());
        supplement.setElement2(numideResultSupplementsupplement.getNum1().toString());
        supplement.setElement3(numideResultSupplementsupplement.getNum2().toString());
        supplement.setElement4(numideResultSupplementsupplement.getNum3().toString());
        supplement.setElement5(numideResultSupplementsupplement.getNum4().toString());
        supplementList.add(supplement);
        outputResultVo.setSupplement(supplementList);

        //结果评价
        outputResultVo.setResultEvaluation("结果评价: " + numideResult.getResultEvaluation() + ": " + StrainName.getElement1());


        return outputResultVo;
    }

    public InputFeature getInputFeatureFromForm(FormEntity formEntity){
        InputFeature inputFeature = new InputFeature();
        inputFeature.setInd(formEntity.getInd().toCharArray()[0]);
        inputFeature.setSuc(formEntity.getSuc().toCharArray()[0]);
        inputFeature.setOrn(formEntity.getOrn().toCharArray()[0]);
        inputFeature.setLac(formEntity.getLac().toCharArray()[0]);
        inputFeature.setONPG(formEntity.getONPG().toCharArray()[0]);
        inputFeature.setUre(formEntity.getUre().toCharArray()[0]);
        inputFeature.setCit(formEntity.getCit().toCharArray()[0]);
        inputFeature.setMalt(formEntity.getMalt().toCharArray()[0]);
        inputFeature.setLys(formEntity.getLys().toCharArray()[0]);
        inputFeature.setMalo(formEntity.getMalo().toCharArray()[0]);
        inputFeature.setSor(formEntity.getSor().toCharArray()[0]);
        inputFeature.setDul(formEntity.getDul().toCharArray()[0]);
        inputFeature.setAra(formEntity.getAra().toCharArray()[0]);
        inputFeature.setMel(formEntity.getMel().toCharArray()[0]);
        inputFeature.setRha(formEntity.getRha().toCharArray()[0]);
        inputFeature.setEsc(formEntity.getEsc().toCharArray()[0]);
        inputFeature.setMR(formEntity.getMR().toCharArray()[0]);
        inputFeature.setH2S(formEntity.getH2S().toCharArray()[0]);
        inputFeature.setTre(formEntity.getTre().toCharArray()[0]);
        inputFeature.setCel(formEntity.getCel().toCharArray()[0]);
        inputFeature.setOx(formEntity.getOx().toCharArray()[0]);

        return inputFeature;
    }

    public void saveQueryEntity(FormEntity formEntity, OutputResultVo outputResultVo){
        Date d = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");
        System.out.println(s1.format(d));
        //简写格式
        String s = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss").format(new Date());

        QueryEntity queryEntity = new QueryEntity();
        queryEntity.setUserName(formEntity.getUserName());
        queryEntity.setInputDate(s);
        queryEntity.setSampleType(formEntity.getSampleType());
        queryEntity.setSampleSource(formEntity.getSampleSource());
        queryEntity.setRemark(formEntity.getRemark());
        queryEntity.setPhe(formEntity.getPhe());
        queryEntity.setXyl(formEntity.getXyl());
        queryEntity.setRaf(formEntity.getRaf());
        queryEntity.setInd(formEntity.getInd());
        queryEntity.setSuc(formEntity.getSuc());
        queryEntity.setOrn(formEntity.getOrn());
        queryEntity.setLac(formEntity.getLac());
        queryEntity.setONPG(formEntity.getONPG());
        queryEntity.setUre(formEntity.getUre());
        queryEntity.setCit(formEntity.getCit());
        queryEntity.setMalt(formEntity.getMalt());
        queryEntity.setLys(formEntity.getLys());
        queryEntity.setMalo(formEntity.getMalo());
        queryEntity.setSor(formEntity.getSor());
        queryEntity.setDul(formEntity.getDul());
        queryEntity.setAra(formEntity.getAra());
        queryEntity.setMel(formEntity.getMel());
        queryEntity.setRha(formEntity.getRha());
        queryEntity.setEsc(formEntity.getEsc());
        queryEntity.setMR(formEntity.getMR());
        queryEntity.setH2S(formEntity.getH2S());
        queryEntity.setTre(formEntity.getTre());
        queryEntity.setCel(formEntity.getCel());
        queryEntity.setOx(formEntity.getOx());
        queryEntity.setResult(outputResultVo.getResultEvaluation());

        queryRepository.save(queryEntity);
    }



}
