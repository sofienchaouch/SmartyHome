package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    String s1[] , s2[];
    int images[] = {R.drawable.livingroom,R.drawable.mediaroom,R.drawable.bathroom,R.drawable.bedroom};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String message = intent.getStringExtra("name");

        TextView welcome = findViewById(R.id.welcome);
        welcome.setText("Welcome, "+message+" !");

        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        TextView todayDate = findViewById(R.id.date_today);
        todayDate.setText(date_n);

        recyclerView = findViewById(R.id.recycleView);
        s1 =  getResources().getStringArray(R.array.rooms_names);
        s2 =  getResources().getStringArray(R.array.nbr_devices);

        RoomsRecycleViewAdapter roomsRecycleViewAdapter = new RoomsRecycleViewAdapter(this,s1,s2,images);
        recyclerView.setAdapter(roomsRecycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}