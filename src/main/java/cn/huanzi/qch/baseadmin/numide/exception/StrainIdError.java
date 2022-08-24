package cn.huanzi.qch.baseadmin.numide.exception;


/**
 * @author:Xiongruijie
 * @create: 2022-08-20 08:44
 * @Description: 类中strainid不匹配异常
 */

public class StrainIdError extends Exception{
    public StrainIdError(String message) {
        super(message);
        message = "Strain id 和 ComputeResult id 不匹配！";
    }
}
