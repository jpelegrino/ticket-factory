package com.ticketsh.ticketshow.mock;

import com.ticketsh.ticketshow.entities.Status;
import com.ticketsh.ticketshow.entities.TicketStore;
import com.ticketsh.ticketshow.enums.StatusEnum;

import java.util.ArrayList;
import java.util.List;

public class TicketStoreMock {



    public static List<TicketStore> generateTicket(Long row, Long col) {
        Long section=1L;
        Status status=new Status();
        status.setId(StatusEnum.ACTIVE.getStatus());
        List<TicketStore> ticketStoreList=new ArrayList<>();
        for(int r=1;r<=row;r++) {
            for(int c=1;c<=col;c++) {
                ticketStoreList.add(new TicketStore(section,Long.valueOf(r),Long.valueOf(c), status));
            }
        }

        return ticketStoreList;

    }

    public static TicketStore getTicketStore(Long row,Long section,Long seat) {
        Status status=new Status();
        status.setId(StatusEnum.ACTIVE.getStatus());
        return new TicketStore(section,row,seat, status);
    }

}
