package com.qx.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyInterface {
	public int columnIndex() default 0;
	public String columnName() default "";
}
