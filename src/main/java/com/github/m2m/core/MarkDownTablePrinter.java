package com.github.m2m.core;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.m2m.entity.Table;

@Component
public class MarkDownTablePrinter implements Printer<String> {
	
	@Autowired
	private VelocityEngine ve;

	@Override
	public String print(Table table) {
		Template t = ve.getTemplate("table.vm");
	    VelocityContext ctx = new VelocityContext();
	    ctx.put("columns", table.getFields());
		StringWriter sw = new StringWriter();
		t.merge(ctx, sw);
		return sw.toString();
	}
	
	

}
