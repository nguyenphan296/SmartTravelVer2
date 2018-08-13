package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nguyenanhphan.smarttravelver2.Model.RestaurantEntities;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandlerRestaurant;
import com.example.nguyenanhphan.smarttravelver2.adapter.ListRestaurantAdapter;

import java.util.ArrayList;

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
public class RestaurantsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ListRestaurantAdapter mobjRestaurantAdapter;
    ArrayList<RestaurantEntities> mArrRestaurant;
    public static DataBaseHandlerRestaurant mobjDbHandlerRestaurant;
    public static int id = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurants);
        init();
        mobjDbHandlerRestaurant = new DataBaseHandlerRestaurant(this);
        mArrRestaurant = mobjDbHandlerRestaurant.getAllRestaurant();
        mobjRestaurantAdapter = new ListRestaurantAdapter(this,mArrRestaurant);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mobjRestaurantAdapter);
        clickButtonAddRestaurant();
        mobjRestaurantAdapter.notifyDataSetChanged();
    }

    private void init() {
        recyclerView = findViewById(R.id.list_restaurant);
        Toolbar toolbar = findViewById(R.id.toolbar_list_restaurant);
        floatingActionButton = findViewById(R.id.fabb_add);
    }
    private void clickButtonAddRestaurant(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestaurantsActivity.this,AddRestaurantActivity.class);
                startActivity(intent);
            }
        });
    }

}
