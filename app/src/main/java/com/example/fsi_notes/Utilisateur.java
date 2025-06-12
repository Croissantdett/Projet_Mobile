package com.example.fsi_notes;

public class Utilisateur {
    private int idUti;
    private String nomUti;
    private String preUti;
    private String telUti ;
    private String mailUti;
    private String nomMaitapp ;
    private String preMaitapp;
    private String telMaitapp ;
    private String mailMaitapp;
    private String nomEnt ;
    private String adrEnt ;
    private String vilEnt ;
    private int cpEnt ;
    private String nomTut;
    private String preTut;
    private String telTut;
    private String mailTut;
    private String datVisBil1;
    private float notEntBil1 ;
    private float notDosBil1 ;
    private float notOrBil1;
    private float moyBil1;
    private String remBil1;
    private String datVisBil2;
    private float notDossBil2;
    private float notOrBil2;
    private float moyBil2;
    private String remBil2;


    public int getId() {
        return idUti;
    }

    public void setId(int idUti) {
        this.idUti = idUti;
    }

    public String getNomUti() {
        return nomUti;
    }

    public void setNomUti(String nomUti) {
        this.nomUti = nomUti;
    }

    public String getPreUti() {
        return preUti;
    }

    public void setPreUti(String preUti) {
        this.preUti = preUti;
    }

    public String getTelUti() {
        return telUti;
    }

    public void setTelUti(String telUti) {
        this.telUti = telUti;
    }

    public String getMailUti() {
        return mailUti;
    }

    public void setMailUti(String mailUti) {
        this.mailUti = mailUti;
    }

    public String getNomMaitapp() {
        return nomMaitapp;
    }

    public void setNomMaitapp(String nomMaitapp) {
        this.nomMaitapp = nomMaitapp;
    }

    public String getPreMaitapp() {
        return preMaitapp;
    }

    public void setPreMaitapp(String preMaitapp) {
        this.preMaitapp = preMaitapp;
    }

    public String getTelMaitapp() {
        return telMaitapp;
    }

    public void setTelMaitapp(String telMaitapp) {
        this.telMaitapp = telMaitapp;
    }

    public String getMailMaitapp() {
        return mailMaitapp;
    }

    public void setMailMaitapp(String mailMaitapp) {
        this.mailMaitapp = mailMaitapp;
    }

    public String getNomEnt() {
        return nomEnt;
    }

    public void setNomEnt(String nomEnt) {
        this.nomEnt = nomEnt;
    }

    public String getAdrEnt() {
        return adrEnt;
    }

    public void setAdrEnt(String adrEnt) {
        this.adrEnt = adrEnt;
    }

    public String getVilEnt() {
        return vilEnt;
    }

    public void setVilEnt(String vilEnt) {
        this.vilEnt = vilEnt;
    }

    public int getCpEnt() {
        return cpEnt;
    }

    public void setCpEnt(int cpEnt) {
        this.cpEnt = cpEnt;
    }

    public String getNomTut() {
        return nomTut;
    }

    public void setNomTut(String nomTut) {
        this.nomTut = nomTut;
    }

    public String getPreTut() {
        return preTut;
    }

    public void setPreTut(String preTut) {
        this.preTut = preTut;
    }


    public String getTelTut() {
        return telTut;
    }

    public void setTelTut(String telTut) {
        this.telTut = telTut;
    }

    public String getMailTut() {
        return mailTut;
    }

    public void setMailTut(String mailTut) {
        this.mailTut = mailTut;
    }


    public String getDatVisBil1() {
        return datVisBil1;
    }

    public void setDatVisBil1(String datVisBil1) {
        this.datVisBil1 = datVisBil1;
    }

    public float getNotEntBil1() {
        return notEntBil1;
    }

    public void setNotEntBil1(float notEntBil1) {
        this.notEntBil1 = notEntBil1;
    }

    public float getNotDosBil1() {
        return notDosBil1;
    }

    public void setNotDosBil1(float notDosBil1) {
        this.notDosBil1 = notDosBil1;
    }

    public float getNotOrBil1() {
        return notOrBil1;
    }

    public void setNotOrBil1(float notOrBil1) {
        this.notOrBil1 = notOrBil1;
    }

    public float getMoyBil1() {
        return moyBil1;
    }

    public void setMoyBil1(float moyBil1) {
        this.moyBil1 = moyBil1;
    }

    public String getRemBil1() {
        return remBil1;
    }

    public void setRemBil1(String remBil1) {
        this.remBil1 = remBil1;
    }


    public String getDatVisBil2() {
        return datVisBil2;
    }

    public void setDatVisBil2(String datVisBil2) {
        this.datVisBil2 = datVisBil2;
    }

    public float getNotDossBil2() {
        return notDossBil2;
    }

    public void setNotDossBil2(float notDossBil2) {
        this.notDossBil2 = notDossBil2;
    }

    public float getNotOrBil2() {
        return notOrBil2;
    }

    public void setNotOrBil2(float notOrBil2) {
        this.notOrBil2 = notOrBil2;
    }

    public float getMoyBil2() {
        return moyBil2;
    }

    public void setMoyBil2(float moyBil2) {
        this.moyBil2 = moyBil2;
    }

    public String getRemBil2() {
        return remBil2;
    }

    public void setRemBil2(String remBil2) {
        this.remBil2 = remBil2;
    }


    public Utilisateur(int idUti, String nomUti, String preUti, String telUti,String mailUti,  String nomMaitApp, String preMaitApp, String telMaitapp, String mailMaitapp, String nomEnt, String adrEnt, String vilEnt, int cpEnt, String nomTut, String preTut, String telTut, String mailTut,String datVisBil1, float notEntBil1, float notDosBil1, float notOrBil1, float moyBil1, String remBil1, String datVisBil2, float notDossBil2, float notOrBil2,float  moyBil2, String remBil2) {

        this.idUti = idUti;
        this.nomUti = nomUti;
        this.preUti = preUti;
        this.telUti = telUti;
        this.mailUti = mailUti;
        this.nomMaitapp = nomMaitApp;
        this.preMaitapp = preMaitApp;
        this.telMaitapp = telMaitapp;
        this.mailMaitapp = mailMaitapp;
        this.nomEnt = nomEnt;
        this.adrEnt = adrEnt;
        this.vilEnt = vilEnt;
        this.cpEnt = cpEnt;
        this.nomTut = nomTut;
        this.preTut = preTut;
        this.telTut = telTut;
        this.mailTut = mailTut;
        this.datVisBil1 = datVisBil1;
        this.notEntBil1 = notEntBil1;
        this.notDosBil1 = notDosBil1;
        this.notOrBil1 = notOrBil1;
        this.moyBil1 = moyBil1;
        this.remBil1 = remBil1;
        this.datVisBil2 = datVisBil2;
        this.notDossBil2 = notDossBil2;
        this.notOrBil2 = notOrBil2;
        this.moyBil2 = moyBil2;
        this.remBil2 = remBil2;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + idUti +
                ", nomUti='" + nomUti + '\'' +
                ", preUti='" + preUti + '\'' +
                ", telUti='" + telUti + '\'' +
                ", mailUti='" + mailUti + '\'' +
                ", nomMaitApp='" + nomMaitapp + '\'' +
                ", preMaitApp='" + preMaitapp + '\'' +
                ", telMaitapp='" + telMaitapp + '\'' +
                ", mailMaitapp='" + mailMaitapp + '\'' +
                ", nomEnt='" + nomEnt + '\'' +
                ", adrEnt='" + adrEnt + '\'' +
                ", vilEnt='" + vilEnt + '\'' +
                ", cpEnt=" + cpEnt +
                ", nomTut='" + nomTut + '\'' +
                ", preTut='" + preTut + '\'' +
                ", telTut='" + telTut + '\'' +
                ", mailTut='" + mailTut + '\'' +
                ", datVisBil1='" + datVisBil1 + '\'' +
                ", notEntBil1=" + notEntBil1  +
                ", notDosBil1=" + notDosBil1 +
                ", notOrBil1=" + notOrBil1 +
                ", moyBil1='" + moyBil1 + '\'' +
                ", remBil1='" + remBil1 + '\'' +
                ", datVisBil2='" + datVisBil2 + '\'' +
                ", notDossBil2=" + notDossBil2 +
                ", notOrBil2=" + notOrBil2 +
                ", moyBil2='" + moyBil2 + '\'' +
                ", remBil2='" + remBil2 + '\'' +
                '}';
    }
}
