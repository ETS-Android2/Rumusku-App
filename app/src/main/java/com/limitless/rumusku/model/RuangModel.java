package com.limitless.rumusku.model;

public class RuangModel {
    private String nama, rumus, volume, luasP;
    private int  RuangGambar, RuangGambarIsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRumus() {
        return rumus;
    }

    public void setRumus(String rumus) {
        this.rumus = rumus;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLuasP() {
        return luasP;
    }

    public void setLuasP(String luasP) {
        this.luasP = luasP;
    }

    public int getRuangGambar() {
        return RuangGambar;
    }

    public void setRuangGambar(int ruangGambar) {
        RuangGambar = ruangGambar;
    }

    public int getRuangGambarIsi() {
        return RuangGambarIsi;
    }

    public void setRuangGambarIsi(int ruangGambarIsi) {
        RuangGambarIsi = ruangGambarIsi;
    }
}
