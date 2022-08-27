package cn.huanzi.qch.baseadmin.numide.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author:Xiongruijie
 * @create: 2022-08-27 17:22
 * @Description: 用于输出到前端的类
 */
@Data
public class OutputResult {
    List<OutputResultElement> strainName;
    List<OutputResultElement> computeValue;
    List<OutputResultElement> inconsistent;
    List<OutputResultElement> supplement;
    String ResultEvaluation;
}
