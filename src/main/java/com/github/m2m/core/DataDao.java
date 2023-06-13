package com.github.m2m.core;

import java.util.List;

import com.github.m2m.entity.Table;

public interface DataDao {

    List<String> showTables();
    
    List<String> showTables(String database);
    
    Table getTableInfo(String tableName);
}
