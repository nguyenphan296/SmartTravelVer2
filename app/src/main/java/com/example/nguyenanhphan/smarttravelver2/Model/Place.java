package com.example.nguyenanhphan.smarttravelver2.Model;

import java.io.Serializable;

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 8/1/2018
 * @updated 8/1/2018
 * @modified by
 * @updated on 8/1/2018
 * @since 1.0
 */
public class Place implements Serializable {
    private int iId;
    private String sName;
    private String sImage;
    private String sDescription;
    private String sLongtitude;
    private String sLatitude;

    public Place() {
    }

    public Place(int iId, String sName, String sPrice, String sImage,
                 String sDescription, String sLongtitude, String sLatitude) {
        this.iId = iId;
        this.sName = sName;

        this.sImage = sImage;
        this.sDescription = sDescription;
        this.sLongtitude = sLongtitude;
        this.sLatitude = sLatitude;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getsLongtitude() {
        return sLongtitude;
    }

    public void setsLongtitude(String sLongtitude) {
        this.sLongtitude = sLongtitude;
    }

    public String getsLatitude() {
        return sLatitude;
    }

    public void setsLatitude(String sLatitude) {
        this.sLatitude = sLatitude;
    }
}
