/**
 * 对企业微信发送给企业后台的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package cn.felord.callbacks;

import java.security.MessageDigest;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * SHA1 class
 * <p>
 * 计算消息签名接口.
 */
class SHA1 {

	/**
	 * 用SHA1算法生成安全签名
	 *
	 * @param token     票据
	 * @param timestamp 时间戳
	 * @param nonce     随机字符串
	 * @param encrypt   密文
	 * @return 安全签名 sha 1
	 * @throws AesException the aes exception
	 */
	public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException
			  {
		try {
			String str = Stream.of(token, timestamp, nonce, encrypt)
					.sorted()
					.collect(Collectors.joining());

			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuilder hexstr = new StringBuilder();
			String shaHex;
			for (byte b : digest) {
				shaHex = Integer.toHexString(b & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
}
