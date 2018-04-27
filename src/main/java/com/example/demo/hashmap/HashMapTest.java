package com.example.demo.hashmap;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args)
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("qq", "1");
		map.put("ww", "2");
		map.put("ww1", "52");
		map.put("ww2", "42");
		map.put("ww3", "32");
		map.put("ww4", "22");
		map.put("ww5", "12");
		map.put("ww6", "20");
		map.put("ww7", "29");
		map.put("ww8", "28");
		map.put("ww9", "27");
		map.put("ww10", "26");
		Object o="cc";
		
		System.out.println("地址"+o.hashCode());
		System.out.println(map);
		System.out.println(hash("user123")& 15);
		System.out.println("user".hashCode());
		System.out.println(8 & 32);
		HashMapTest t=new HashMapTest();
		Object cl=new HashMapTest();
		t.say(new HashMapTest());
	}
	 public boolean equals(Object obj) {
	        System.out.println("bsnnnsnsn");
	        return true;
	    }

	    public void say(Object o1) {
	        o1.equals("22");
	    }
	  static final int hash(Object key) {
	        int h=0;
	        System.out.println("h======"+((h = key.hashCode()) ^ (h >>> 16)));
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }

}
