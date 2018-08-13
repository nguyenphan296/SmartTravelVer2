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
public class KhachSan implements Serializable {
    private int maKhachSan;
    private String tenKhachSan;
    private int giaPhong;
    private String diaChi;
    private int hotline;
    private String longitude;
    private String latitude;
    private byte[] imageKs;
    private int soPhongTrong;
    private int maDiaDiem;

    public KhachSan() {

    }

    public KhachSan(int maKhachSan, String tenKhachSan, int giaPhong, String diaChi, int hotline, String longitude, String latitude, byte[] imageKs, int soPhongTrong, int maDiaDiem) {
        this.maKhachSan = maKhachSan;
        this.tenKhachSan = tenKhachSan;
        this.giaPhong = giaPhong;
        this.diaChi = diaChi;
        this.hotline = hotline;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageKs = imageKs;
        this.soPhongTrong = soPhongTrong;
        this.maDiaDiem = maDiaDiem;
    }

    public KhachSan(String tenKhachSan, int giaPhong, String diaChi, int hotline, String longitude, String latitude, byte[] imageKs, int soPhongTrong) {
        this.tenKhachSan = tenKhachSan;
        this.giaPhong = giaPhong;
        this.diaChi = diaChi;
        this.hotline = hotline;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageKs = imageKs;
        this.soPhongTrong = soPhongTrong;
    }

    public int getMaKhachSan() {
        return maKhachSan;
    }

    public void setMaKhachSan(int maKhachSan) {
        this.maKhachSan = maKhachSan;
    }

    public String getTenKhachSan() {
        return tenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        this.tenKhachSan = tenKhachSan;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getHotline() {
        return hotline;
    }

    public void setHotline(int hotline) {
        this.hotline = hotline;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public byte[] getImageKs() {
        return imageKs;
    }

    public void setImageKs(byte[] imageKs) {
        this.imageKs = imageKs;
    }

    public int getSoPhongTrong() {
        return soPhongTrong;
    }

    public void setSoPhongTrong(int soPhongTrong) {
        this.soPhongTrong = soPhongTrong;
    }

    public int getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }
}
