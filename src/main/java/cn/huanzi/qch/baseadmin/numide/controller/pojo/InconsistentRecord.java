package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;

/**
 * @author:Xiongruijie
 * @create: 2022-08-21 17:19
 * @Description: 不一致实验返回（为了返回）
 */
@Data
public class InconsistentRecord {
    private BiochemicalTest biochemicalTest;
    private Integer num0 = null;
    private Integer num1 = null;
    private Integer num2 = null;
    private Integer num3 = null;
    private Integer num4 = null;

}
