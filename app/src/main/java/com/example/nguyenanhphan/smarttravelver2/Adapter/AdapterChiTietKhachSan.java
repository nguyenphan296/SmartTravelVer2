package com.example.nguyenanhphan.smarttravelver2.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
public class AdapterChiTietKhachSan extends BaseAdapter {
    private Context context;
    private List<KhachSan> khachSanList;


    public AdapterChiTietKhachSan(Context context, List<KhachSan> khachSanList) {
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
        View view = View.inflate(context, R.layout.activity_chi_tiet_khach_san,null);
        ImageView img = view.findViewById(R.id.img_khach_san);
        TextView tvDiaChi = view.findViewById(R.id.txtDiaChi);
        TextView tvSoDienThoai = view.findViewById(R.id.txtSoDienThoai);
        TextView tvSoPhongTrong = view.findViewById(R.id.txtSoPhongTrong);
        TextView tvGiaPhong = view.findViewById(R.id.txtGiaPhong);

        img.setImageResource(Integer.parseInt(khachSanList.get(position).getImageKs()));
        tvDiaChi.setText(khachSanList.get(position).getDiaChi());
        tvSoDienThoai.setText(khachSanList.get(position).getHotline());
        tvSoPhongTrong.setText(khachSanList.get(position).getSoPhongTrong());
        tvGiaPhong.setText(khachSanList.get(position).getGiaPhong());
        return view;
    }
}
