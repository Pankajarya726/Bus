
package com.busbooking.bus.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.busbooking.bus.Adapter.AirplaneAdapter;
import com.busbooking.bus.Dto.AbstractItem;
import com.busbooking.bus.Dto.CenterItem;
import com.busbooking.bus.Dto.EdgeItem;
import com.busbooking.bus.Dto.EmptyItem;
import com.busbooking.bus.OnSeatSelected;
import com.busbooking.bus.R;

import java.util.ArrayList;
import java.util.List;

public class SelectSeat extends AppCompatActivity implements OnSeatSelected {
    private static final int COLUMNS = 5;
    private TextView txtSeatSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);


        txtSeatSelected = findViewById(R.id.txt_seat_selected);

        List<AbstractItem> items = new ArrayList<>();
        for (int i=0; i<40; i++) {

            if (i%COLUMNS==0 || i%COLUMNS==4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
        RecyclerView recyclerView = findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(manager);

        AirplaneAdapter adapter = new AirplaneAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSeatSelected(final int count) {
        final int seat = count;
        Log.d("tag"+count,"=======***************="+seat);

        txtSeatSelected.setText("Book "+count+" seats");
        txtSeatSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("seatcount",seat);
                Log.d("tag1"+seat,"=======***************="+count);

                Intent intent = new Intent(SelectSeat.this,PassengerDetail.class);
                intent.putExtra("seatcount", seat);
                startActivity(intent);
            }
        });



    }
}
