package com.example.libs.Model;

public class TheLoai {
    private Long id;
    private String tentheloai;

    @Override
    public String toString() {
        return tentheloai;
    }

    public TheLoai(){}
    public TheLoai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public Long getMatheloai() {
        return id;
    }

    public void setMatheloai(Long matheloai) {
        id = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }
}
