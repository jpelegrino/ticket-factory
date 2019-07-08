package com.ticketsh.ticketshow.dtos.response;

import com.ticketsh.ticketshow.entities.TicketStore;

import java.util.List;

public class TicketStoreDTO {

    private List<TicketStore> ticketStoreList;
    private TicketStore ticketStore;
    private String errorMessage;
    private boolean successed;


    public List<TicketStore> getTicketStoreList() {
        return ticketStoreList;
    }

    public void setTicketStoreList(List<TicketStore> ticketStoreList) {
        this.ticketStoreList = ticketStoreList;
    }

    public TicketStore getTicketStore() {
        return ticketStore;
    }

    public void setTicketStore(TicketStore ticketStore) {
        this.ticketStore = ticketStore;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }
}
