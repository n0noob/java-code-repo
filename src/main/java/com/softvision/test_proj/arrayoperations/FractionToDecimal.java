package com.softvision.test_proj.arrayoperations;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
	public String fractionToDecimal(int num, int den) {

		if (den == 0) {
			throw new RuntimeException();
		}

		int rem = num % den;
		int div = num / den;
		StringBuilder sb = new StringBuilder();
		sb.append(div);

		// If numerator is completely divisible
		if (rem == 0)
			return sb.toString();

		sb.append(".");
		Map<Integer, Integer> map = new HashMap<>();
		boolean repetition = false;
		int opBracketIndex = -1;

		while (rem > 0) {
			// System.out.println(sb.toString());
			rem = rem * 10;
			div = rem / den;

			if (!map.containsKey(div)) {
				map.put(div, sb.length());
				sb.append(div);
			} else {
				repetition = true;
				opBracketIndex = map.get(div);
				sb.append(")");
				break;
			}

			rem = rem % den;
		}

		String res = sb.toString();

		if (repetition) {
			String part1 = res.substring(0, opBracketIndex);
			String part2 = res.substring(opBracketIndex, res.length());

			res = part1 + "(" + part2;
		}

		return res;
	}

	public static void main(String[] args) {
		FractionToDecimal driver = new FractionToDecimal();
		String res = driver.fractionToDecimal(22, 7);
		System.out.println("Result : " + res);
	}
}
