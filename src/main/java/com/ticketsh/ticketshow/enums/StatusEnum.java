package com.ticketsh.ticketshow.enums;

public enum StatusEnum {

    ACTIVE(1L),
    INACTIVE(2L);

    private  Long status;

    StatusEnum(Long status) {
        this.status=status;
    }

    public Long getStatus() {
        return status;
    }
}
