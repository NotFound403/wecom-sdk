/**
 * 对企业微信发送给企业后台的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2020 Tencent Inc.
 */

// ------------------------------------------------------------------------

package cn.felord.callbacks;

/**
 * 针对 org.json.JSONObject,
 * 要编译打包架包json
 * 官方源码下载地址 : https://github.com/stleary/JSON-java, jar包下载地址 : https://mvnrepository.com/artifact/org.json/json
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


/**
 * JsonParse class
 *
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
class JsonParse {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final TypeReference<Map<String, String>> OBJECT_TYPE =new TypeReference<Map<String, String>>() {
	};

	/**
	 * 提取出 JSON 包中的加密消息
	 * @param jsontext 待提取的json字符串
	 * @return 提取出的加密消息字符串
	 * @throws AesException AES
	 */
	public static Object[] extract(String jsontext) throws AesException {
		Object[] result = new Object[3];
		try {
			Map<String, String> json = objectMapper.readValue(jsontext, OBJECT_TYPE);
			String encrypt_msg = json.get("encrypt");
			String tousername  = json.get("tousername");
			String agentid     = json.get("agentid");

			result[0] = tousername;
			result[1] = encrypt_msg;
			result[2] = agentid;
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ParseJsonError);
		}
	}

	/**
	 * 生成json消息
	 * @param encrypt 加密后的消息密文
	 * @param signature 安全签名
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @return 生成的json字符串
	 */
	public static String generate(String encrypt, String signature, String timestamp, String nonce) {

		String format = "{\"encrypt\":\"%1$s\",\"msgsignature\":\"%2$s\",\"timestamp\":\"%3$s\",\"nonce\":\"%4$s\"}";
		return String.format(format, encrypt, signature, timestamp, nonce);

	}
}
