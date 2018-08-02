package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguyenanhphan.smarttravelver2.R;

public class DangKyActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword, edtAddress, edtFullname, edtEmail, edtPhone;
    String username, password, fullName, address, email, phone;
    Button btnTaiAnh, btnTao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        init();

        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = edtUsername.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                fullName = edtFullname.getText().toString().trim();
                address = edtAddress.getText().toString().trim();
                email = edtEmail.getText().toString().trim();
                phone = edtPhone.getText().toString().trim();

                String thongBao = "";
                if (username.equals("")) {
                    thongBao = "Bạn nhập thiếu Username \n";
                } else if (password.equals("")) {
                    thongBao += "Bạn nhập thiếu Password \n";
                } else if (fullName.equals("")) {
                    thongBao += "Bạn nhập thiếu Fullname \n";
                } else if (address.equals("")) {
                    thongBao += "Bạn nhập thiếu Address \n";
                } else if (email.equals("")) {
                    thongBao += "Bạn nhập thiếu Email \n";
                } else if (phone.equals("")) {
                    thongBao += "Bạn nhập thiếu Phone \n";
                } else {

                }

                Toast.makeText(DangKyActivity.this, thongBao, Toast.LENGTH_SHORT).show();

            }
        });

    }



    private void init() {
        edtUsername = (EditText) findViewById(R.id.edt_them_user);
        edtPassword = (EditText) findViewById(R.id.edt_them_pass);
        edtAddress = (EditText) findViewById(R.id.edt_them_address);
        edtFullname = (EditText) findViewById(R.id.edt_them_fullname);
        edtEmail = (EditText) findViewById(R.id.edt_them_email);
        edtPhone = (EditText) findViewById(R.id.edt_them_phone);
        btnTaiAnh = (Button) findViewById(R.id.btn_taianh);
        btnTao = (Button) findViewById(R.id.btn_tao);

    }


}
