package cn.huanzi.qch.baseadmin.numide.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:Xiongruijie
 * @create: 2022-08-19 19:07
 * @Description: Numide 返回到前端的结果集
 */
@Data
public class NumideResult implements Serializable {
    private List<NumideResultElement> numideResultElementList = null;

    private Map<BiochemicalTest, InconsistentRecord> inconsistentRecordMap = null;
    // 补充生化反应
    private Set<BiochemicalTest> supplement = null;

    private String ResultEvaluation = null;


}

