package com.example.nguyenanhphan.smarttravelver2.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDBUsers extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "USERS_Smart_Travel";
    public static final String TABLE_NAME = "USERS";

    public static final String COLUMN_UserID = "_id";
    public static final String COLUMN_UserPhoto = "UserImage";
    public static final String COLUMN_UserName = "UserName";
    public static final String COLUMN_UserPassword = "UserPassword";
    public static final String COLUMN_UserFullName = "UserFullName";
    public static final String COLUMN_UserAddress = "UserAddress";
    public static final String COLUMN_UserEmail = "UserEmail";
    public static final String COLUMN_UserPhone = "UserPhone";

    public CreateDBUsers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_USER = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_UserID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + COLUMN_UserPhoto + " BLOB NOT NUll,"
                + COLUMN_UserName + " TEXT NOT NUll,"
                + COLUMN_UserPassword + " TEXT NOT NUll,"
                + COLUMN_UserFullName + " TEXT NOT NUll,"
                + COLUMN_UserAddress + " TEXT NOT NUll,"
                + COLUMN_UserEmail + " TEXT NOT NUll,"
                + COLUMN_UserPhone + " TEXT NOT NUll"
                + ")";
        // creating required tables
        sqLiteDatabase.execSQL(TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
