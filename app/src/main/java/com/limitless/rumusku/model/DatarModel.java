package com.limitless.rumusku.model;

public class DatarModel {
    private String nama, rumus, luas;
    private int DatarGambar,datargambarisi;

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getRumus() {
        return rumus;
    }

    public void setRumus(String rumus) {
        this.rumus = rumus;
    }

    public int getDatargambarisi() {
        return datargambarisi;
    }

    public void setDatargambarisi(int datargambarisi) {
        this.datargambarisi = datargambarisi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDatarGambar() {
        return DatarGambar;
    }

    public void setDatarGambar(int datarGambar) {
        DatarGambar = datarGambar;
    }
}
