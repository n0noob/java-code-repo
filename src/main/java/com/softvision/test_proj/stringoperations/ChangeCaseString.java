package com.softvision.test_proj.stringoperations;

public class ChangeCaseString {
	
	public String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder();
		
		if(str == null || "".equals(str)) {
			return str;
		}
		int temp = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			//If current char is uppercase
			if(ch >= 'A' && ch <= 'Z') {
				temp = ch - 'A';
				ch = (char)(temp + 'a');
			}
			sb.append(ch);
		}
		
		return sb.toString();
	}
	
}
