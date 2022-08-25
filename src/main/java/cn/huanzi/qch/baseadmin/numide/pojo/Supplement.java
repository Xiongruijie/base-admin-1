package cn.huanzi.qch.baseadmin.numide.pojo;

import lombok.Data;

/**
 * @author:Xiongruijie
 * @create: 2022-08-25 19:54
 * @Description: 补充生化数据
 */
@Data
public class Supplement {
    private BiochemicalTest biochemicalTest;
    private Integer num0 = null;
    private Integer num1 = null;
    private Integer num2 = null;
    private Integer num3 = null;
    private Integer num4 = null;
}
