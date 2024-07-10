package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/*This is too difficult question*/
public class ZigZagPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String convertedString = convert("PAYPALISHIRING", 4);
		System.out.println(convertedString);
	}

	public static String convert(String s, int numRows) {

		if (numRows == 1)
			return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		for (StringBuilder s1 : rows) {
			System.out.println(s1.toString());
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows)
			ret.append(row);
		return ret.toString();
	}

}
