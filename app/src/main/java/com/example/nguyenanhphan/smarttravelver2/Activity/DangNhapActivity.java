package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.nguyenanhphan.smarttravelver2.MainActivity;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.Untils.SharedPrefs;

public class DangNhapActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    CheckBox ckbRemember;
    Button btnDangNhap;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;
    public static final String USERNAME = "userName";
    public static final String PASS = "passWord";
    public static final String REMEMBER = "remember";


    @Override
    protected void onStart() {
        super.onStart();
        if (ckbRemember.isChecked()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

        init();
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ckbRemember.isChecked()) {
                    //Lưu thông tin đăng nhập và bỏ qua đăng kí
                    saveData(edtUsername.getText().toString(), edtPassword.getText().toString());
                } else {
                    clearData();
                }
            }
        });
    }

    private void init() {
        edtUsername = (EditText) findViewById(R.id.edt_them_user);
        edtPassword = (EditText) findViewById(R.id.edt_them_user);
        ckbRemember = (CheckBox) findViewById(R.id.ckb_remember);
        btnDangNhap = (Button) findViewById(R.id.btn_dangnhap);
    }

    private void loadData() {
        if (sharedpreferences.getBoolean(REMEMBER, false)) {
            edtUsername.setText(sharedpreferences.getString(USERNAME, ""));
            edtPassword.setText(sharedpreferences.getString(PASS, ""));
            ckbRemember.setChecked(true);
        } else
            ckbRemember.setChecked(false);

    }

    private void clearData() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    private void saveData(String username, String Pass) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USERNAME, username);
        editor.putString(PASS, Pass);
        editor.putBoolean(REMEMBER, ckbRemember.isChecked());
        editor.commit();
    }

    public void OnClickDangKyTaiKhoan(View view) {
        Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
        this.startActivity(intent);
    }


}
