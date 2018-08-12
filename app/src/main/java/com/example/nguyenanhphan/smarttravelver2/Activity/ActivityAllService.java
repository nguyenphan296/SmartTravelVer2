package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.nguyenanhphan.smarttravelver2.R;

public class ActivityAllService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //Không hiện tiêu đề
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Hiện nút back
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_all_service);
    }
}
