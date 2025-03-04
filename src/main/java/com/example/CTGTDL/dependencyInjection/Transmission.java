package com.example.CTGTDL.dependencyInjection;

public class Transmission {
    private String type;
    private boolean status;

    public Transmission(String type, boolean status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
