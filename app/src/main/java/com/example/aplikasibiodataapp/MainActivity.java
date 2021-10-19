package com.example.aplikasibiodataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView nama, nim, hobi, desc;
    ImageView foto;
    View telepon, email,alamat;

    ArrayList<Data> biodata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();
    }

    public void setData(){
        data1();
        data2();
        data3();
    }

    private void teleponNumber(String nomor){
        try {
            Intent panggil = new Intent(Intent.ACTION_DIAL);
            panggil.setData(Uri.fromParts("tel",nomor,null));
            startActivity(panggil);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "gagal",Toast.LENGTH_SHORT);
        }
    }

    public void teleponOnClick(View view){
        switch (view.getId()){
            case R.id.btnTelepon1:
                teleponNumber(biodata.get(0).getTelepon());
                break;
            case R.id.telepon2:
                teleponNumber(biodata.get(1).getTelepon());
                break;
            case R.id.telepon3:
                teleponNumber(biodata.get(2).getTelepon());
                break;
            default:
                break;
        }
    }

    public void emailOnClick(View view){
        // membuat variable dan class intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        // set isi email ke text biasa
        intent.setType("text/plain");
        // set alamat email
        switch (view.getId()){
            case R.id.email1:
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {biodata.get(0).getEmail()});
                break;
            case R.id.email2:
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {biodata.get(1).getEmail()});
                break;
            case R.id.email3:
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {biodata.get(2).getEmail()});
                break;
            default:
                break;
        }

        try {
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subEmail));
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.isiEmail));
            startActivity(intent);
        }catch (android.content.ActivityNotFoundException e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "gagal",Toast.LENGTH_SHORT);
        }
    }

    public void mapsOnClick(View v){
        String uri = null;
        switch (v.getId()){
            case R.id.alamat1:
                uri = String.format(Locale.ENGLISH, "geo:"+biodata.get(0).getAlamat()+"?q="+biodata.get(0).getAlamat());
                break;
            case R.id.alamat2:
                uri = String.format(Locale.ENGLISH, "geo:"+biodata.get(1).getAlamat()+"?q="+biodata.get(1).getAlamat());
                break;
            case R.id.alamat3:
                uri = String.format(Locale.ENGLISH, "geo:"+biodata.get(2).getAlamat()+"?q="+biodata.get(2).getAlamat());
                break;
            default:
                break;
        }
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "gagal",Toast.LENGTH_SHORT);
        }

    }

    private void data1(){
        nama = findViewById(R.id.txtNama1);
        nim = findViewById(R.id.txtNim1);
        hobi = findViewById(R.id.txtHobi1);
        desc = findViewById(R.id.txtDesc1);
        foto = findViewById(R.id.imgProfil1);
        alamat = findViewById(R.id.alamat1);
        email = findViewById(R.id.email1);
        telepon = findViewById(R.id.btnTelepon1);

        Data data1 = new Data(BitmapFactory.decodeResource(getResources(), R.drawable.fotodeni),
                "Deni Gunawan S", "A11.2019.12026", "Bersepeda",
                "saya berusia 19 th, saat ini semester 5 dan tinggal di purwodadi",
                "081228380711", "denig6727@gmail.com", "-7.082909, 111.145543");

        nama.setText(data1.getNama());
        nim.setText(data1.getNim());
        hobi.setText(data1.getHobi());
        desc.setText(data1.getDesc());
        foto.setImageBitmap(data1.getProfilPic());
        biodata.add(data1);
    }

    private void data2(){
        nama = findViewById(R.id.txtNama2);
        nim = findViewById(R.id.txtNim2);
        hobi = findViewById(R.id.txtHobi2);
        desc = findViewById(R.id.txtDesc2);
        foto = findViewById(R.id.imgProfil2);
        alamat = findViewById(R.id.alamat2);
        email = findViewById(R.id.email2);
        telepon = findViewById(R.id.telepon2);

        Data data2 = new Data(BitmapFactory.decodeResource(getResources(), R.drawable.fotoalif),
                "Alif Farha Maulana", "A11.2019.12018", "Memelihara ikan",
                "saya berusia 20 th, semeter 5, punya ternak ikan di semarang, selain itu saya juga punya angkringan",
                "089542886425", "aliffarhamaulana@gmail.com", "-6.979071, 110.399707");

        nama.setText(data2.getNama());
        nim.setText(data2.getNim());
        hobi.setText(data2.getHobi());
        desc.setText(data2.getDesc());
        foto.setImageBitmap(data2.getProfilPic());
        biodata.add(data2);
    }

    private void data3(){
        nama = findViewById(R.id.txtNama3);
        nim = findViewById(R.id.txtNim3);
        hobi = findViewById(R.id.txtHobi3);
        desc = findViewById(R.id.txtDesc3);
        foto = findViewById(R.id.imgProfil3);
        alamat = findViewById(R.id.alamat3);
        email = findViewById(R.id.email3);
        telepon = findViewById(R.id.telepon3);

        Data data3 = new Data(BitmapFactory.decodeResource(getResources(), R.drawable.fotowahyu),
                "Wahyu Widi Widayat", "A11.2019.12052", "bermain game",
                "saya berusia 20 th, semester 5 dan tinggal di surabaya",
                "081229365146", "wahyuwidi@gmail.com", "-7.065526, 110.875377");

        nama.setText(data3.getNama());
        nim.setText(data3.getNim());
        hobi.setText(data3.getHobi());
        desc.setText(data3.getDesc());
        foto.setImageBitmap(data3.getProfilPic());
        biodata.add(data3);
    }
}