package com.busbooking.bus.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.busbooking.bus.R;

public class BusList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

    }
    public void loadseat(View v){
        Toast.makeText(BusList.this,"hello",Toast.LENGTH_LONG).show();
        startActivity(new Intent(BusList.this,SelectSeat.class));

    }

}
