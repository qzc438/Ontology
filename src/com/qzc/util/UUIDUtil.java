package com.qzc.util;

import java.util.UUID;

public class UUIDUtil {
 
	public static String creatUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
 
	public static void main(String[] args) {
		String str = UUIDUtil.creatUUID();
		System.out.println(str);
	}
}