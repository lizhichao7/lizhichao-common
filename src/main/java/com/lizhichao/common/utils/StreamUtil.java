package com.lizhichao.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StreamUtil {
	/**
	 * 批量关闭流，参数能传入无限个。
	 * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限
	 */
	public static void closeAll(AutoCloseable src) {
		try {
			src.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，要求方法内部调用上面第1个方法关闭流
	 * @param src
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String readTextFile(InputStream src) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(src,StandardCharsets.UTF_8));
		
		byte b[] = new byte[2048];
		int len=0;
		int temp=0;
		@SuppressWarnings("unused")
		String stu="";
		try {
			while((temp=reader.read())!=-1) {
				b[len]=(byte) temp;
				len++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				closeAll(src);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return new String(b,0,len);
		}
			
	}
	
	/**
	 * 传入文本文件对象，返回该文件内容，并且要求内部调用上面第2个方法。
	 * @param txtFile
	 * @return
	 */
	@SuppressWarnings({ "resource", "finally" })
	public static String readTextFile(File txtFile) {
		String file="";
		try {
			FileInputStream inputStream = new FileInputStream(txtFile);
			file = readTextFile(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return file;
		}		
		
	}
}
