package com.example.nguyenanhphan.smarttravelver2.SQLite;

import android.database.sqlite.SQLiteDatabase;


public class DbScript {
    public static final String Places = "tbl_Place";
    public static final String Tours = "tbl_Tour";
    public static final String KhachSans = "tbl_KhachSan";

    //COLUMN NAME--------------------------------------
    //TABLE SETTING---------------------------------------
    public static final String COLUMN_PlaceID = "PlaceID";
    public static final String COLUMN_PlaceName = "PlaceName";
    public static final String COLUMN_PlaceImage = "PlaceImage";
    public static final String COLUMN_PlaceDesciption = "PlaceDesciption";
    public static final String COLUMN_PlaceLongtitude = "PlaceLongtitude";
    public static final String COLUMN_PlaceLatitude = "PlaceLattitude";

    //TABLE TOUR

    public static final String COLUMN_TourID = "TourID";
    public static final String COLUMN_TourTenCongTy = "TenCongTy";
    public static final String COLUMN_TourMoTa = "MoTa";
    public static final String COLUMN_TourThoiGian = "ThoiGian";
    public static final String COLUMN_TourGia = "Gia";
    public static final String COLUMN_TourImage = "TourImage";
    public static final String COLUMN_TourMaDiaDiem = "MaDiaDiem";

    //TABLE KHACHSAN

    public static final String COLUMN_KhachSanID = "KhachSanID";
    public static final String COLUMN_KhachSanName = "TenKhachSan";
    public static final String COLUMN_KhachSanGiaPhong = "GiaPhong";
    public static final String COLUMN_KhachSanDiaChi = "DiaChi";
    public static final String COLUMN_KhachSanHotline = "HotLine";
    public static final String COLUMN_KhachSanLongtitude = "Longtitude";
    public static final String COLUMN_KhachSanLatitude = "Latitude";
    public static final String COLUMN_KhachSanImage = "Gia";
    public static final String COLUMN_KhachSanSoPhongTrong = "SoPhongTrong";
    public static final String COLUMN_KhachSanMaDiaDiem = "MaDiaDiem";


    public static void CreateTable(SQLiteDatabase db) {
        // Todo table create statement TABLE_SETTING
        String TABLE_PLACE = "CREATE TABLE " + Places + "("
                + COLUMN_PlaceID + " INTEGER PRIMARY KEY,"
                + COLUMN_PlaceName + " TEXT,"
                + COLUMN_PlaceImage + " TEXT,"
                + COLUMN_PlaceDesciption + " TEXT,"
                + COLUMN_PlaceLongtitude + " TEXT,"
                + COLUMN_PlaceLatitude + " TEXT"
                + ")";
        // create table khách sạn
        String TABLE_KHACHSAN="CREATE TABLE "+ KhachSans + "("
                + COLUMN_KhachSanID + " INTEGER PRIMARY KEY,"
                + COLUMN_KhachSanName + " TEXT,"
                + COLUMN_KhachSanGiaPhong + " INTEGER,"
                + COLUMN_KhachSanDiaChi + " TEXT,"
                + COLUMN_KhachSanHotline +" INTEGER,"
                + COLUMN_KhachSanLongtitude + " TEXT,"
                + COLUMN_KhachSanLatitude + " TEXT,"
                + COLUMN_KhachSanImage + " TEXT,"
                + COLUMN_KhachSanSoPhongTrong + " INTEGER,"
                + COLUMN_KhachSanMaDiaDiem + " INTEGER"
                + ")";
        String TABLE_TOUR="CREATE TABLE "+ Tours + "("
                + COLUMN_TourID + " INTEGER PRIMARY KEY,"
                + COLUMN_TourTenCongTy + " TEXT,"
                + COLUMN_TourMoTa + "TEXT,"
                + COLUMN_TourThoiGian + "TEXT,"
                + COLUMN_TourGia + "INTEGER,"
                + COLUMN_TourImage +"TEXT,"
                + COLUMN_TourMaDiaDiem + "INTEGER"
                + ")";

        db.execSQL(TABLE_TOUR);
        db.execSQL(TABLE_PLACE);
        db.execSQL(TABLE_KHACHSAN);
    }

    public static void CreateTableTour(SQLiteDatabase db){
        String TABLE_TOUR="CREATE TABLE "+ Tours + "("
                + COLUMN_TourID + " INTEGER PRIMARY KEY,"
                + COLUMN_TourTenCongTy + " TEXT,"
                + COLUMN_TourMoTa + "TEXT,"
                + COLUMN_TourThoiGian + "TEXT,"
                + COLUMN_TourGia + "INTEGER,"
                + COLUMN_TourImage +"TEXT,"
                + COLUMN_TourMaDiaDiem + "INTEGER"
                + ")";

        db.execSQL(TABLE_TOUR);
    }

    public static void CreateTableKhachSan(SQLiteDatabase db){
        String TABLE_KHACHSAN="CREATE TABLE "+ KhachSans + "("
                + COLUMN_KhachSanID + " INTEGER PRIMARY KEY,"
                + COLUMN_KhachSanName + " TEXT,"
                + COLUMN_KhachSanGiaPhong + " INTEGER,"
                + COLUMN_KhachSanDiaChi + " TEXT,"
                + COLUMN_KhachSanHotline +" TEXT,"
                + COLUMN_KhachSanLongtitude + " TEXT,"
                + COLUMN_KhachSanLatitude + " TEXT,"
                + COLUMN_KhachSanImage + " TEXT,"
                + COLUMN_KhachSanSoPhongTrong + " INTEGER,"
                + COLUMN_KhachSanMaDiaDiem + " INTEGER"
                + ")";

        db.execSQL(TABLE_KHACHSAN);
    }

    public static void UpdateTable(SQLiteDatabase db) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Places);

        // create new tables
        CreateTable(db);
    }
    public static void UpdateTableTour(SQLiteDatabase db) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Tours);

        // create new tables
        CreateTable(db);
    }
    public static void UpdateTableKhachSan(SQLiteDatabase db) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + KhachSans);

        // create new tables
        CreateTable(db);
    }
}
