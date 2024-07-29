package com.edu.jsp.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	private String message;
	private T data;
}
