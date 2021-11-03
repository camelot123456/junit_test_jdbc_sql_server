package com.junittest.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HandleFileUtil {
//	https://viblo.asia/p/mockito-tu-a-den-z-WAyK8xAoKxX
	public static String getContentFile(String path) {
		StringBuilder builder = new StringBuilder();
		File file = new File(path);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			builder.append(line);
			System.out.println(line);
		}
		return builder.toString();
	}
	
}
