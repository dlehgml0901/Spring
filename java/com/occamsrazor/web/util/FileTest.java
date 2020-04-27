package com.occamsrazor.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileTest {
	public final static String FILE_PATH = "C:\\Users\\user\\spring-workspace\\occamsrazor\\src\\main\\resources\\static\\member\\";
	public static void main(String[] args) {
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			BufferedReader br = new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<>();
			while (true) {
				switch (JOptionPane.showInputDialog("0.종료  1.쓰기  2.읽기")) {
				case "0": return;
				case "1":
					String message = JOptionPane.showInputDialog("메시지 입력");
					bw.write(message);
					bw.newLine();
					bw.flush();
					break;
				case "2":
					while ((message = br.readLine()) != null) {
						list.add(message + "/");
					}
					JOptionPane.showMessageDialog(null, list);
					br.close();
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
	}
}
