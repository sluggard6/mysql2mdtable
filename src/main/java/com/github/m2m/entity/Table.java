package com.github.m2m.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Table {

    private String name;
    
    private String comment;

    private List<Column> fields;

    public Table() {
        this.fields = new ArrayList<>();
    }
}
