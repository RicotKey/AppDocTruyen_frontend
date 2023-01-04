package com.example.libs.Model;

import java.io.Serializable;

import java.util.Date;


public class Truyen implements Serializable {
    private Long id;
    private String tentruyen;
    private String hinh;
    private String tacgia;
    private String mota;
    private Date ngaydang;
    private Date ngaycapnhat;
    private boolean trangthai;

    public Truyen(){}
    public Truyen(String tentruyen, String hinh, String tacgia, String mota, Date ngaydang, Date ngaycapnhat, boolean trangthai) {
        this.tentruyen = tentruyen;
        this.hinh = hinh;
        this.tacgia = tacgia;
        this.mota = mota;
        this.ngaydang = ngaydang;
        this.ngaycapnhat = ngaycapnhat;
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Truyen{" +
                "tentruyen='" + tentruyen + '\'' +
                ", tacgia='" + tacgia + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }



    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Date getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(Date ngaydang) {
        this.ngaydang = ngaydang;
    }

    public Date getNgaycapnhat() {
        return ngaycapnhat;
    }

    public void setNgaycapnhat(Date ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
}
