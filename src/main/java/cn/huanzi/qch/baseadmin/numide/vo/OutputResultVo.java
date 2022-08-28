package cn.huanzi.qch.baseadmin.numide.vo;

import lombok.Data;

import java.util.List;

/**
 * @author:Xiongruijie
 * @create: 2022-08-27 17:22
 * @Description: 用于输出到前端的类
 */
@Data
public class OutputResultVo {
    // 菌群中午名
    List<OutputResultElementVo> strainName;
    List<OutputResultElementVo> computeValue;
    List<OutputResultElementVo> inconsistent;
    List<OutputResultElementVo> supplement;
    String ResultEvaluation;
}
