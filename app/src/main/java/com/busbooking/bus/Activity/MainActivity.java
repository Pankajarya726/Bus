package com.busbooking.bus.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.busbooking.bus.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tv_journy_date;
    Button btn_today,bt_tomorrow,bt_Search;
    private SimpleDateFormat dateFormatter;
    AutoCompleteTextView et_from,et_to;
    ImageView iv_calander;
    String date = "";
    List<String> city,state;
    private DatePickerDialog fromDatePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_journy_date = findViewById(R.id.date);
        iv_calander  =findViewById(R.id.calander);
        btn_today = findViewById(R.id.bttoday);
        bt_tomorrow = findViewById(R.id.bttomorrow);
        bt_Search = findViewById(R.id.btn_search);
        et_from = findViewById(R.id.et_from);
        et_to = findViewById(R.id.et_to);
        obj_list();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, city);

        et_from.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, city);
        et_to.setAdapter(adapter1);

        getDate();
        btn_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate();
            }
        });

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        tv_journy_date.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
        tv_journy_date.requestFocus();
        iv_calander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date1 =  selectdate();
                tv_journy_date.setText(date1);
            }
        });



        bt_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,BusList.class));

            }
        });
    }
    private String selectdate() {

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
               date =  dateFormatter.format(newDate.getTime());

            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        fromDatePickerDialog.show();
        return date;
    }
    private void getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate =mdformat.format(calendar.getTime());
        Log.d("tage","date is" +strDate);
        tv_journy_date.setText(strDate);
    }

    public String getJson() {
        String json = null;
        try {
            // Opening cities.json file
            InputStream is = getAssets().open("cities.json");
            // is there any content in the file
            int size = is.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            is.read(buffer);
            // close the stream --- very important
            is.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return json;
        }
        return json;
    }

    void obj_list()
    {
        city = new ArrayList<String>();
        // sta = new ArrayList<String>();
        // Exceptions are returned by JSONObject when the object cannot be created
        try
        {
            // Convert the string returned to a JSON object
            JSONObject jsonObject=new JSONObject(getJson());
            // Get Json array
            JSONArray array=jsonObject.getJSONArray("array");
            // Navigate through an array item one by one
            for(int i=0;i<array.length();i++)
            {
                // select the particular JSON data
                JSONObject object=array.getJSONObject(i);
                String cit=object.getString("name");
                //  String state=object.getString("state");
                // add to the lists in the specified format

                city.add(cit);
                // sta.add(state);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }




}
