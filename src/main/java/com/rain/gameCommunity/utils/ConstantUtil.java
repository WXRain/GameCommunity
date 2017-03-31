package com.rain.gameCommunity.utils;

import org.springframework.stereotype.Repository;

@Repository
public class ConstantUtil {

	// 用户性别为男
	public static final int USER_MAN = 1;

	// 用户性别为女
	public static final int USER_WOMAN = 0;

	// 用户是管理员
	public static final int USER_MANAGER = 1;

	// 用户不是管理员
	public static final int USER_NOT_MANAGER = 0;
	
	// 支付成功
	public static final String PAY_SUCCESS = "1";
	
	// 没有支付或者支付失败
	public static final String PAY_FAILED = "0";
}
