package com.example.nguyenanhphan.smarttravelver2.ModelSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyenanhphan.smarttravelver2.Model.KhachSan;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;

import java.util.ArrayList;
import java.util.List;

import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanDiaChi;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanGiaPhong;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanHotline;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanImage;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanLatitude;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanLongtitude;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanMaDiaDiem;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanName;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_KhachSanSoPhongTrong;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.KhachSans;

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
public class KhachSan_Model {
    private DataBaseHandler mdb;

    public KhachSan_Model(DataBaseHandler mdb) {
        this.mdb = mdb;
    }

    public List<KhachSan> getAllElements() {
        List<KhachSan> listKhachSanDetail = new ArrayList<KhachSan>();
        KhachSan objKhachSan = new KhachSan();
        String query = "SELECT  *  FROM "+KhachSans;
        SQLiteDatabase db = mdb.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
              // objKhachSan.setMaKhachSan(Integer.parseInt(cursor.getColumnName(0)));
                objKhachSan.setTenKhachSan(cursor.getString(1));
                objKhachSan.setGiaPhong(Integer.parseInt(cursor.getString(2)));
                objKhachSan.setDiaChi(cursor.getString(3));
                objKhachSan.setHotline(Integer.parseInt(cursor.getString(4)));
                objKhachSan.setLongitude(cursor.getString(5));
                objKhachSan.setLatitude(cursor.getString(6));
                objKhachSan.setImageKs(cursor.getString(7));
                objKhachSan.setSoPhongTrong(Integer.parseInt(cursor.getString(8)));
                objKhachSan.setMaDiaDiem(Integer.parseInt(cursor.getString(9)));

                listKhachSanDetail.add(objKhachSan);
            } while (cursor.moveToNext());
        }
        db.close();
        return listKhachSanDetail;
    }

    public KhachSan getElementById(KhachSan objT) {
        return null;
    }
    public boolean InsertElementKhachSan(KhachSan objT) {
        try {
            SQLiteDatabase db = mdb.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COLUMN_KhachSanName, objT.getTenKhachSan());
            values.put(COLUMN_KhachSanGiaPhong, objT.getGiaPhong());
            values.put(COLUMN_KhachSanDiaChi, objT.getDiaChi());
            values.put(COLUMN_KhachSanHotline, objT.getHotline());
            values.put(COLUMN_KhachSanLongtitude, objT.getLongitude());
            values.put(COLUMN_KhachSanLatitude, objT.getLatitude());
            values.put(COLUMN_KhachSanImage, objT.getImageKs());
            values.put(COLUMN_KhachSanSoPhongTrong, objT.getSoPhongTrong());
            values.put(COLUMN_KhachSanMaDiaDiem,1);
            //Insert new recored
            db.insert(KhachSans, null, values);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean InsertMultilElement(List<KhachSan> lsObjT) {
        return false;
    }

    public int UpdateElement(KhachSan objT) {
        return 0;
    }

    public boolean DeleteElement(KhachSan objT) {
        return false;
    }

    public int CountElements() {
        return 0;
    }
}
