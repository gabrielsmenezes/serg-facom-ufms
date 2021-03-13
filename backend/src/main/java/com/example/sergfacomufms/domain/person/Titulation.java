package com.example.sergfacomufms.domain.person;

import lombok.Data;
import lombok.NoArgsConstructor;

public enum Titulation {
    GRADUATE(1, "Graduate"),
    MASTER(2, "Master"),
    DOCTORAL(3, "Doctoral"),
    POST_DOCTORAL(4, "Post Doctoral");

    private int code;
    private String name;

    Titulation(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
