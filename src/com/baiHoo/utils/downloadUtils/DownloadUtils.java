package com.baiHoo.utils.downloadUtils;

import java.io.IOException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class DownloadUtils {
	/**
	 * 下载文件时，针对不同浏览器，进行附件名的编码
	 * @param filename 下载文件名
	 * @param agent 客户端浏览器(通过request.getHeader("user-agent")获得)
	 * @return 编码后的下载附件名
	 * @throws IOException
	 */
	public static String encodeDownloadFilename(String filename, String agent) {
		try{
			if (agent.contains("MSIE")) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "utf-8");
				filename = filename.replace("+", " ");
			} else if (agent.contains("Firefox")) {
				// 火狐浏览器
				BASE64Encoder base64Encoder = new BASE64Encoder();
				filename = "=?utf-8?B?"
						+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
			} else if (agent.contains("Chrome")) {
				// google浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			} else {
				// 其它浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return filename;

	}
}
