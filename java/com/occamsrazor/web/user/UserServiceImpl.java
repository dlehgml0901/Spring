package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	public final static String FILE_PATH = "C:\\Users\\user\\spring-workspace\\occamsrazor\\src\\main\\resources\\static\\user\\";
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		if (map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if (user.getPassword().equals(u.getPassword())) {
				returnUser = u;
			}
		}
		return returnUser;
	}

	@Override
	public User detail(String userid) {
		User t = (User) map.get(userid);
		return t;
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}

	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}

	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet(); //entry - 데이터
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator(); //데이터를 정렬한다..
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			list.add(e.getValue()); //키값은 필요없고 value값만 list에 추가해준다.
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

	@Override
	public void saveFile(User user) {
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			String message = user.toString();
			System.out.println(message);
			bw.write(message);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readFile() {
		List<User> userlist = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String message = "";
			while ((message = br.readLine()) != null) {
				list.add(message);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
		User u = new User();
		for (int i = 0; i < list.size(); i++) {			
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setPassword(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddr(arr[4]);
			userlist.add(u);
		}
		return userlist;
	}

	@Override
	public boolean idSearch(String userid) {
		boolean ok = true;
		List<User> list = readFile();
		for (int i = 0; i < list.size(); i++) {
			if (userid.equals(list.get(i).getUserid())) {
				ok = false;
				break;
			}
		}
		return ok;
	}
}
