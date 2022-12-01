package com.example.labo8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Button button = findViewById(R.id.buttonCUS)

        ArrayList<Banane> bananes = new ArrayList<Banane>();
        bananes.add(new Banane(R.string.unitercm, R.string.V18 ));
        bananes.add(new Banane(R.string.unitermm, R.string.v180 ));
        bananes.add(new Banane(R.string.uniterdm, R.string.V1_8 ));
        bananes.add(new Banane(R.string.uniterm, R.string.V_18 ));
        bananes.add(new Banane(R.string.uniterpouces, R.string.V7_1 ));

        RecyclerView recyclerView = findViewById(R.id.idrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));/**/
        recyclerView.setAdapter(new CustomAdapter(bananes,this));

    }


}