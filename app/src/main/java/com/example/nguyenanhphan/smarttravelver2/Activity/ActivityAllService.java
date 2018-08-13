package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.nguyenanhphan.smarttravelver2.Adapter.AdapterKhachSan;
import com.example.nguyenanhphan.smarttravelver2.Adapter.AdapterPager;
import com.example.nguyenanhphan.smarttravelver2.Fragment.FragmentKhachSan;
import com.example.nguyenanhphan.smarttravelver2.Fragment.FragmentNhaHang;
import com.example.nguyenanhphan.smarttravelver2.Fragment.FragmentTaxi;
import com.example.nguyenanhphan.smarttravelver2.Fragment.FragmentTour;
import com.example.nguyenanhphan.smarttravelver2.Model.KhachSan;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.KhachSan_Model;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ActivityAllService extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    AdapterPager adapter;
    Button btnThemKhachSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiện nút back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_all_service);
        init();
        initViewPager();
    }


    private void initViewPager() {
        adapter = new AdapterPager(getSupportFragmentManager());
        adapter.add_Fragment(new FragmentTour(),"Tour");
        adapter.add_Fragment(new FragmentKhachSan(), "Khách sạn");
        adapter.add_Fragment(new FragmentNhaHang(),"Nhà hàng");
        adapter.add_Fragment(new FragmentTaxi(), "Taxi");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        btnThemKhachSan = findViewById(R.id.btnThemKs);
    }



    public void ThemKhachSan(View view){
        Intent i = new Intent(ActivityAllService.this,ThemKhachSanActivity.class);
        startActivity(i);
    }
}
