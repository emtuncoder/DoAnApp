package com.example.fragment.ItemsModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fragment.Adapter.SanPhamAdapter;
import com.example.fragment.Model.SanPham;
import com.example.fragment.R;

public class MainItemsActivity extends AppCompatActivity {

    ListView lvSP;
    SanPhamAdapter sanphamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_items);
        addControls();
        loadData();
        addEvents();
    }

    private void addEvents() {
        lvSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = sanphamAdapter.getItem(position);
                Intent intent = new Intent(MainItemsActivity.this, Detail_ItemsActivity.class);
                intent.putExtra("sp",sp);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        sanphamAdapter.add(new SanPham(R.drawable.giay_thuong_dinh,"Giày thượng đình",10,10000));
        sanphamAdapter.add(new SanPham(R.drawable.giay_di_linh,"Giày đi lính",10,10000));
        sanphamAdapter.add(new SanPham(R.drawable.giay_dan_quan,"Giày dân quân",10,10000));
        sanphamAdapter.add(new SanPham(R.drawable.dep_to_ong,"Dép tổ ong",10,10000));
        sanphamAdapter.add(new SanPham(R.drawable.dep_sau_rieng,"Dép sầu riêng",10,10000));
        sanphamAdapter.add(new SanPham(R.drawable.dep_lao,"Dép lào",10,10000));
    }

    private void addControls() {
        lvSP = findViewById(R.id.lvSP);
        sanphamAdapter = new SanPhamAdapter(this,R.layout.items);
        lvSP.setAdapter(sanphamAdapter);
    }
}