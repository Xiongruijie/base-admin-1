package cn.huanzi.qch.baseadmin.numide.pojo;

import cn.huanzi.qch.baseadmin.numide.exception.StrainIdError;
import lombok.Data;

import java.io.Serializable;

@Data
public class NumideResultElement implements Serializable {

    //菌种类
    private Strain strain = null;
    // T值和多项百分数的结果
    private ComputeResult computeResult = null;
    // 不一致实验
    public void checkStrainId()  {
        try {
            if (!strain.getStrainId().equals(computeResult.getStrainId())){
                throw new StrainIdError("");
            }
        } catch (StrainIdError e) {
            System.out.println(e.getMessage());
        }
    }
}

