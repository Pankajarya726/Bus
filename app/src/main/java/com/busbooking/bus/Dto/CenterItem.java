package com.busbooking.bus.Dto;

import com.busbooking.bus.Dto.AbstractItem;

public class CenterItem extends AbstractItem {

    public CenterItem(String label) {
        super(label);
    }


    @Override
    public int getType() {
        return TYPE_CENTER;
    }

}
