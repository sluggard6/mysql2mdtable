package com.github.m2m.core;

import java.util.List;

import com.github.m2m.entity.Column;
import com.github.m2m.entity.Table;

public interface DataDao {

    List<String> showTables();
    
    List<Table> showFullTables();
    
    List<String> showTables(String database);
    
    List<Column> getTableInfo(String tableName);
}
