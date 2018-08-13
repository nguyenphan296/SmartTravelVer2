package com.example.nguyenanhphan.smarttravelver2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nguyenanhphan.smarttravelver2.Common.ItemClickListener;
import com.example.nguyenanhphan.smarttravelver2.Model.RestaurantEntities;
import com.example.nguyenanhphan.smarttravelver2.R;

import java.util.List;

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
public class ListRestaurantAdapter extends RecyclerView.Adapter<ListRestaurantAdapter.MyViewHolder> {
    private Context mContext;
    private List<RestaurantEntities> mRestaurantList;

    public ListRestaurantAdapter(Context mContext, List<RestaurantEntities> mRestaurantList) {
        this.mContext = mContext;
        this.mRestaurantList = mRestaurantList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgRes;
        public TextView nameRes, priceRes;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgRes = itemView.findViewById(R.id.img_avatar_place);
            nameRes = itemView.findViewById(R.id.tv_name_restaurant);
            priceRes = itemView.findViewById(R.id.tv_price_restaurant);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater
                .inflate(R.layout.item_restaurants_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RestaurantEntities restaurant = mRestaurantList.get(position);
        holder.nameRes.setText(restaurant.getmName());
        holder.priceRes.setText(restaurant.getmPrice());
        byte[] avatar = restaurant.getmImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(avatar,0,avatar.length);
        holder.imgRes.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return mRestaurantList.size();
    }

}
