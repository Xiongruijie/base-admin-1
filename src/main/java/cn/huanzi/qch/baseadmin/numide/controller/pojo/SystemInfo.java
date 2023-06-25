package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * @author:Xiongruijie
 * @create: 2023-06-15 13:41
 * @Description:
 */
@Entity
@Data
@Lazy(value = false)
@Proxy(lazy = false)
@Table(name = "system_info")
public class SystemInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer system_num;

    @Column(name = "system_name")
    private String system_name;

    @Column(name = "file_location")
    private String file_location;

    @Column(name = "select_exp")
    private String select_exp;

    public SystemInfo() {
    }

    public SystemInfo(Integer system_num, String system_name, String file_location, String select_exp) {
        this.system_num = system_num;
        this.system_name = system_name;
        this.file_location = file_location;
        this.select_exp = select_exp;
    }
}
