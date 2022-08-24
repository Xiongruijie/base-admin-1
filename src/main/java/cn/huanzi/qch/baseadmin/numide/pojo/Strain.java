package cn.huanzi.qch.baseadmin.numide.pojo;

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
@Table(name = "strain_table")
public class Strain {

  @Id
  private Integer strainId;
  private String strainName;
  private String strainChName;
  private String strainClass;



}
