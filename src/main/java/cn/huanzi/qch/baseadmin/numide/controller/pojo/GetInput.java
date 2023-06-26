package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:Xiongruijie
 * @create: 2023-06-25 16:45
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetInput {
    Integer num;
    String date;
    String sampleNumber;
    String inputStr;
}
