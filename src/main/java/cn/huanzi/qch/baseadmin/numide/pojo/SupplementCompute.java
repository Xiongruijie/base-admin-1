package cn.huanzi.qch.baseadmin.numide.pojo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author:Xiongruijie
 * @create: 2022-08-25 20:23
 * @Description: 判断阴阳性
 */
@Data
public class SupplementCompute {
    @Id
    private Integer strainId;

    private Character experiment1;
    private Character experiment2;
    private Character experiment3;
    private Character experiment4;
    private Character experiment5;
    private Character experiment6;
    private Character experiment7;
    private Character experiment8;
    private Character experiment9;
    private Character experiment10;
    private Character experiment11;
    private Character experiment12;
    private Character experiment13;
    private Character experiment14;
    private Character experiment15;
    private Character experiment16;
    private Character experiment17;
    private Character experiment18;
    private Character experiment19;
    private Character experiment20;
    private Character experiment21;
    private Character experiment22;
    private Character experiment23;
    private Character experiment24;
    private Character experiment25;
    private Character experiment26;
    private Character experiment27;
    private Character experiment28;
    private Character experiment29;
    private Character experiment30;
    private Character experiment31;
    private Character experiment32;
    private Character experiment33;
    private Character experiment34;
    private Character experiment35;
    private Character experiment36;
    private Character experiment37;
    private Character experiment38;
    private Character experiment39;
    private Character experiment40;
    private Character experiment41;
    private Character experiment42;
    private Character experiment43;
    private Character experiment44;
    private Character experiment45;
    private Character experiment46;
    private Character experiment47;

    public void ExtractFeature(StrainTest strainTest){
        this.setStrainId(strainTest.getStrainId());
        this.setExperiment1(strainTest.getExperiment1()<=20?'-':(strainTest.getExperiment1()>=80?'+':'?'));
        this.setExperiment2(strainTest.getExperiment2()<=20?'-':(strainTest.getExperiment2()>=80?'+':'?'));
        this.setExperiment3(strainTest.getExperiment3()<=20?'-':(strainTest.getExperiment3()>=80?'+':'?'));
        this.setExperiment4(strainTest.getExperiment4()<=20?'-':(strainTest.getExperiment4()>=80?'+':'?'));
        this.setExperiment5(strainTest.getExperiment5()<=20?'-':(strainTest.getExperiment5()>=80?'+':'?'));
        this.setExperiment6(strainTest.getExperiment6()<=20?'-':(strainTest.getExperiment6()>=80?'+':'?'));
        this.setExperiment7(strainTest.getExperiment7()<=20?'-':(strainTest.getExperiment7()>=80?'+':'?'));
        this.setExperiment8(strainTest.getExperiment8()<=20?'-':(strainTest.getExperiment8()>=80?'+':'?'));
        this.setExperiment9(strainTest.getExperiment9()<=20?'-':(strainTest.getExperiment9()>=80?'+':'?'));
        this.setExperiment10(strainTest.getExperiment10()<=20?'-':(strainTest.getExperiment10()>=80?'+':'?'));
        this.setExperiment11(strainTest.getExperiment11()<=20?'-':(strainTest.getExperiment11()>=80?'+':'?'));
        this.setExperiment12(strainTest.getExperiment12()<=20?'-':(strainTest.getExperiment12()>=80?'+':'?'));
        this.setExperiment13(strainTest.getExperiment13()<=20?'-':(strainTest.getExperiment13()>=80?'+':'?'));
        this.setExperiment14(strainTest.getExperiment14()<=20?'-':(strainTest.getExperiment14()>=80?'+':'?'));
        this.setExperiment15(strainTest.getExperiment15()<=20?'-':(strainTest.getExperiment15()>=80?'+':'?'));
        this.setExperiment16(strainTest.getExperiment16()<=20?'-':(strainTest.getExperiment16()>=80?'+':'?'));
        this.setExperiment17(strainTest.getExperiment17()<=20?'-':(strainTest.getExperiment17()>=80?'+':'?'));
        this.setExperiment18(strainTest.getExperiment18()<=20?'-':(strainTest.getExperiment18()>=80?'+':'?'));
        this.setExperiment19(strainTest.getExperiment19()<=20?'-':(strainTest.getExperiment19()>=80?'+':'?'));
        this.setExperiment20(strainTest.getExperiment20()<=20?'-':(strainTest.getExperiment20()>=80?'+':'?'));
        this.setExperiment21(strainTest.getExperiment21()<=20?'-':(strainTest.getExperiment21()>=80?'+':'?'));
        this.setExperiment22(strainTest.getExperiment22()<=20?'-':(strainTest.getExperiment22()>=80?'+':'?'));
        this.setExperiment23(strainTest.getExperiment23()<=20?'-':(strainTest.getExperiment23()>=80?'+':'?'));
        this.setExperiment24(strainTest.getExperiment24()<=20?'-':(strainTest.getExperiment24()>=80?'+':'?'));
        this.setExperiment25(strainTest.getExperiment25()<=20?'-':(strainTest.getExperiment25()>=80?'+':'?'));
        this.setExperiment26(strainTest.getExperiment26()<=20?'-':(strainTest.getExperiment26()>=80?'+':'?'));
        this.setExperiment27(strainTest.getExperiment27()<=20?'-':(strainTest.getExperiment27()>=80?'+':'?'));
        this.setExperiment28(strainTest.getExperiment28()<=20?'-':(strainTest.getExperiment28()>=80?'+':'?'));
        this.setExperiment29(strainTest.getExperiment29()<=20?'-':(strainTest.getExperiment29()>=80?'+':'?'));
        this.setExperiment30(strainTest.getExperiment30()<=20?'-':(strainTest.getExperiment30()>=80?'+':'?'));
        this.setExperiment31(strainTest.getExperiment31()<=20?'-':(strainTest.getExperiment31()>=80?'+':'?'));
        this.setExperiment32(strainTest.getExperiment32()<=20?'-':(strainTest.getExperiment32()>=80?'+':'?'));
        this.setExperiment33(strainTest.getExperiment33()<=20?'-':(strainTest.getExperiment33()>=80?'+':'?'));
        this.setExperiment34(strainTest.getExperiment34()<=20?'-':(strainTest.getExperiment34()>=80?'+':'?'));
        this.setExperiment35(strainTest.getExperiment35()<=20?'-':(strainTest.getExperiment35()>=80?'+':'?'));
        this.setExperiment36(strainTest.getExperiment36()<=20?'-':(strainTest.getExperiment36()>=80?'+':'?'));
        this.setExperiment37(strainTest.getExperiment37()<=20?'-':(strainTest.getExperiment37()>=80?'+':'?'));
        this.setExperiment38(strainTest.getExperiment38()<=20?'-':(strainTest.getExperiment38()>=80?'+':'?'));
        this.setExperiment39(strainTest.getExperiment39()<=20?'-':(strainTest.getExperiment39()>=80?'+':'?'));
        this.setExperiment40(strainTest.getExperiment40()<=20?'-':(strainTest.getExperiment40()>=80?'+':'?'));
        this.setExperiment41(strainTest.getExperiment41()<=20?'-':(strainTest.getExperiment41()>=80?'+':'?'));
        this.setExperiment42(strainTest.getExperiment42()<=20?'-':(strainTest.getExperiment42()>=80?'+':'?'));
        this.setExperiment43(strainTest.getExperiment43()<=20?'-':(strainTest.getExperiment43()>=80?'+':'?'));
        this.setExperiment44(strainTest.getExperiment44()<=20?'-':(strainTest.getExperiment44()>=80?'+':'?'));
        this.setExperiment45(strainTest.getExperiment45()<=20?'-':(strainTest.getExperiment45()>=80?'+':'?'));
        this.setExperiment46(strainTest.getExperiment46()<=20?'-':(strainTest.getExperiment46()>=80?'+':'?'));
        this.setExperiment47(strainTest.getExperiment47()<=20?'-':(strainTest.getExperiment47()>=80?'+':'?'));
    }
}
