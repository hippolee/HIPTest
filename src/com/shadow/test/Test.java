package com.shadow.test;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//1)	(7,23)
//2)	(1,3)-(6,20)
//		(4,7)-(3,16)
//		8-(3,8)
//3)	1-(1,4)-(6,16)
//		1-(5,12)-(3,8)
//		(2,3)-(1,2)-(6,16)
//		(2,3)-(3,4)-(3,16)
//		(2,3)-(5,6)-(3,8)
//4)	(1,3)-(1,4)-(3,8)-(3,8)	
public class Test {

	/** Logger */
	private static Logger logger = LoggerFactory.getLogger(Test.class);

	// private static final String regex =
	// "(?=\\D+|^)(\\d{1,3}-\\d{1,4}-\\d{3,8}-\\d{3,8}" +
	// "|\\d{2,3}-\\d{5,6}-\\d{3,8}"
	// + "|\\d{2,3}-\\d{3,4}-\\d{3,16}" + "|\\d{2,3}-\\d{1,2}-\\d{6,16}" +
	// "|\\d{1}-\\d{5,12}-\\d{3,8}"
	// + "|\\d{1}-\\d{1,4}-\\d{6,16}" + "|\\d{8}-\\d{3,8}" +
	// "|\\d{4,7}-\\d{3,16}" + "|\\d{1,3}-\\d{6,20}"
	// + "|\\d{7,23})(?=\\D+|$)";

	// (?=\\D+|^)(\\d{1,3}-\\d{1,4}-\\d{3,8}-\\d{3,8})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{2,3}-\\d{5,6}-\\d{3,8})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{2,3}-\\d{3,4}-\\d{3,16})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{2,3}-\\d{1,2}-\\d{6,16})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{1}-\\d{5,12}-\\d{3,8})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{1}-\\d{1,4}-\\d{6,16})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{8}-\\d{3,8})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{4,7}-\\d{3,16})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{1,3}-\\d{6,20})(?=\\D+|$)"
	// + "|(?=\\D+|^)(\\d{7,23})(?=\\D+|$)"

	// private static final String regex =
	// "((?<=\\D+|^)(\\d{1,3}-\\d{1,4}-\\d{3,8}-\\d{3,8})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{2,3}-\\d{5,6}-\\d{3,8})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{2,3}-\\d{3,4}-\\d{3,16})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{2,3}-\\d{1,2}-\\d{6,16})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{1}-\\d{5,12}-\\d{3,8})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{1}-\\d{1,4}-\\d{6,16})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{8}-\\d{3,8})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{4,7}-\\d{3,16})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{1,3}-\\d{6,20})(?=\\D+|$))"
	// + "|((?<=\\D+|^)(\\d{7,23})(?=\\D+|$))";

	private static final String regex = "(?<=\\D+|^)(\\d{1,3}-\\d{1,4}-\\d{3,8}-\\d{3,8}|\\d{2,3}-\\d{5,6}-\\d{3,8}|\\d{2,3}-\\d{3,4}-\\d{3,16}|\\d{2,3}-\\d{1,2}-\\d{6,16}|\\d{1}-\\d{5,12}-\\d{3,8}|\\d{1}-\\d{1,4}-\\d{6,16}|\\d{8}-\\d{3,8}|\\d{4,7}-\\d{3,16}|\\d{1,3}-\\d{6,20}\\d{7,23})(?=\\D+|$)";

	// + "|(^(\\d{1,3}-\\d{1,4}-\\d{3,8}-\\d{3,8})(?=\\D+|$))"
	// + "|(^(\\d{2,3}-\\d{5,6}-\\d{3,8})(?=\\D+|$))"
	// + "|(^(\\d{2,3}-\\d{3,4}-\\d{3,16})(?=\\D+|$))"
	// + "|(^(\\d{2,3}-\\d{1,2}-\\d{6,16})(?=\\D+|$))"
	// + "|(^(\\d{1}-\\d{5,12}-\\d{3,8})(?=\\D+|$))"
	// + "|(^(\\d{1}-\\d{1,4}-\\d{6,16})(?=\\D+|$))"
	// + "|(^(\\d{8}-\\d{3,8})(?=\\D+|$))"
	// + "|(^(\\d{4,7}-\\d{3,16})(?=\\D+|$))"
	// + "|(^(\\d{1,3}-\\d{6,20})(?=\\D+|$))"
	// + "|(^(\\d{7,23})(?=\\D+|$))";

	// \\d{1,3}-\\d{1,4}-\\d{3,8}-\\d{3,8}
	// \\d{2,3}-\\d{5,6}-\\d{3,8}
	// \\d{2,3}-\\d{3,4}-\\d{3,16}
	// \\d{2,3}-\\d{1,2}-\\d{6,16}
	// \\d{1}-\\d{5,12}-\\d{3,8}
	// \\d{1}-\\d{1,4}-\\d{6,16}
	// \\d{8}-\\d{3,8}
	// \\d{4,7}-\\d{3,16}
	// \\d{1,3}-\\d{6,20}
	// \\d{7,23}

	public static void main(String[] args) {
		// s4();
		// s1();
		// s2();
		s3();
	}

	public static void s1() {
		Pattern pattern = Pattern.compile(regex);
		// 一个杠
		for (int i = 1; i <= 30; i++) {
			String s1 = genPartString(i, "");

			StringBuilder sb = new StringBuilder(s1);

			Matcher matcher = pattern.matcher(s1);
			while (matcher.find()) {
				sb.append("\t");
				sb.append(matcher.group());
			}

			logger.error(sb.toString());

			s1 = "AAA" + s1;
			sb = new StringBuilder(s1);

			matcher = pattern.matcher(s1);
			while (matcher.find()) {
				sb.append("\t");
				sb.append(matcher.group());
			}

			logger.error(sb.toString());
		}
	}

	public static void s2() {
		Pattern pattern = Pattern.compile(regex);
		// 两个杠
		for (int i = 1; i <= 23; i++) {
			String s1 = genPartString(i, "");
			for (int j = 1; j <= 23; j++) {
				String s2 = genPartString(j, s1);

				StringBuilder sb = new StringBuilder(s2);

				Matcher matcher = pattern.matcher(s2);
				while (matcher.find()) {
					sb.append("\t");
					sb.append(matcher.group());
				}

				logger.error(sb.toString());

				s2 = "AAA" + s2;
				sb = new StringBuilder(s2);

				matcher = pattern.matcher(s2);
				while (matcher.find()) {
					sb.append("\t");
					sb.append(matcher.group());
				}

				logger.error(sb.toString());

				s2 = s2 + "BBB";
				sb = new StringBuilder(s2);

				matcher = pattern.matcher(s2);
				while (matcher.find()) {
					sb.append("\t");
					sb.append(matcher.group());
				}

				logger.error(sb.toString());
			}
		}
	}

	public static void s3() {
		Pattern pattern = Pattern.compile(regex);
		// 两个杠
		for (int i = 1; i <= 23; i++) {
			String s1 = genPartString(i, "");
			for (int j = 1; j <= 23; j++) {
				String s2 = genPartString(j, s1);
				for (int k = 1; k <= 23; k++) {
					String s3 = genPartString(k, s2);

					StringBuilder sb = new StringBuilder(s3);

					Matcher matcher = pattern.matcher(s3);
					while (matcher.find()) {
						sb.append("\t");
						sb.append(matcher.group());
					}

					logger.error(sb.toString());

					s3 = "AAA" + s3;
					sb = new StringBuilder(s3);

					matcher = pattern.matcher(s3);
					while (matcher.find()) {
						sb.append("\t");
						sb.append(matcher.group());
					}

					logger.error(sb.toString());

					s3 = s3 + "BBB";
					sb = new StringBuilder(s3);

					matcher = pattern.matcher(s3);
					while (matcher.find()) {
						sb.append("\t");
						sb.append(matcher.group());
					}

					logger.error(sb.toString());
				}
			}
		}
	}

	public static void s4() {
		Pattern pattern = Pattern.compile(regex);
		// 两个杠
		for (int i = 1; i <= 9; i++) {
			String s1 = genPartString(i, "");
			for (int j = 1; j <= 9; j++) {
				String s2 = genPartString(j, s1);
				for (int k = 1; k <= 9; k++) {
					String s3 = genPartString(k, s2);
					for (int m = 1; m <= 23; m++) {
						String s4 = genPartString(m, s3);

						s4 = "AAA" + s4;
						StringBuilder sb = new StringBuilder(s4);

						Matcher matcher = pattern.matcher(s4);
						while (matcher.find()) {
							sb.append("\t");
							sb.append(matcher.group());
						}

						logger.error(sb.toString());

						s4 = s4 + "BBB";
						sb = new StringBuilder(s4);

						matcher = pattern.matcher(s4);
						while (matcher.find()) {
							sb.append("\t");
							sb.append(matcher.group());
						}

						logger.error(sb.toString());
					}
				}
			}
		}
	}

	private static String genPartString(int length, String preString) {
		StringBuilder sb = new StringBuilder(preString);
		if (preString != null && preString.length() > 0) {
			sb.append("-");
		}
		for (int i = 0; i < length; i++) {
			sb.append(randomInt());
		}
		return sb.toString();
	}

	private static int randomInt() {
		Random random = new Random();
		return random.nextInt(10);
	}

}
