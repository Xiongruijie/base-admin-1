package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
//测试类时加如下注解
@Lazy(value = false)
@Proxy(lazy=false)
@Table(name = "strain_test_table")
public class StrainTest implements Cloneable{

  @Id
  private Integer strainId;
  @Column(name = "test_1")
  private Integer experiment1;
  @Column(name = "test_2")
  private Integer experiment2;
  @Column(name = "test_3")
  private Integer experiment3;
  @Column(name = "test_4")
  private Integer experiment4;
  @Column(name = "test_5")
  private Integer experiment5;
  @Column(name = "test_6")
  private Integer experiment6;
  @Column(name = "test_7")
  private Integer experiment7;
  @Column(name = "test_8")
  private Integer experiment8;
  @Column(name = "test_9")
  private Integer experiment9;
  @Column(name = "test_10")
  private Integer experiment10;
  @Column(name = "test_11")
  private Integer experiment11;
  @Column(name = "test_12")
  private Integer experiment12;
  @Column(name = "test_13")
  private Integer experiment13;
  @Column(name = "test_14")
  private Integer experiment14;
  @Column(name = "test_15")
  private Integer experiment15;
  @Column(name = "test_16")
  private Integer experiment16;
  @Column(name = "test_17")
  private Integer experiment17;
  @Column(name = "test_18")
  private Integer experiment18;
  @Column(name = "test_19")
  private Integer experiment19;
  @Column(name = "test_20")
  private Integer experiment20;
  @Column(name = "test_21")
  private Integer experiment21;
  @Column(name = "test_22")
  private Integer experiment22;
  @Column(name = "test_23")
  private Integer experiment23;
  @Column(name = "test_24")
  private Integer experiment24;
  @Column(name = "test_25")
  private Integer experiment25;
  @Column(name = "test_26")
  private Integer experiment26;
  @Column(name = "test_27")
  private Integer experiment27;
  @Column(name = "test_28")
  private Integer experiment28;
  @Column(name = "test_29")
  private Integer experiment29;
  @Column(name = "test_30")
  private Integer experiment30;
  @Column(name = "test_31")
  private Integer experiment31;
  @Column(name = "test_32")
  private Integer experiment32;
  @Column(name = "test_33")
  private Integer experiment33;
  @Column(name = "test_34")
  private Integer experiment34;
  @Column(name = "test_35")
  private Integer experiment35;
  @Column(name = "test_36")
  private Integer experiment36;
  @Column(name = "test_37")
  private Integer experiment37;
  @Column(name = "test_38")
  private Integer experiment38;
  @Column(name = "test_39")
  private Integer experiment39;
  @Column(name = "test_40")
  private Integer experiment40;
  @Column(name = "test_41")
  private Integer experiment41;
  @Column(name = "test_42")
  private Integer experiment42;
  @Column(name = "test_43")
  private Integer experiment43;
  @Column(name = "test_44")
  private Integer experiment44;
  @Column(name = "test_45")
  private Integer experiment45;
  @Column(name = "test_46")
  private Integer experiment46;
  @Column(name = "test_47")
  private Integer experiment47;


  @Override
  public Object clone() throws CloneNotSupportedException {
    StrainTest strainTest = (StrainTest) super.clone();
    return strainTest;
  }
}
