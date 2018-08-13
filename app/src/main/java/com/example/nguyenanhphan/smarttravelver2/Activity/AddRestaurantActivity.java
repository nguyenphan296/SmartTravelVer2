package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nguyenanhphan.smarttravelver2.Model.RestaurantEntities;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandlerRestaurant;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
public class AddRestaurantActivity extends AppCompatActivity {
    ImageView imgView;
    Button btnuploadImg,btnaddRes;
    EditText edtName,edtPrice,edtLongtitude,edtLatitude,edtAddress,edtPhone;
    int REQUEST_CODE_FOLDER = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_restaurant_layout);
        init();
        btnuploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });
    }
    public void add(View view){
        // chuyển hình ảnh về dạng byte code
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imgView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
        byte[] imgRes = byteArray.toByteArray();

        String resName = edtName.getText().toString();
        String resPrice = edtPrice.getText().toString();
        String resLongtitude = edtLongtitude.getText().toString();
        String resLatitude = edtLatitude.getText().toString();
        String resAddress = edtAddress.getText().toString();
        String resPhone = edtPhone.getText().toString();

        if(resName.length()==0){
            new AlertDialog.Builder(AddRestaurantActivity.this)
                    .setMessage("Bạn cần nhập tên nhà hàng")
                    .setCancelable(false)
                    .setNegativeButton("ok",null)
                    .show();
        } else if(resPrice.length()==0){
            new AlertDialog.Builder(AddRestaurantActivity.this)
                    .setMessage("Bạn cần nhập giá trung bình nhà hàng")
                    .setCancelable(false)
                    .setNegativeButton("ok",null)
                    .show();
        } else if(resLongtitude.length()==0){
            new AlertDialog.Builder(AddRestaurantActivity.this)
                    .setMessage("Bạn cần nhập kinh độ của nhà hàng")
                    .setCancelable(false)
                    .setNegativeButton("ok",null)
                    .show();
        } else if(resLatitude.length()==0){
            new AlertDialog.Builder(AddRestaurantActivity.this)
                    .setMessage("Bạn cần nhập vĩ độ của nhà hàng")
                    .setCancelable(false)
                    .setNegativeButton("ok",null)
                    .show();
        } else if(resAddress.length()==0){
            new AlertDialog.Builder(AddRestaurantActivity.this)
                    .setMessage("Bạn cần nhập địa chỉ nhà hàng")
                    .setCancelable(false)
                    .setNegativeButton("ok",null)
                    .show();
        } else if(resPhone.length()==0){
            new AlertDialog.Builder(AddRestaurantActivity.this)
                    .setMessage("Bạn cần nhập số Đt nhà hàng")
                    .setCancelable(false)
                    .setNegativeButton("ok",null)
                    .show();
        } else {
//            RestaurantEntities restaurant = new RestaurantEntities(resName,resPrice,imgRes,resLongtitude,resLatitude,
//                    resAddress,resPhone);
            RestaurantsActivity.mobjDbHandlerRestaurant.Insert_Restaurant(imgRes,resName,resPrice,resLongtitude,resLatitude,
                    resAddress,resPhone);
            Toast.makeText(this, "Thêm nhà hàng thành công!!!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddRestaurantActivity.this,RestaurantsActivity.class));
            finish();
        }
    }

    private void init() {
        imgView         = findViewById(R.id.img_avatar_restaurant);
        btnuploadImg    = findViewById(R.id.btn_image_restaurant);
        edtName         = findViewById(R.id.edt_name_restaurant);
        edtPrice        = findViewById(R.id.edt_price_restaurant);
        edtLongtitude   = findViewById(R.id.edt_longtidue_restaurant);
        edtLatitude     = findViewById(R.id.edt_latitude_restaurant);
        edtAddress      = findViewById(R.id.edt_address_restaurant);
        edtPhone        = findViewById(R.id.edt_phone_restaurant);
        btnaddRes       = findViewById(R.id.btn_create_restaurant);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data!=null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
