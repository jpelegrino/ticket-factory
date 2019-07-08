package com.ticketsh.ticketshow.enums;

public enum MessageEnum {

    NO_MORE_TICKET_AVAILABLE("No more ticket available"),
    THIS_TICKET_NOT_FOUND("This ticket not found"),
    THIS_TICKET_HAS_BEEN_TAKEN("This ticket has been taken"),
    NO_EVENT_ASSOCIATED("No event associated to Ticket");

    private final String message;

    MessageEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
