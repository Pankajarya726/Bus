package com.busbooking.bus.Dto;

import com.busbooking.bus.Dto.AbstractItem;

public class EdgeItem extends AbstractItem {

    public EdgeItem(String label) {
        super(label);
    }



    @Override
    public int getType() {
        return TYPE_EDGE;
    }

}
