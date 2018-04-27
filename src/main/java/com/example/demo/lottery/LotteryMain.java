package com.example.demo.lottery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LotteryMain {
	public static final int[] RED = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
			30, 31, 32, 33, 34, 35 };
	public static final int[] BLUE = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16 };

	public int[] getResult(int redCount[], int mCount) {
		Map<Integer, Integer> mr = new HashMap<Integer, Integer>();
		for (int z = 0; z < redCount.length; z++) {
			mr.put(z + 1, redCount[z]);
		}
		LinkedList<Map<Integer, Integer>> ls = new LinkedList<Map<Integer, Integer>>();
		for (int i = 1; i <= mr.size(); i++) {
			int rl = ls.size();
			Map<Integer, Integer> ml = new HashMap<Integer, Integer>();
			if (rl != 0) {
				Boolean ret = false;
				for (int z = 0; z < rl; z++) {
					Integer value = null;
					Integer value2 = null;
					for (Integer key : ls.get(z).keySet()) {
						value = ls.get(z).get(key);
					}
					if (z + 1 < rl) {
						for (Integer key : ls.get(z + 1).keySet()) {
							value2 = ls.get(z + 1).get(key);
						}
					}
					if (value != null && value2 != null) {
						if (value <= mr.get(i) && mr.get(i) <= value2) {
							ml.put(i, mr.get(i));
							ls.add(z + 1, ml);
							break;
						}
						if (mr.get(i) <= value) {
							ml.put(i, mr.get(i));
							ls.add(0, ml);
							break;
						}
					}
					// 比较到list最后一个了
					if (value != null && value2 == null) {
						if (value > mr.get(i)) {
							ml.put(i, mr.get(i));
							ls.add(z, ml);

						} else {
							ml.put(i, mr.get(i));
							ls.add(ml);
						}
					}
				}

			} else {
				ml.put(i, mr.get(i));
				ls.add(ml);
			}

		}
		System.out.println(ls);
		LinkedList arrayList = new LinkedList();
		for (int l = 0; l < mCount; l++) {
			for (Integer key : ls.get(l).keySet()) {
				arrayList.add(key);
			}
		}
		System.out.println(arrayList);
		return null;
	}

	public Integer getRepeat(int num, LinkedList<Map<Integer, Integer>> list) {
		Integer c = null;
		for (int h = 0; h < list.size(); h++) {
			for (Integer key : list.get(h).keySet()) {
				if (list.get(h).get(key) == num) {
					c = h;
					return c;
				}
			}
		}
		return null;

	}

	public static void main(String args[]) {
		LotteryMain l = new LotteryMain();
		int redCount[] = { 21, 14, 14, 15, 14, 22, 19, 20, 15, 15, 24, 17, 15,
				29, 17, 11, 15, 20, 16, 22, 25, 15, 27, 14, 21, 22, 16, 21, 14,
				17, 20, 18, 15 };// 出现的次数
		int blueCount[] = { 4, 7, 6, 5, 7, 7, 7, 3, 4, 3, 8, 9, 4, 8, 4, 14 };// 出现的次数
		l.getResult(redCount, 6);
		l.getResult(blueCount, 1);

	}
}
