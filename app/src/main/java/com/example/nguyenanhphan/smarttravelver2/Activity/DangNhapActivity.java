package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.nguyenanhphan.smarttravelver2.R;

public class DangNhapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
    }

    public void OnClickDangKyTaiKhoan(View view) {
        Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
        this.startActivity(intent);
    }


}
