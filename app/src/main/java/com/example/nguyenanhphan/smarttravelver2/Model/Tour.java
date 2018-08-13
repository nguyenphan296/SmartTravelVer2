package com.example.nguyenanhphan.smarttravelver2.Model;

import java.io.Serializable;

/**
 * @author Nguyễn Đức Cảnh
 * @version 1.0.0
 * @description
 * @desc BKHN
 * @created ${Date}
 * @updated ${Date}
 * @modified by
 * @updated on ${Date}
 * @since 1.0
 */
public class Tour implements Serializable {
    private int maTour;
    private String tenCongTy;
    private String diemDen;
    private int gia;
    private String image;
    private int maDiaDiem;
    private String thoiGian;

    public Tour() {
    }

    public Tour(int maTour, String tenCongTy, String diemDen, int gia, String image, int maDiaDiem, String thoiGian) {
        this.maTour = maTour;
        this.tenCongTy = tenCongTy;
        this.diemDen = diemDen;
        this.gia = gia;
        this.image = image;
        this.maDiaDiem = maDiaDiem;
        this.thoiGian = thoiGian;
    }

    public Tour(String tenCongTy, String diemDen, int gia, String image, String thoiGian) {
        this.tenCongTy = tenCongTy;
        this.diemDen = diemDen;
        this.gia = gia;
        this.image = image;
        this.thoiGian = thoiGian;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getMaTour() {
        return maTour;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }
}
