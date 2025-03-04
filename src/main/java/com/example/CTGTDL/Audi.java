package com.example.CTGTDL;

public class Audi implements Vehicle, Drive {
    private String name;
    private int wheel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public Audi(String name, int wheel) {
        this.name = name;
        this.wheel = wheel;
    }

    @Override
    public void method2() {

    }

    @Override
    public void method1() {

    }
    public void method3() {
        System.out.println("hello world");
    }

}
