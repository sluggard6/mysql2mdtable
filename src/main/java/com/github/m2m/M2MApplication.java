package com.github.m2m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.github.m2m.core.DataDao;
import com.github.m2m.core.MarkDownTablePrinter;

@SpringBootApplication
public class M2MApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(M2MApplication.class, args);
		DataDao dataDao = applicationContext.getBean(DataDao.class);
		MarkDownTablePrinter printer = applicationContext.getBean(MarkDownTablePrinter.class);
		dataDao.showTables().forEach(s->{
			String out = printer.print(dataDao.getTableInfo(s));
			System.out.println(out);
		});
	}

}
