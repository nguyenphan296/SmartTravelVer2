package com.example.nguyenanhphan.smarttravelver2.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.nguyenanhphan.smarttravelver2.Activity.RestaurantsActivity;
import com.example.nguyenanhphan.smarttravelver2.Model.RestaurantEntities;

import java.util.ArrayList;

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
public class DataBaseHandlerRestaurant extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "RestaurantDB";
    private static final String TABLE_RESTAURANT = "Restaurants";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_IMG ="image";
    private static final String KEY_LONGTITUDE ="longtitude";
    private static final String KEY_LATITUDE ="latitude";
    private static final String KEY_ADDRESS ="address";
    private static final String KEY_PHONE ="phone";

    public DataBaseHandlerRestaurant(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_RESTAURANT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_PRICE + " TEXT,"
                + KEY_IMG + " BLOB,"
                + KEY_LONGTITUDE + " TEXT,"
                + KEY_LATITUDE + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_PHONE + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<RestaurantEntities> getAllRestaurant(){
        ArrayList<RestaurantEntities> restauranList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_RESTAURANT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                RestaurantEntities restaurant = new RestaurantEntities();
                restaurant.setId(Integer.parseInt(cursor.getString(0)));
                restaurant.setmImg(cursor.getBlob(1));
                restaurant.setmName(cursor.getString(2));
                restaurant.setmPrice(cursor.getString(3));
                restaurant.setLongTiTude(cursor.getString(4));
                restaurant.setLaTiTude(cursor.getString(5));
                restaurant.setAddress(cursor.getString(6));
                restaurant.setSdt(cursor.getString(7));
                restauranList.add(restaurant);
            } while (cursor.moveToNext());
        }
        db.close();

        return restauranList;
    }

    public void Insert_Restaurant(byte[] img,String name,String price, String longTitude, String laTitude,
                              String address, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql ="INSERT INTO " + TABLE_RESTAURANT + " VALUES(null,?,?,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindBlob(1,img);
        statement.bindString(2,name);
        statement.bindString(3,price);
        statement.bindString(4,longTitude);
        statement.bindString(5,laTitude);
        statement.bindString(6,address);
        statement.bindString(7,phone);

        statement.executeInsert();
//        ContentValues values = new ContentValues();

//        values.put(DataBaseHandlerRestaurant.KEY_ID, RestaurantsActivity.id++);
//        values.put(DataBaseHandlerRestaurant.KEY_NAME,retaurant.getmName());
//        values.put(DataBaseHandlerRestaurant.KEY_PRICE,retaurant.getmPrice());
//        values.put(DataBaseHandlerRestaurant.KEY_IMG,retaurant.getmImg());
//        values.put(DataBaseHandlerRestaurant.KEY_LONGTITUDE,retaurant.getLongTiTude());
//        values.put(DataBaseHandlerRestaurant.KEY_LATITUDE,retaurant.getLaTiTude());
//        values.put(DataBaseHandlerRestaurant.KEY_ADDRESS,retaurant.getAddress());
//        values.put(DataBaseHandlerRestaurant.KEY_PHONE,retaurant.getSdt());
//        db.insert(DataBaseHandlerRestaurant.TABLE_RESTAURANT,null,values);
    }
}
