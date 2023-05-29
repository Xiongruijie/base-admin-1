package cn.huanzi.qch.baseadmin.numide.service;

//import cn.huanzi.qch.baseadmin.numide.vo.QueryVo;

import cn.huanzi.qch.baseadmin.numide.controller.pojo.*;
import cn.huanzi.qch.baseadmin.numide.vo.OutputResultVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


public interface NumideService  {

    List<StrainTest> findAll();

    StrainTest findOne(Integer index);

    List<ComputeResult> InitComputeResultList(List<StrainTest> strainTestList);

    public void sortComputeResult(List<ComputeResult> computeResultList);

    public Map<BiochemicalTest, InconsistentRecord> getInconsistentList(List<ComputeResult> computeResultList, InputFeature inputFeature) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    public NumideResult getNumideResult(InputFeature inputFeature) throws Exception;

    public OutputResultVo getOutputResult(InputFeature inputFeature) throws Exception;

    public InputFeature getInputFeatureFromForm(FormEntity formEntity);
    public void saveQueryEntity(FormEntity formEntity, OutputResultVo outputResultVo);


}
