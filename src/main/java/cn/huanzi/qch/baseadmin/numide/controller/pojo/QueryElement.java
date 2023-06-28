package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * @author:Xiongruijie
 * @create: 2023-06-26 16:01
 * @Description:
 */
@Entity
@Data
@Lazy(value = false)
@Proxy(lazy = false)
@Table(name = "query_element")
public class QueryElement {
    @Id
    Integer query_id;

    @Column(name = "input_number")
    String input_number;

    @Column(name = "file_name")
    String file_name;

    @Column(name = "system_name")
    String system_name;

    public QueryElement(Integer query_id, String input_number, String file_name, String system_name) {
        this.query_id = query_id;
        this.input_number = input_number;
        this.file_name = file_name;
        this.system_name = system_name;
    }

    public QueryElement() {
    }
}
