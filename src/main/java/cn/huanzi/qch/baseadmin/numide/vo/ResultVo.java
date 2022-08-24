package cn.huanzi.qch.baseadmin.numide.vo;

import cn.huanzi.qch.baseadmin.annotation.Like;
import cn.huanzi.qch.baseadmin.numide.pojo.NumideResultElement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultVo implements Serializable {

    @Like
    private String resultName;

    /*
    * 前五个菌种的结果集
    * */
    private List<NumideResultElement> numideResultList;

    /*
     * 最终结果评价
     * */
    private String evaluate;
}
