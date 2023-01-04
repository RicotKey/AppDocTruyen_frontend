package com.example.libs.Model;

public class Chuong {
    private Long id;
    private String sochuong;
    private String tenchuong;
    private String noidung;
    private Long idtruyen;

    public Chuong(){}

    public Chuong(Long id, String sochuong, String tenchuong, String noidung, Long idtruyen) {
        this.id = id;
        this.sochuong = sochuong;
        this.tenchuong = tenchuong;
        this.noidung = noidung;
        this.idtruyen = idtruyen;
    }

    @Override
    public String toString() {
        return sochuong+" "+tenchuong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSochuong() {
        return sochuong;
    }

    public void setSochuong(String sochuong) {
        this.sochuong = sochuong;
    }

    public String getTenchuong() {
        return tenchuong;
    }

    public void setTenchuong(String tenchuong) {
        this.tenchuong = tenchuong;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Long getIdtruyen() {
        return idtruyen;
    }

    public void setIdtruyen(Long idtruyen) {
        this.idtruyen = idtruyen;
    }
}
