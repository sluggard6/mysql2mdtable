package com.github.m2m.core;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.m2m.entity.Table;

@Component
public class VelocityPrinter implements Printer<String> {
	
	@Autowired
	private VelocityEngine ve;
	
	private static final String DEFAULT_TEMPLATE = "table.vm";

	@Override
	public String print(Table table) {
		return print(table, DEFAULT_TEMPLATE);
	}

	@Override
	public String print(Table table, String template, String... args) {
		Template t = ve.getTemplate(template);
	    VelocityContext ctx = new VelocityContext();
	    ctx.put("table", table);
	    ctx.put("head", args[0]);
	    ctx.put("index", args[1]);
		StringWriter sw = new StringWriter();
		t.merge(ctx, sw);
		return sw.toString();
	}
	
	

}
