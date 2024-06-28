package com.github.m2m;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.github.m2m.core.DataDao;
import com.github.m2m.core.VelocityPrinter;
import com.github.m2m.entity.Table;

@SpringBootApplication
public class M2MApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =  SpringApplication.run(M2MApplication.class, args);
		DataDao dataDao = applicationContext.getBean(DataDao.class);
		VelocityPrinter printer = applicationContext.getBean(VelocityPrinter.class);
		int i=1;
		File file = new File("db.adoc");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(file);
		for(Table t : dataDao.showFullTables()){
			t.setFields(dataDao.getTableInfo(t.getName()));
			String out = printer.print(t, "adoc-table.vm", "6", String.valueOf(i++));
			System.out.println(out);
			pw.write(out);
			pw.write("\n");
		};
		pw.flush();
		pw.close();
		
		
	}

}
