package org.mocity.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content="<p>4</p><p><br /></p><p><br /></p>@mocity@<p>4</p>";
		String conpre="";
		Pattern pattern = Pattern.compile(".*@mocity@");
		Matcher m = pattern.matcher(content);
		System.out.println(content);
			if (m.find()) {
				conpre = m.group(0);
				 System.out.println(conpre);
			}
	}

}
