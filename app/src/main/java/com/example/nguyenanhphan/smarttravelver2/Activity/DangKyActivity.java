package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nguyenanhphan.smarttravelver2.Model.Users;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.UserDAO;
import com.example.nguyenanhphan.smarttravelver2.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class DangKyActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword, edtAddress, edtFullname, edtEmail, edtPhone;
    String username, password, fullName, address, email, phone;
    Button btnTaiAnh, btnTao;
    CircleImageView imgAvata;
    UserDAO userDao;


    //   final int REQUEST_TAKE_PHOTO = 123;
    final int REQUEST_CHOOSE_PHOTO = 321;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        init();
        userDao = new UserDAO(this);
        userDao.open();
        userDao.LayDSUser();


//        //Đăng kí cho context menu
//        registerForContextMenu(btnTaiAnh);
        btnTaiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePhoto();
            }
        });

        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = edtUsername.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                fullName = edtFullname.getText().toString().trim();
                address = edtAddress.getText().toString().trim();
                email = edtEmail.getText().toString().trim();
                phone = edtPhone.getText().toString().trim();

                if (username.length() == 0) {
                    new AlertDialog.Builder(DangKyActivity.this)
                            .setMessage("Bạn nhập thiếu Username")
                            .setCancelable(false)
                            .setNegativeButton("Ok", null)
                            .show();
                } else if (password.length() == 0) {
                    new AlertDialog.Builder(DangKyActivity.this)
                            .setMessage("Bạn nhập thiếu Password")
                            .setCancelable(false)
                            .setNegativeButton("Ok", null)
                            .show();
                }
                if (fullName.length() == 0) {
                    new AlertDialog.Builder(DangKyActivity.this)
                            .setMessage("Bạn nhập thiếu Fullname")
                            .setCancelable(false)
                            .setNegativeButton("Ok", null)
                            .show();
                }
                if (address.length() == 0) {
                    new AlertDialog.Builder(DangKyActivity.this)
                            .setMessage("Bạn nhập thiếu Address")
                            .setCancelable(false)
                            .setNegativeButton("Ok", null)
                            .show();
                }
                if (email.length() == 0) {
                    new AlertDialog.Builder(DangKyActivity.this)
                            .setMessage("Bạn nhập thiếu Email")
                            .setCancelable(false)
                            .setNegativeButton("Ok", null)
                            .show();
                }
                if (phone.length() == 0) {
                    new AlertDialog.Builder(DangKyActivity.this)
                            .setMessage("Bạn nhập thiếu Phone")
                            .setCancelable(false)
                            .setNegativeButton("Ok", null)
                            .show();
                } else {
                    Users users = new Users();
                    users.setmUsername(username);
                    users.setmPassword(password);
                    users.setmAddress(address);
                    users.setmFullname(fullName);
                    users.setmPhone(phone);
                    users.setmEmail(email);
                    ImageToByte(imgAvata);

                    boolean ktra = userDao.insertUser(users);
                    if (ktra) {
                        Toast.makeText(DangKyActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
            }
        });
    }

//    //   Khởi tạo Context menu cho nút Tải ảnh gồm Chọn Ảnh và Chụp Ảnh
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.menu_photo, menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }

    //Tạo sự kiện cho nút Tải ảnh với 2 item Chọn ảnh/Chụp ảnh
    public void choosePhoto() {
        Intent intent1 = new Intent(Intent.ACTION_PICK);
        intent1.setType("image/*");
        startActivityForResult(intent1, REQUEST_CHOOSE_PHOTO);
    }

//    public void takePhoto() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
//
//    }

    //Bắt sự kiện cho Chụp ảnhl
//            case R.id.menu_take_photo:
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
//                break;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CHOOSE_PHOTO) {
                try {
                    Uri uriImage = data.getData();
                    InputStream inputStream = getContentResolver().openInputStream(uriImage);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imgAvata.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//            } else if (requestCode == REQUEST_TAKE_PHOTO) {
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                imgAvata.setImageBitmap(bitmap);

            }

        }

    }

    private void init() {
        imgAvata = (CircleImageView) findViewById(R.id.img_avata_user);
        edtUsername = (EditText) findViewById(R.id.edt_them_user);
        edtPassword = (EditText) findViewById(R.id.edt_them_pass);
        edtAddress = (EditText) findViewById(R.id.edt_them_address);
        edtFullname = (EditText) findViewById(R.id.edt_them_fullname);
        edtEmail = (EditText) findViewById(R.id.edt_them_email);
        edtPhone = (EditText) findViewById(R.id.edt_them_phone);
        btnTaiAnh = (Button) findViewById(R.id.btn_taianh);
        btnTao = (Button) findViewById(R.id.btn_tao);

    }

    //Chuyển ảnh sang dạng byte
    public byte[] ImageToByte(ImageView imgView) {
        BitmapDrawable drawable = (BitmapDrawable) imgView.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


}

