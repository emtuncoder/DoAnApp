package com.example.fragment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CeateDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TiemGiayCu";

    public static final String tbl_NV = "NHANVIEN";
    public static final String tbl_NV_MANV = "MaNV";
    public static final String tbl_NV_TK = "TaiKhoan";
    public static final String tbl_NV_MK = "MatKhau";

    public static final String tbl_KH = "KHACHHANG";
    public static final String tbl_KH_MAKH = "MaKH";
    public static final String tbl_KH_TK = "TaiKhoan";
    public static final String tbl_KH_MK = "MatKhau";

    public static final String tbl_HD = "HOADON";
    public static final String tbl_HD_MHD = "MaHoaDon";
    public static final String tbl_HD_NGAYMUA = "NgayMuaHang";

    public static final String tbl_CTHD = "CHITIETHOADON";
    public static final String tbl_CTHD_SOLUONG = "SoLuong";
    public static final String tbl_CTHD_MAGIAY = "MaGiay";
    public static final String tbl_CTHD_MHD = "MaHoaDon";


    public static final String tbl_SHOES = "Shoes";
    public static final String tbl_SHOES_TINHTRANG = "TinhTrang";
    public static final String tbl_SHOES_HANG = "Hang";
    public static final String tbl_SHOES_GIA = "Gia";
    public static final String tbl_SHOES_MAGIAY = "MaGiay";



    public CeateDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tbl_NV + "(MaNV INTEGER PRIMARY KEY AUTOINCREMENT , TaiKhoan TEXT , MatKhau TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tbl_KH + "(MaKH INTEGER PRIMARY KEY AUTOINCREMENT , TaiKhoan TEXT , MatKhau TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tbl_HD + "(MaHoaDon INTEGER PRIMARY KEY AUTOINCREMENT ,NgayMuaHang TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tbl_CTHD + "(MaHoaDon INTEGER PRIMARY KEY ,SoLuong INTEGER ,MaGiay INTEGER PRIMARY KEY)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tbl_SHOES + "(MaGiay INTEGER PRIMARY KEY AUTOINCREMENT ,Gia INTEGER ,Hang TEXT ,TinhTrang TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + tbl_NV);
        db.execSQL(" DROP TABLE IF EXISTS " + tbl_KH);
        db.execSQL(" DROP TABLE IF EXISTS " + tbl_HD);
        db.execSQL(" DROP TABLE IF EXISTS " + tbl_CTHD);
        db.execSQL(" DROP TABLE IF EXISTS " + tbl_SHOES);
        onCreate(db);
    }
    public  boolean insertUser(String TK,String MK){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tbl_KH_TK , TK);
        values.put(tbl_KH_MK , MK);
        long result = db.insert(tbl_KH,null,values);
        if(result == - 1){
            return false;
        }else{
            return true;
        }
    }
    public boolean checkUser(String username , String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {tbl_KH_MAKH};
        String selection = tbl_KH_TK + "=?" + " and " + tbl_KH_MK + "=?";
        String[] selectionargs = {username, password};
        Cursor cursor = db.query(tbl_KH, columns, selection, selectionargs, null, null, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;
    }
}
