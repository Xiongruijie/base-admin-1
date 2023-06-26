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
@Table(name = "system_info")
public class QueryElement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer query_id;

    @Column
    String input_number;
}
