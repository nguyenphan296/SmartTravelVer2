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
import com.example.nguyenanhphan.smarttravelver2.Model.Tour;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.KhachSan_Model;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.Tour_Model;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemTourActivity extends AppCompatActivity {
    EditText edTenCongTy, edMoTa, edThoiGian, edGia;
    Button btnTaiAnhTour, btnThemTour;
    ImageView imgTour;
    Tour_Model db;
    DataBaseHandler mdb;


    int REQUEST_CODE_FOLDER = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edTenCongTy=findViewById(R.id.edTenCongTyCungCap);
        edMoTa=findViewById(R.id.edMoTaTour);
        edGia = findViewById(R.id.edGiaTour);
        btnTaiAnhTour=findViewById(R.id.btnTaiAnhTour);
        btnThemTour=findViewById(R.id.btnThemTour2);
        imgTour=findViewById(R.id.img_tour);
        mdb = new DataBaseHandler(this);
        db = new Tour_Model(mdb);

        btnTaiAnhTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(ThemTourActivity.this,
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
                imgTour.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void addTour(View view) {
        String image = String.valueOf(imgTour.getResources());
        String tenCongTy = edTenCongTy.getText().toString().trim();
        String moTa = edMoTa.getText().toString().trim();
        String giaTour = edGia.getText().toString().trim();
        String thoiGian = edThoiGian.getText().toString().trim();


        if (tenCongTy.length()==0){
            new AlertDialog.Builder(ThemTourActivity.this)
                    .setMessage("Bạn cần nhập tên công ty cung cấp")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if(moTa.length()==0){
            new AlertDialog.Builder(ThemTourActivity.this)
                    .setMessage("Bạn cần nhập mô tả tour")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if(giaTour.length()==0){
            new AlertDialog.Builder(ThemTourActivity.this)
                    .setMessage("Bạn cần nhập giá tour")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();
        } else if (thoiGian.length()==0){
            new AlertDialog.Builder(ThemTourActivity.this)
                    .setMessage("Bạn cần nhập thời gian tour")
                    .setCancelable(false)
                    .setNegativeButton("Ok", null)
                    .show();

        } else {
            Tour tour = new Tour(tenCongTy, moTa, Integer.parseInt(giaTour),image,thoiGian);
            db.InsertElement(tour);
            Toast.makeText(this, "Thêm tour thành công!!!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
