package com.sheetal.amigo_thestudybuddy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.sheetal.amigo_thestudybuddy.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedPreferences;
    BottomNavigationView bottomNavigationView;

    CircularFragment circularFragment = new CircularFragment();
    Select_Branch selectBranch = new Select_Branch();
    TrackFragment trackFragment = new TrackFragment();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.sheetal.amigo_thestudybuddy.databinding.ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome.toolbar);
        binding.appBarHome.fab.setOnClickListener(view -> Snackbar.make(view, "Chat", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = binding.drawerLayout;
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Set the Toolbar as the ActionBar
        this.setSupportActionBar(toolbar);
        // Set the navigation icon
        @SuppressLint("UseCompatLoadingForDrawables") Drawable navigationIcon = getResources().getDrawable(R.drawable.drawer);
        int tintColor = getResources().getColor(R.color.white);

        // Apply tint color to the navigation icon
        DrawableCompat.setTint(navigationIcon, tintColor);
        toolbar.setNavigationIcon(navigationIcon);
        NavigationView navigationView = binding.navView;

        // Set click listener for the navigation icon
        toolbar.setNavigationOnClickListener(v -> drawer.openDrawer(GravityCompat.START));

        //Welcome Toast
        sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();

        //menu's clickable
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.app_bar_home);

        //content home
        //bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, selectBranch).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.b_nav_circular:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, circularFragment).commit();
                    getSupportActionBar().setTitle("Circulars");
                    return true;

                case R.id.b_nav_SelectBranch:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selectBranch).commit();
                    getSupportActionBar().setTitle("Select Branch");
                    return true;

                case R.id.b_nav_track:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, trackFragment).commit();
                    getSupportActionBar().setTitle("Track Yourself");
                    return true;
            }
            return false;
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_calender:
                startActivity(new Intent(HomeActivity.this, Calender.class));
                break;
            case R.id.logout: {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, Login.class));
            }
            break;
            case R.id.help:
                break;
            case R.id.nav_settings:
                break;
            case R.id.aboutUs:
                break;

        }
        return true;
    }
}