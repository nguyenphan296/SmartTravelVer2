package com.example.nguyenanhphan.smarttravelver2.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.nguyenanhphan.smarttravelver2.Activity.ActivityAllService;
import com.example.nguyenanhphan.smarttravelver2.Activity.ChiTietKhachSanActivity;
import com.example.nguyenanhphan.smarttravelver2.Activity.ThemTourActivity;
import com.example.nguyenanhphan.smarttravelver2.Adapter.AdapterKhachSan;
import com.example.nguyenanhphan.smarttravelver2.Adapter.AdapterTour;
import com.example.nguyenanhphan.smarttravelver2.Model.KhachSan;
import com.example.nguyenanhphan.smarttravelver2.Model.Tour;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.KhachSan_Model;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.Tour_Model;
import com.example.nguyenanhphan.smarttravelver2.R;
import com.example.nguyenanhphan.smarttravelver2.SQLite.DataBaseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyễn Đức Cảnh
 * @version 1.0.0
 * @description
 * @desc BKHN
 * @created ${Date}
 * @updated ${Date}
 * @modified by
 * @updated on ${Date}
 * @since 1.0
 */
public class FragmentTour extends android.support.v4.app.Fragment {
    ListView listView;
    AdapterTour adapterTour;
    List<Tour> tourList;
    DataBaseHandler mdb;
    Tour_Model tour_model;
    Button btnThemTour;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tour, container, false);
        return view;
    }
    public void init(){
        tourList = new ArrayList<>();
        mdb = new DataBaseHandler(getActivity());
        tour_model=new Tour_Model(mdb);
        tourList = tour_model.getAllElements();
        adapterTour = new AdapterTour(getActivity(),tourList);
        listView.setAdapter(adapterTour);
        adapterTour.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getActivity().findViewById(R.id.lisTour);
        btnThemTour=getActivity().findViewById(R.id.btnThemTour);
        btnThemTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ThemTourActivity.class);
                startActivity(i);
            }
        });
        init();

    }


}
