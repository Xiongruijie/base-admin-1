package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;

/**
 * @author:Xiongruijie
 * @create: 2023-06-15 16:50
 * @Description:
 */
@Data
public class BeginEntity {
    private Integer num;
    private String name;


    public BeginEntity(Integer num, String name) {
        this.num = num;
        this.name = name;
    }
}
