package com.github.m2m.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.github.m2m.entity.Column;
import com.github.m2m.entity.Table;

@Component
public class DataDaoMyqlImpl extends JdbcTemplate implements DataDao, ApplicationContextAware {
	
	@Override
    public List<String> showTables() {
        List<String> list = new ArrayList<>();
        
        query(String.format("show tables"), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                list.add(rs.getString(1));
            }
        });
        return list;
    }

	@Override
    public Table getTableInfo(String tableName) {
        Table table = new Table();
        table.setName(tableName);
        query(String.format("show full columns from %s;", tableName), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Column column = new Column();
                column.setField(rs.getString("field"));
                column.setType(rs.getString("type"));
                column.setNullable(rs.getString("null"));
                column.setComment(rs.getString("comment"));
                table.getFields().add(column);
            }
        });
        return table;
    }
	
	private static String getLength(String s) {
		System.out.println(s.length() + " : " + s.indexOf('(') + " : " + s.indexOf(')'));
		if(s.indexOf('(')>0 && s.indexOf(')')>0) {
			return s.substring(s.indexOf('(')+1, s.indexOf(')'));
		}
		return "None";
//		return 0;
	}

	@Override
	public List<String> showTables(String database) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		setDataSource(applicationContext.getBean(DataSource.class));
		
	}

}
