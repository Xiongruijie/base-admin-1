package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * @author:Xiongruijie
 * @create: 2023-06-28 14:59
 * @Description:
 */
@Entity
@Data
@Lazy(value = false)
@Proxy(lazy = false)
@Table(name = "query_detail")
public class QueryDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @Column(name = "system_name")
    String system_name;

    @Column(name = "user_input")
    String user_input;


    @Column(name = "result")
    String result;

    @Column(name = "identity")
    String identity;

    @Column(name = "t_value")
    String t_value;



    @Column(name = "evaluate")
    String evaluate;

    @Column(name = "time")
    String time;

    public QueryDetail(String system_name, String user_input, String result, String identity, String t_value, String evaluate, String time) {
        this.system_name = system_name;
        this.user_input = user_input;
        this.result = result;
        this.identity = identity;
        this.t_value = t_value;
        this.evaluate = evaluate;
        this.time = time;
    }

    public QueryDetail() {

    }
}
