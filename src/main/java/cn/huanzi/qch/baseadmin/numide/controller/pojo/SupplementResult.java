package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;

/**
 * @author:Xiongruijie
 * @create: 2022-08-25 21:58
 * @Description:
 */
@Data
public class SupplementResult {
    private Integer strain_id = null;
    private Integer Positive=0;
    private Integer Negative=0;
    private Boolean NaN=false;
    private Integer Value=null;

//    @Override
//    public int compareTo(SupplementResult o) {
//        return (int) (o.getValue() - this.getValue());
//    }

    public Integer getValue() {

        if (NaN!=true){
            this.Value = (this.Negative * this.Negative) + (this.Positive * this.Positive);

            return this.Value;
        }else {
            this.Value = -1;
            return -1;
        }

    }
}

