package com.example.nguyenanhphan.smarttravelver2.Model;

import java.io.Serializable;

public class Users implements Serializable {
    int _id;
    String mPhoto;
    String mUsername;
    String mPassword;
    String mFullname;
    String mAddress;
    String mEmail;
    String mPhone;

    public Users() {
    }

    public Users(String mPhoto, String mUsername, String mPassword, String mFullname, String mAddress, String mEmail, String mPhone) {
        this.mPhoto = mPhoto;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mFullname = mFullname;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
    }

    public Users(int _id, String mPhoto, String mUsername, String mPassword,
                 String mFullname, String mAddress, String mEmail, String mPhone) {
        this._id = _id;
        this.mPhoto = mPhoto;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mFullname = mFullname;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmFullname() {
        return mFullname;
    }

    public void setmFullname(String mFullname) {
        this.mFullname = mFullname;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
