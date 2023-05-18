package com.sheetal.amigo_thestudybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class BottomNavigationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    CircularFragment circularFragment=new CircularFragment();
Select_Branch selectBranch=new Select_Branch();
TrackFragment trackFragment=new TrackFragment();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);



//        ListView listView=findViewById(R.id.listView);
//        Spinner spinner=findViewById(R.id.spinner);

        ArrayList<String> branch=new ArrayList<>();

        branch.add("Computer Engineering");
        branch.add("Information Technology");
        branch.add("Artificial Intelligence");
        branch.add("Mechanical Engineering");
//
//        ArrayAdapter<String> arrBranchAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);
//       listView.setAdapter(arrBranchAdapter);
//
//       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           @Override
//           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               spinner.setAdapter((arrBranchAdapter));
//           }
//       });



        bottomNavigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,selectBranch).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.b_nav_circular:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,circularFragment).commit();
                        getSupportActionBar().setTitle("Circulars");
                        return true;

                    case R.id.b_nav_SelectBranch:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,selectBranch).commit();
                        getSupportActionBar().setTitle("Select Branch");
                        return true;

                    case R.id.b_nav_track:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,trackFragment).commit();
                        getSupportActionBar().setTitle("Track Yourself");
                        return true;
                }
                return false;
            }
        });

    }
}