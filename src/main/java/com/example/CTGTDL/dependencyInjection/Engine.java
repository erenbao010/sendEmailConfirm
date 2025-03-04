package com.example.CTGTDL.dependencyInjection;

public class Engine {
    private String type;
    private int horsePower;

    public int getHorsePower() {
        return horsePower;
    }


    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Engine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }

    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getUsername() {
        return type;
    }

    public Engine(String username) {
        this.type = username;
    }

    @Override
    public String toString() {
        return "This is Engine";
    }
}
