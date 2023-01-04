package com.example.libs.Model;

public class User {

    private Long id;
    private String tenuser;
    private String matkhau;
    private String hinh;
    private String email;
    private boolean trangthai;

    public User(String tenuser, String matkhau, String hinh, String email, boolean trangthai) {
        this.tenuser = tenuser;
        this.matkhau = matkhau;
        this.hinh = hinh;
        this.email = email;
        this.trangthai = trangthai;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenuser() {
        return tenuser;
    }

    public void setTenuser(String tenuser) {
        this.tenuser = tenuser;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
}
