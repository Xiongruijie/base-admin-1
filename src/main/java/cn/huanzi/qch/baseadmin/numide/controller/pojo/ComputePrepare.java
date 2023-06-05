package cn.huanzi.qch.baseadmin.numide.controller.pojo;

import lombok.Data;

@Data
public class ComputePrepare {
    private Integer strain_id;
    private Integer Phe = null;
    private Integer Xyl = null;
    private Integer Raf = null;
    private Integer Ind = null;
    private Integer Suc = null;
    private Integer Orn = null;
    private Integer Lac = null;
    private Integer ONPG = null;
    private Integer Ure = null;
    private Integer Cit = null;
    private Integer Malt = null;
    private Integer Lys = null;
    private Integer Malo = null;
    private Integer Sor = null;
    private Integer Dul = null;
    private Integer Ara = null;
    private Integer Mel = null;
    private Integer Rha = null;
    private Integer Esc = null;
    private Integer MR = null;
    private Integer H2S = null;
    private Integer Tre = null;
    private Integer Cel = null;
    private Integer Ox = null;
    private Double sum;
    private Double TSum;

    public void computeSum() {
        this.sum = (double) 1;
        if (this.getPhe() != null) {
            this.sum *= (double) this.getPhe(); //90

        }
        if (this.getXyl() != null) {
            this.sum *= (double) this.getXyl(); //8190
        }
        if (this.getRaf() != null) {
            this.sum *= (double) this.getRaf(); //728910
        }
        if (this.getInd() != null) {
            this.sum *= (double) this.getInd(); //72162090
        }
        if (this.getSuc() != null) {
            this.sum *= (double) this.getSuc(); //70718848
        }
        if (this.getOrn() != null) {
            this.sum *= (double) this.getOrn();  //70011659
        }
        if (this.getLac() != null) {
            this.sum *= (double) this.getLac();  //70011659
        }
        if (this.getONPG() != null) {
            this.sum *= (double) this.getONPG();  //70011659
        }
        if (this.getUre() != null) {
            this.sum *= (double) this.getUre();  //6931154
        }
        if (this.getCit() != null) {
            this.sum *= (double) this.getCit();//679253
        }
        if (this.getMalt() != null) {
            this.sum *= (double) this.getMalt();//6724605
        }
        if (this.getLys() != null) {
            this.sum *= (double) this.getLys();
        }
        if (this.getMalo() != null) {
            this.sum *= (double) this.getMalo();
        }
        if (this.getSor() != null) {
            this.sum *= (double) this.getSor();
        }
        if (this.getDul() != null) {
            this.sum *= (double) this.getDul();
        }
        if (this.getAra() != null) {
            this.sum *= (double) this.getAra();
        }
        if (this.getMel() != null) {
            this.sum *= (double) this.getMel();
        }
        if (this.getRha() != null) {
            this.sum *= (double) this.getRha();
        }
        if (this.getEsc() != null) {
            this.sum *= (double) this.getEsc();
        }
        if (this.getMR() != null) {
            this.sum *= (double) this.getMR();
        }
        if (this.getH2S() != null) {
            this.sum *= (double) this.getH2S();
        }
        if (this.getTre() != null) {
            this.sum *= (double) this.getTre();
        }
        if (this.getCel() != null) {
            this.sum *= (double) this.getCel();
        }
        if (this.getOx() != null) {
            this.sum *= (double) this.getOx();
        }
    }

    public void computeTSum() {
        this.TSum = 1.0;
        if (this.getPhe() != null) {
            this.TSum *= (this.Phe > 50) ? this.Phe : 100 - this.Phe;
        }
        if (this.getXyl() != null) {
            this.TSum *= (this.Xyl > 50) ? this.Xyl : 100 - this.Xyl;
        }
        if (this.getRaf() != null) {
            this.TSum *= (this.Raf > 50) ? this.Raf : 100 - this.Raf;
        }
        if (this.getInd() != null) {
            this.TSum *= (this.Ind > 50) ? this.Ind : 100 - this.Ind;
        }
        if (this.getSuc() != null) {
            this.TSum *= (this.Suc > 50) ? this.Suc : 100 - this.Suc;
        }
        if (this.getOrn() != null) {
            this.TSum *= (this.Orn > 50) ? this.Orn : 100 - this.Orn;
        }
        if (this.getLac() != null) {
            this.TSum *= (this.Lac > 50) ? this.Lac : 100 - this.Lac;
        }
        if (this.getONPG() != null) {
            this.TSum *= (this.ONPG > 50) ? this.ONPG : 100 - this.ONPG;
        }
        if (this.getUre() != null) {
            this.TSum *= (this.Ure > 50) ? this.Ure : 100 - this.Ure;
        }
        if (this.getCit() != null) {
            this.TSum *= (this.Cit > 50) ? this.Cit : 100 - this.Cit;
        }
        if (this.getMalt() != null) {
            this.TSum *= (this.Malt > 50) ? this.Malt : 100 - this.Malt;
        }
        if (this.getLac() != null) {
            this.TSum *= (this.Lys > 50) ? this.Lys : 100 - this.Lys;
        }
        if (this.getMalo() != null) {
            this.TSum *= (this.Malo > 50) ? this.Malo : 100 - this.Malo;
        }
        if (this.getSor() != null) {
            this.TSum *= (this.Sor > 50) ? this.Sor : 100 - this.Sor;
        }
        if (this.getDul() != null) {
            this.TSum *= (this.Dul > 50) ? this.Dul : 100 - this.Dul;
        }
        if (this.getAra() != null) {
            this.TSum *= (this.Ara > 50) ? this.Ara : 100 - this.Ara;
        }
        if (this.getMel() != null) {
            this.TSum *= (this.Mel > 50) ? this.Mel : 100 - this.Mel;
        }
        if (this.getRha() != null) {
            this.TSum *= (this.Rha > 50) ? this.Rha : 100 - this.Rha;
        }
        if (this.getEsc() != null) {
            this.TSum *= (this.Esc > 50) ? this.Esc : 100 - this.Esc;
        }
        if (this.getMR() != null) {
            this.TSum *= (this.MR > 50) ? this.MR : 100 - this.MR;
        }
        if (this.getH2S() != null) {
            this.TSum *= (this.H2S > 50) ? this.H2S : 100 - this.H2S;
        }
        if (this.getTre() != null) {
            this.TSum *= (this.Tre > 50) ? this.Tre : 100 - this.Tre;
        }
        if (this.getCel() != null) {
            this.TSum *= (this.Cel > 50) ? this.Cel : 100 - this.Cel;
        }
        if (this.getOx() != null) {
            this.TSum *= (this.Ox > 50) ? this.Ox : 100 - this.Ox;
        }
    }
}

