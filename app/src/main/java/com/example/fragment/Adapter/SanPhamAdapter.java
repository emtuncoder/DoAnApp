package com.example.fragment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fragment.Model.SanPham;
import com.example.fragment.R;
import com.example.fragment.fragment.HomeFragment;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resouce;
    public SanPhamAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resouce = resource;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflate = this.context.getLayoutInflater();
        View customView = layoutInflate.inflate(this.resouce,null);
        ImageView imgHinh=customView.findViewById(R.id.imgHinh);
        TextView txtTensp=customView.findViewById(R.id.txtTenSP);
        TextView txtSoluong=customView. findViewById(R.id.txtSoLuong);
        TextView txtDonGia=customView. findViewById(R.id.txtGia);
        SanPham sp=getItem(position);
        imgHinh.setImageResource(sp.getHinh());
        txtTensp.setText(sp.getTensp());
        txtSoluong.setText(sp.getSoluong()+"");
        txtDonGia.setText(sp.getGia()+"");
        return customView;

    }
}
