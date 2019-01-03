package com.busbooking.bus.Dto;

import com.busbooking.bus.Dto.AbstractItem;

public class EmptyItem extends AbstractItem {

    public EmptyItem(String label) {
        super(label);
    }


    @Override
    public int getType() {
        return TYPE_EMPTY;
    }

}


