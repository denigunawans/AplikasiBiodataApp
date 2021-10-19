package com.example.aplikasibiodataapp;

import android.graphics.Bitmap;

public class Data {
    private Bitmap profilPic;
    private String nama;
    private String nim;
    private String hobi;
    private String desc;
    private String telepon;
    private String email;
    private String alamat;

    public Data(Bitmap profilPic, String nama, String nim, String hobi, String desc, String telepon, String email, String alamat) {
        this.profilPic = profilPic;
        this.nama = nama;
        this.nim = nim;
        this.hobi = hobi;
        this.desc = desc;
        this.telepon = telepon;
        this.email = email;
        this.alamat = alamat;
    }

    public Bitmap getProfilPic() {
        return profilPic;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getHobi() {
        return hobi;
    }

    public String getDesc() {
        return desc;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }
}
