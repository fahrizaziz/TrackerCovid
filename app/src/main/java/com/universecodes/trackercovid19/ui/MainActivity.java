package com.universecodes.trackercovid19.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.fragment.HistoryFragment;
import com.universecodes.trackercovid19.fragment.IndonesiaFragment;
import com.universecodes.trackercovid19.fragment.NewsFragment;
import com.universecodes.trackercovid19.fragment.WorldFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            WorldFragment worldFragment = new WorldFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.worldfragment,worldFragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.world:
                WorldFragment worldFragment = new WorldFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.worldfragment, worldFragment)
                        .commit();
                return true;
            case R.id.idn:
                IndonesiaFragment indonesiaFragment = new IndonesiaFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.worldfragment, indonesiaFragment)
                        .commit();
                return true;
//            case R.id.news:
//
//                NewsFragment newsFragment = new NewsFragment();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.worldfragment, newsFragment)
//                        .commit();
//                return true;
        }
        return false;
    }
}