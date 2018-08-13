package com.example.nguyenanhphan.smarttravelver2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenanhphan.smarttravelver2.Common.ItemClickListener;
import com.example.nguyenanhphan.smarttravelver2.Model.KhachSan;
import com.example.nguyenanhphan.smarttravelver2.R;

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
public class AdapterKhachSan extends BaseAdapter{
    private Context context;
    private List<KhachSan> khachSanList;

    public AdapterKhachSan(Context context, List<KhachSan> khachSanList) {
        this.context = context;
        this.khachSanList = khachSanList;
    }

    @Override
    public int getCount() {
        return khachSanList.size();
    }

    @Override
    public Object getItem(int position) {
        return khachSanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return khachSanList.get(position).getMaKhachSan();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item_khach_san,null);
        ImageView img = view.findViewById(R.id.img_khach_san);
        TextView tvTenKhachSan = view.findViewById(R.id.txtTenKhachSan);
        TextView tvGiaPhong = view.findViewById(R.id.txtGiaPhong);

        img.setImageResource(Integer.parseInt(khachSanList.get(position).getImageKs()));
        tvTenKhachSan.setText(khachSanList.get(position).getTenKhachSan());
        tvGiaPhong.setText(khachSanList.get(position).getGiaPhong());
        return view;
    }


}
