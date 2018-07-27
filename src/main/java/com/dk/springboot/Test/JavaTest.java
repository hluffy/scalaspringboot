package com.dk.springboot.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class JavaTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = URLEncoder.encode("张三","GBK");
		System.out.println(str);
	}
}
