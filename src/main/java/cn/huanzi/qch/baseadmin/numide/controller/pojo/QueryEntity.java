package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author:Xiongruijie
 * @create: 2022-08-31 07:36
 * @Description:
 */
@Data
@Entity
@Table(name = "query")
public class QueryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;
    @Column(name = "user_name")
    String userName;
    @Column(name = "input_date")
    String inputDate;
    @Column(name = "sample_type")
    String sampleType;
    @Column(name = "sample_number")
    String sampleNumber;
    @Column(name = "sample_source")
    String sampleSource;
    String remark;
    String Phe;
    String Xyl;
    String Raf;
    String Ind;
    String Suc;
    String Orn;
    String Lac;
    String ONPG;
    String Ure;
    String Cit;
    String Malt;
    String Lys;
    String Malo;
    String Sor;
    String Dul;
    String Ara;
    String Mel;
    String Rha;
    String Esc;
    String MR;
    String H2S;
    String Tre;
    String Cel;
    String Ox;
    String Result;
}
