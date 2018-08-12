package com.example.nguyenanhphan.smarttravelver2.ModelSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyenanhphan.smarttravelver2.Model.Place;
import com.example.nguyenanhphan.smarttravelver2.Model.Users;
import com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.ID;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserAddress;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserEmail;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserFullName;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserName;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserPassword;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserPhone;
import static com.example.nguyenanhphan.smarttravelver2.SQLite.CreateDBUsers.COLUMN_UserPhoto;

public class UserDAONew {
    SQLiteDatabase database;
    CreateDBUsers createDBUsers;
    String[] columnUser = {CreateDBUsers.COLUMN_UserID, CreateDBUsers.COLUMN_UserPhoto, CreateDBUsers.COLUMN_UserName,
            CreateDBUsers.COLUMN_UserPassword, CreateDBUsers.COLUMN_UserFullName, CreateDBUsers.COLUMN_UserAddress,
            CreateDBUsers.COLUMN_UserEmail, CreateDBUsers.COLUMN_UserPhone};

    public UserDAONew(Context context) {
        createDBUsers = new CreateDBUsers(context);
    }

    public void open() {
        database = createDBUsers.getWritableDatabase();
    }

    public void close() {
        createDBUsers.close();
    }

    public boolean insertUser(Users user) {
        open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_UserPhoto, user.getmUsername());
        contentValues.put(COLUMN_UserName, user.getmUsername());
        contentValues.put(COLUMN_UserPassword, user.getmUsername());
        contentValues.put(COLUMN_UserAddress, user.getmUsername());
        contentValues.put(COLUMN_UserFullName, user.getmUsername());
        contentValues.put(COLUMN_UserEmail, user.getmUsername());
        contentValues.put(COLUMN_UserPhone, user.getmUsername());
        long id_user = database.insert(CreateDBUsers.TABLE_NAME, null, contentValues);

        if (id_user != 0) {
            close();
            return true;
        } else {
            close();
            return false;
        }

    }

    public List<Users> LayDSUser() {
        List<Users> danhSachUser = new ArrayList<Users>();
        open();

        Cursor cursor = database.query(CreateDBUsers.TABLE_NAME, columnUser, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            int id_user = cursor.getInt(0);
            String avata_user = cursor.getString(1);
            String username_user = cursor.getString(2);
            String password_user = cursor.getString(3);
            String fullname_user = cursor.getString(4);
            String address_user = cursor.getString(5);
            String email_user = cursor.getString(6);
            String phone_user = cursor.getString(7);

            Users users = new Users();
            users.set_id(id_user);
            users.setmPhoto(avata_user);
            users.setmUsername(username_user);
            users.setmPassword(password_user);
            users.setmFullname(fullname_user);
            users.setmAddress(address_user);
            users.setmEmail(email_user);
            users.setmPhone(phone_user);

            danhSachUser.add(users);

            cursor.moveToNext();
        }
        close();
        return danhSachUser;
    }

//    public Users getUserByName(String username) {
//        open();
//        Cursor cursor = database.query(CreateDBUsers.TABLE_NAME, CreateDBUsers.COLUMN_UserName, , null, null, null, null);
//
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        Users users = new Users(cursor. );
//        cursor.close();
//        database.close();
//        return users;
//    }
}
