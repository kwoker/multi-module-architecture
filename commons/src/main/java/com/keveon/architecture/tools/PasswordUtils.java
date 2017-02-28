package com.keveon.architecture.tools;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Keveon on 2017/2/18.
 * Admin password Manager
 */
@UtilityClass
public class PasswordUtils {

	/**
	 * 验证密码是否正确
	 *
	 * @param password   存储的密码
	 * @param passwordIn 传入的密码
	 * @param salt       盐
	 * @return 是否正确
	 */
	public static boolean checkPassword(String password, String passwordIn, String salt) {
		String pwd = md5(passwordIn, salt, false);
		return pwd.equals(password);
	}

	/**
	 * 对密码做带盐md5加密
	 *
	 * @param password 密码
	 * @param salt     盐
	 * @return 加密后字符串
	 */
	public static String md5(String password, String salt) {
		return md5(password, salt, true);
	}

	/**
	 * 对密码做带盐md5加密
	 *
	 * @param password 密码
	 * @param salt     盐
	 * @param hasMD5   参数1是否已经md5
	 * @return 加密后字符串
	 */
	public static String md5(String password, String salt, boolean hasMD5) {
		String s = password;
		if (!hasMD5) {
			s = DigestUtils.md5Hex(s);
		}
		return DigestUtils.md5Hex(s + salt);
	}
}
