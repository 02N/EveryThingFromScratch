package com.pplab.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Test {
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args){
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.forEach((a) -> System.out.println(a));
		
		HashMap<String,String> m = new HashMap<>();
		m.put("aa", "11");
		m.put("bb", "22");
		m.put("cc", "33");
		m.containsKey("bb");
		m.size();
		Set<String,String> s = m.entrySet();
		
	}
}
