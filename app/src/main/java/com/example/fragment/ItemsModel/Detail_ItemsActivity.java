package com.example.fragment.ItemsModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fragment.Model.SanPham;
import com.example.fragment.R;

public class Detail_ItemsActivity extends AppCompatActivity {
    ImageView imgHinhDetail;
    TextView txtTenSPDetail,txtSoLuongDetail,txtGiaDetail;
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_items);
        addControls();
    }


    private void addControls() {
        imgHinhDetail = findViewById(R.id.imgHinhDetail);
        txtTenSPDetail = findViewById(R.id.txtTenSPDetail);
        txtSoLuongDetail = findViewById(R.id.txtSoLuongDetail);
        txtGiaDetail = findViewById(R.id.txtGiaDetail);
        intent = getIntent();
        SanPham sanPham = (SanPham) intent.getSerializableExtra("sp");
        imgHinhDetail.setImageResource(sanPham.getHinh());
        txtTenSPDetail.setText(sanPham.getTensp());
        txtSoLuongDetail.setText(sanPham.getSoluong()+"");
        txtGiaDetail.setText(sanPham.getGia()+"");

    }
}