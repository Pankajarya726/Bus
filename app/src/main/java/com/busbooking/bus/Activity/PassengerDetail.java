
package com.busbooking.bus.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.busbooking.bus.R;
import java.util.ArrayList;
import java.util.List;

public class PassengerDetail extends AppCompatActivity {
    Spinner sp_boardig,sp_droping;
    Button submit;
    TextView tv_amunt;
    EditText et_name,et_mobile,et_age;
    List <String> drop,pick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_detail);

        sp_boardig=  findViewById(R.id.boarding_point);
        sp_droping = findViewById(R.id.droping_);
        submit = findViewById(R.id.submit);
        tv_amunt = findViewById(R.id.tv_amount);
        et_name = findViewById(R.id.passenger_mobile);
        et_mobile = findViewById(R.id.passenger_mobile);
        et_age = findViewById(R.id.passenger_age);


        pick = new ArrayList<>();
        pick.add("Select Bording Point");
        pick.add("Jhabua Tower Shivshakti Compuund \t 21:00");
        pick.add("Bengali Square Ring Road \t 21:20");
        pick.add("Radisson Hotel Square \t 21:30");
        pick.add("Star Square \t 21:40");
        final ArrayAdapter<String> planAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, pick) {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {

                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){

                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        planAdapter.setDropDownViewResource(R.layout.spinner_item);
        sp_boardig.setAdapter(planAdapter);


        drop= new ArrayList<>();
        drop.add("Select Droping Point");
        drop.add("Alpana Talkies Hamidia Road \t 23:55");
        drop.add("ISBT Bus Stand \t 00:15");
        drop.add("Habibganj Naka \t 00:25");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, drop) {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {

                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){

                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(R.layout.spinner_item);
        sp_droping.setAdapter(adapter);


        int count= getIntent().getIntExtra("seatcount",0);
        Log.d("tag","========="+count);
        Toast.makeText(PassengerDetail.this,count+ "seatSelected",Toast.LENGTH_LONG).show();
        tv_amunt.setText("Payable amount is "+count*400
        );


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
