package com.wx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {
	// 自定义 token
	private static String TOKEN = "mtnh_mm";

	public static boolean checkSignature(String signature,String timestamp,String nonce){


		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		MessageDigest mDigest = null;
		String digestStr = null;
		try {
			mDigest = MessageDigest.getInstance("SHA-1");
			byte[] digest = mDigest.digest(bigStr.getBytes());
			digestStr = byte2str(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}
		// 确认请求来自微信
		if (digestStr.equals(signature)) {
			return true;
		}

		return false;
	}


	// 将字节数组转换为字符串
	private static String byte2str(byte[] bytearray) {
		StringBuffer hexstrBuffer = new StringBuffer();
		String strDigest = "";
		for (int i = 0; i < bytearray.length; i++) {
			strDigest = Integer.toHexString(bytearray[i]&0xFF);
			if(strDigest.length()<2){
				hexstrBuffer.append(0);
			}
			hexstrBuffer.append(strDigest);

		}
		return hexstrBuffer.toString();
	}

}
