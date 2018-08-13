package com.example.nguyenanhphan.smarttravelver2.Model;

import java.io.Serializable;

/**
 * @author Phạm Công Thành
 * @version 1.0.0
 * @description
 * @created ${Date}
 * @updated ${Date}
 * @modified by
 * @updated on ${Date}
 * @since 1.0
 */
public class RestaurantEntities implements Serializable {
    private int id;
    private String mName;
    private String mPrice;
    private byte[] mImg;
    private String longTiTude;
    private String laTiTude;
    private String address;
    private String sdt;

    public RestaurantEntities() {
    }

    public RestaurantEntities(String mName, String mPrice, byte[] mImg, String longTiTude, String laTiTude, String address, String sdt) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mImg = mImg;
        this.longTiTude = longTiTude;
        this.laTiTude = laTiTude;
        this.address = address;
        this.sdt = sdt;
    }

    public RestaurantEntities(int id, String mName, String mPrice, byte[] mImg, String longTiTude, String laTiTude, String address, String sdt) {
        this.id = id;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mImg = mImg;
        this.longTiTude = longTiTude;
        this.laTiTude = laTiTude;
        this.address = address;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public byte[] getmImg() {
        return mImg;
    }

    public void setmImg(byte[] mImg) {
        this.mImg = mImg;
    }

    public String getLongTiTude() {
        return longTiTude;
    }

    public void setLongTiTude(String longTiTude) {
        this.longTiTude = longTiTude;
    }

    public String getLaTiTude() {
        return laTiTude;
    }

    public void setLaTiTude(String laTiTude) {
        this.laTiTude = laTiTude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
