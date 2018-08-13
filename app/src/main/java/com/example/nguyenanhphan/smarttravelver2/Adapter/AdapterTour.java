package com.example.nguyenanhphan.smarttravelver2.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenanhphan.smarttravelver2.Model.Tour;
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
public class AdapterTour extends BaseAdapter {
    private Context context;
    private List<Tour> tourList;

    public AdapterTour(Context context, List<Tour> tourList) {
        this.context = context;
        this.tourList = tourList;
    }

    @Override
    public int getCount() {
        return tourList.size();
    }

    @Override
    public Object getItem(int position) {
        return tourList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tourList.get(position).getMaTour();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context,R.layout.item_tour,null);
        ImageView img = view.findViewById(R.id.img_tour);
        TextView tvTenCongTy = view.findViewById(R.id.txtTenCongTy);
        TextView tvDiemDen = view.findViewById(R.id.txtDiemDen);
        TextView tvGiaTour = view.findViewById(R.id.txtGiaTour);

        img.setImageResource(Integer.parseInt(tourList.get(position).getImage()));
        tvTenCongTy.setText(tourList.get(position).getTenCongTy());
        tvDiemDen.setText(tourList.get(position).getDiemDen());
        tvGiaTour.setText(tourList.get(position).getGia());

        return view;
    }
}
