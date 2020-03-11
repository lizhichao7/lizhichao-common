package com.lizhichao.common.utils;

public class FileUtil {
	/**
	 * 给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”
	 * @param fileName
	 * @return
	 */
	public static String getExtendName(String fileName) {
		//从后查找'.'
		int i = fileName.lastIndexOf(".");
		
		//以查找到的点为起始，截取后面的字符串
		String string = fileName.substring(i);
		
		
		return string;
		
	}
}
