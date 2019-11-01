package com.example.recycleroption;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisiasi ID dan pemanggilan dari layout
        list = (RecyclerView) findViewById(R.id.recyclerview);

        // mengatur jenis layoutnya, bisa vertical kebawah atau horizontal kesamping
        list.setLayoutManager(new LinearLayoutManager(this));

        // kita membuat variabel baru untuk memanggil dari file RecyclerViewAdapter agar bisa mengambil konten darinya
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.profil){
            startActivity(new Intent(this, ProfilActivity.class));
        } else if (item.getItemId() == R.id.languange) {
            startActivity(new Intent(this, LanguageActivity.class));
        }

        return true;
    }
}
