package com.example.nguyenanhphan.smarttravelver2.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nguyenanhphan.smarttravelver2.Activity.ChiTietKhachSanActivity;
import com.example.nguyenanhphan.smarttravelver2.Adapter.AdapterKhachSan;
import com.example.nguyenanhphan.smarttravelver2.Model.KhachSan;
import com.example.nguyenanhphan.smarttravelver2.ModelSQLite.KhachSan_Model;
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
public class FragmentKhachSan extends Fragment {
    public FragmentKhachSan() {

    }

    ListView listView;
    AdapterKhachSan adapterKhachSan;
    List<KhachSan> khachSanList;
    DataBaseHandler mdb;
    KhachSan_Model khachSanModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_khachsan, container, false);
        return view;
    }

    public void init(){
        khachSanList = new ArrayList<>();
        mdb = new DataBaseHandler(getActivity());
        khachSanModel=new KhachSan_Model(mdb);
        khachSanList = khachSanModel.getAllElements();
        adapterKhachSan = new AdapterKhachSan(getActivity(),khachSanList);
        listView.setAdapter(adapterKhachSan);
        adapterKhachSan.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getActivity().findViewById(R.id.lisKhachSan);
        init();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(getContext(), ChiTietKhachSanActivity.class);
//                startActivity(i);
            }
        });
    }
}
