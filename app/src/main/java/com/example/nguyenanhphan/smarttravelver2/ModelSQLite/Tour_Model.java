package com.example.nguyenanhphan.smarttravelver2.ModelSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyenanhphan.smarttravelver2.Model.Place;
import com.example.nguyenanhphan.smarttravelver2.Model.Tour;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;

import java.util.ArrayList;
import java.util.List;

import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceDesciption;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceImage;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceLatitude;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceLongtitude;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceName;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_TourGia;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_TourImage;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_TourMaDiaDiem;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_TourMoTa;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_TourTenCongTy;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_TourThoiGian;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.Places;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.Tours;

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
public class Tour_Model {
    private DataBaseHandler mdb;

    public Tour_Model(DataBaseHandler mdb) {
        this.mdb = mdb;
    }

    public List<Tour> getAllElements() {
        List<Tour> listTourDetail = new ArrayList<Tour>();
        Tour objTour = new Tour();
        String query = "SELECT  * FROM tbl_Tour";
        SQLiteDatabase db = mdb.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                objTour.setMaTour(Integer.parseInt(cursor.getColumnName(0)));
                objTour.setTenCongTy(cursor.getColumnName(1));
                objTour.setDiemDen(cursor.getColumnName(2));
                objTour.setThoiGian(cursor.getColumnName(3));
                objTour.setGia(Integer.parseInt(cursor.getColumnName(4)));
                objTour.setImage(cursor.getColumnName(5));
                objTour.setMaDiaDiem(Integer.parseInt(cursor.getColumnName(6)));

                listTourDetail.add(objTour);
            } while (cursor.moveToNext());
        }
        db.close();
        return listTourDetail;
    }

    public Tour getElementById(Tour objT) {
        return null;
    }
    public boolean InsertElement(Tour objT) {
        try {
            SQLiteDatabase db = mdb.getWritableDatabase();
            ContentValues values = new ContentValues();

            // values.put(COLUMN_VoteDetailID, objT.getVoteDetailId());
            values.put(COLUMN_TourTenCongTy, objT.getTenCongTy());
            values.put(COLUMN_TourMoTa, objT.getDiemDen());
            values.put(COLUMN_TourThoiGian, objT.getThoiGian());
            values.put(COLUMN_TourGia, objT.getGia());
            values.put(COLUMN_TourImage, objT.getImage());

            //Insert new recored
            db.insert(Tours, null, values);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean InsertMultilElement(List<Tour> lsObjT) {
        return false;
    }

    public int UpdateElement(Tour objT) {
        return 0;
    }

    public boolean DeleteElement(Tour objT) {
        return false;
    }

    public int CountElements() {
        return 0;
    }
}