package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.nguyenanhphan.smarttravelver2.R;

public class DangKyActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword, edtAddress, edtFullname, edtEmail, edtPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        init();

    }

    private void init() {
        edtUsername = (EditText) findViewById(R.id.edt_them_user);
        edtPassword = (EditText) findViewById(R.id.edt_them_pass);
        edtAddress = (EditText) findViewById(R.id.edt_them_address);
        edtFullname = (EditText) findViewById(R.id.edt_them_fullname);
        edtEmail = (EditText) findViewById(R.id.edt_them_email);
        edtPhone = (EditText) findViewById(R.id.edt_them_phone);

        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String fullName = edtFullname.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
    }
}
