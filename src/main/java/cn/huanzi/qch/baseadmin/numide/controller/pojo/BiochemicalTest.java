package cn.huanzi.qch.baseadmin.numide.controller.pojo;


import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
//测试类时加如下注解
@Lazy(value = false)
@Proxy(lazy=false)
@Table(name = "biochemical_test_table")
public class BiochemicalTest {

  @Id
  private Integer biochemicalId;
  private String biochemicalName;
  private String biochemicalShorthand;
  private String biochemicalCh;

}
