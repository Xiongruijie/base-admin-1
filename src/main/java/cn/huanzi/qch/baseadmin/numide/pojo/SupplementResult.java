package cn.huanzi.qch.baseadmin.numide.pojo;

import lombok.Data;

/**
 * @author:Xiongruijie
 * @create: 2022-08-25 21:58
 * @Description:
 */
@Data
public class SupplementResult {
    private Integer Positive=null;
    private Integer Negative=null;
    private Boolean NaN=null;
    private Integer Value=null;

    public Integer getValue() {

        if (NaN!=true){
            this.Value = (this.Negative * this.Negative) + (this.Positive * this.Positive);

            return this.Value;
        }else {
            return -1;
        }

    }
}

