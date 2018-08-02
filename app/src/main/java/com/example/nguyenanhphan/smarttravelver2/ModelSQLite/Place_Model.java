package com.example.nguyenanhphan.smarttravelver2.ModelSQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;
import com.example.nguyenanhphan.smarttravelver2.Model.Place;

import java.util.ArrayList;
import java.util.List;

import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceDesciption;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceImage;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceLatitude;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceLongtitude;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.COLUMN_PlaceName;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.DbScript.Places;


/**
 * Created by QQ on 3/11/2017.
 */

public class Place_Model {
    private DataBaseHandler mdb;

    public Place_Model(DataBaseHandler mdb) {
        this.mdb = mdb;
    }


    public List<Place> getAllElements() {
        List<Place> lisVoteDetails = new ArrayList<Place>();
        Place objPlace = new Place();
        String query = "SELECT  * FROM tbl_Place";
        SQLiteDatabase db = mdb.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                objPlace.setiId(Integer.parseInt(cursor.getColumnName(0)));
                objPlace.setsName(cursor.getColumnName(1));
                objPlace.setsImage(cursor.getColumnName(2));
                objPlace.setsDescription(cursor.getColumnName(3));
                objPlace.setsLongtitude(cursor.getColumnName(4));
                objPlace.setsLatitude(cursor.getColumnName(5));

                lisVoteDetails.add(objPlace);
            } while (cursor.moveToNext());
        }
        db.close();
        return lisVoteDetails;
    }

    public Place getElementById(Place objT) {
        return null;
    }

    public boolean InsertElement(Place objT) {
        try {
            SQLiteDatabase db = mdb.getWritableDatabase();
            ContentValues values = new ContentValues();

            // values.put(COLUMN_VoteDetailID, objT.getVoteDetailId());
            values.put(COLUMN_PlaceName, objT.getsName());
            values.put(COLUMN_PlaceImage, objT.getsName());
            values.put(COLUMN_PlaceDesciption, objT.getsName());
            values.put(COLUMN_PlaceLongtitude, objT.getsName());
            values.put(COLUMN_PlaceLatitude, objT.getsName());

            //Insert new recored
            db.insert(Places, null, values);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean InsertMultilElement(List<Place> lsObjT) {
        return false;
    }

    public int UpdateElement(Place objT) {
        return 0;
    }

    public boolean DeleteElement(Place objT) {
        return false;
    }

    public int CountElements() {
        return 0;
    }
}
