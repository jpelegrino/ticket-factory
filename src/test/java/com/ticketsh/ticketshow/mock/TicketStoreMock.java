package com.ticketsh.ticketshow.mock;

import com.ticketsh.ticketshow.entities.TicketStore;

import java.util.ArrayList;
import java.util.List;

public class TicketStoreMock {

    public static final long STATUS = 1L;

    public static List<TicketStore> generateTicket(Long row, Long col) {
        Long section=1L;
        List<TicketStore> ticketStoreList=new ArrayList<>();
        for(int r=1;r<=row;r++) {
            for(int c=1;c<=col;c++) {
                ticketStoreList.add(new TicketStore(section,Long.valueOf(r),Long.valueOf(c), STATUS));
            }
        }

        return ticketStoreList;

    }

    public static TicketStore getTicketStore(Long row,Long section,Long seat) {
        return new TicketStore(section,row,seat, STATUS);
    }

}
