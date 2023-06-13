package com.github.m2m.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

@Data
public class Column {
	
	private String field;
	
	private String type;
	
	@TableField("null")
	private String nullable;
	
	private String comment;
}
