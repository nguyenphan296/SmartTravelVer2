package com.example.nguyenanhphan.smarttravelver2.SQLite;

import android.database.sqlite.SQLiteDatabase;


public class DbScript {
    public static final String Places = "tbl_Place";

    //COLUMN NAME--------------------------------------
    //TABLE SETTING---------------------------------------
    public static final String COLUMN_PlaceID = "PlaceID";
    public static final String COLUMN_PlaceName = "PlaceName";
    public static final String COLUMN_PlaceImage = "PlaceImage";
    public static final String COLUMN_PlaceDesciption = "PlaceDesciption";
    public static final String COLUMN_PlaceLongtitude = "PlaceLongtitude";
    public static final String COLUMN_PlaceLatitude = "PlaceLattitude";

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
        // creating required tables
        db.execSQL(TABLE_PLACE);
    }

    public static void UpdateTable(SQLiteDatabase db) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Places);

        // create new tables
        CreateTable(db);
    }
}
