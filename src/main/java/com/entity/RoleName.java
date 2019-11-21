package com.entity;

public enum RoleName {

    USER(1);

    private final int number;

    RoleName(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
