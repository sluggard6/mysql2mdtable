package com.github.m2m.core;

import com.github.m2m.entity.Table;

public interface Printer<T> {
	
	T print(Table table);
	
	T print(Table table, String template, String... args);
	
//	default String print(Table table, String template) {
//		Template t = ve.getTemplate("table.vm");
//	    VelocityContext ctx = new VelocityContext();
//	    ctx.put("table", table);
//		StringWriter sw = new StringWriter();
//		t.merge(ctx, sw);
//		return sw.toString();
//	}

}
