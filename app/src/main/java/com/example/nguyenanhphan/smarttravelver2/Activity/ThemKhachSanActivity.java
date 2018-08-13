package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nguyenanhphan.smarttravelver2.Model.KhachSan;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.KhachSan_Model;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemKhachSanActivity extends AppCompatActivity {
    EditText edTenKhachSan, edSoPhongTrong, edKhoangGia, edLongtitude, edlatitude,
             edDiaChi, edSoDienThoai;
    Button btnTaiAnhKs, btnThemKs;
    ImageView imgKhachSan;
    KhachSan_Model db;
    DataBaseHandler mdb;


    int REQUEST_CODE_FOLDER = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khach_san);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgKhachSan = findViewById(R.id.img_khach_san);
        edTenKhachSan =findViewById(R.id.edTen);
        edSoPhongTrong=findViewById(R.id.edSoPhongTrong);
        edKhoangGia=findViewById(R.id.edKhoangGia);
        edLongtitude=findViewById(R.id.edLongtitude);
        edlatitude=findViewById(R.id.edLatitude);
        edDiaChi=findViewById(R.id.edDiaChi);
        edSoDienThoai=findViewById(R.id.edSoDienThoai);
        btnTaiAnhKs=findViewById(R.id.btnTaiAnhKhachSan);
        btnThemKs=findViewById(R.id.btnThemKhachSan);
        mdb = new DataBaseHandler(this);
        db = new KhachSan_Model(mdb);


        btnTaiAnhKs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_PICK);
//                i.setType("image/*");
//                startActivityForResult(i, REQUEST_CODE_FOLDER);
                ActivityCompat.requestPermissions(ThemKhachSanActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_FOLDER
                );
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
               startActivityForResult(i, REQUEST_CODE_FOLDER);
        } else {
            Toast.makeText(this, "Bạn không được phép truy cập thư mục ảnh", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode==REQUEST_CODE_FOLDER && resultCode==RESULT_OK && data!=null){
                Uri uri = data.getData();
                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imgKhachSan.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
    }

    public void addKs(View view){
        String image = String.valueOf(imgKhachSan.getResources());
        String tenKhachSan = edTenKhachSan.getText().toString().trim();
        String soPhongTrong = edSoPhongTrong.getText().toString().trim();
        String khoangGia = edKhoangGia.getText().toString().trim();
        String longTiTude = edLongtitude.getText().toString().trim();
        String laTiTude = edlatitude.getText().toString().trim();
        String diaChi = edDiaChi.getText().toString().trim();
        String soDienThoai = edSoDienThoai.getText().toString().trim();

        if (tenKhachSan.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập tên khách sạn")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if(soPhongTrong.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập số phòng còn trống")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if(khoangGia.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập khoảng giá")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if (longTiTude.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập vào Longtitude")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if (laTiTude.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập vào Latitude")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if (diaChi.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập địa chỉ")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if (soDienThoai.length()==0){
            new AlertDialog.Builder(ThemKhachSanActivity.this)
                    .setMessage("Bạn cần nhập số điện thoại")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else {
            KhachSan khachSan = new KhachSan(tenKhachSan, Integer.parseInt(khoangGia), diaChi,Integer.parseInt(soDienThoai),longTiTude,laTiTude,image,Integer.parseInt(soPhongTrong));
            db.InsertElementKhachSan(khachSan);
            Toast.makeText(this, "Thêm khách sạn thành công!!!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}
