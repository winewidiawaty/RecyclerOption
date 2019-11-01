package com.example.recycleroption;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import static com.example.recycleroption.R.*;

public class DetailActivity extends AppCompatActivity {

    // deklarasi dan inisiasi variabel umum/global
    ImageView imggambar;
    TextView txtdetail;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_detail);
        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        // pemanggilan ID dari layout activity_detail.xml
        imggambar = findViewById(id.imgdetail);
        txtdetail = findViewById(id.txtdetail);

        // intent ini fungsinya adalah untuk menerima data dari RecyclerViewAdapter
        Intent terimadata = getIntent();
        String nm = terimadata.getStringExtra("Nama");
        Objects.requireNonNull(getSupportActionBar()).setTitle(nm);
        imggambar.setImageResource(terimadata.getIntExtra("IMG", 1)); //angka satu itu menandakan bahwasannya nilai dari si integer (gak harus angka 1)
        txtdetail.setText(terimadata.getStringExtra("DET"));

        // berfungsi untuk menampilkan icon back (kembali) di pojok kiri atas
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // bagian ini tidak perlu diubah
        FloatingActionButton fab = findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}