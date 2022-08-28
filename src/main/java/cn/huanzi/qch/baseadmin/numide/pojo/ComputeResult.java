package cn.huanzi.qch.baseadmin.numide.pojo;

import lombok.Data;

@Data
public class ComputeResult {

    private Integer strainId;

    private Float identification = null;

    private Float T_value = null;

//    @Override
//    public int compareTo(ComputeResult o) {
//        return (int) (o.getIdentification() - this.identification);
//    }
}
