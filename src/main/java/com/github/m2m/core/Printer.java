package com.github.m2m.core;

import com.github.m2m.entity.Table;

public interface Printer<T> {
	
	T print(Table table);

}
