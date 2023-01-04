package com.example.libs.Model;

public class TruyenTheLoai {
    private Long id;

    private Long idtheloai;
    public TruyenTheLoai() {
    }

    public TruyenTheLoai(Long id, Long idtheloai) {
        this.id = id;
        this.idtheloai = idtheloai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(Long idtheloai) {
        this.idtheloai = idtheloai;
    }
}
