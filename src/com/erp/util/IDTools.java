package com.erp.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成UUid
 * @author JiaQi
 *
 */
public class IDTools {
	public static long GetUUID(){
		Format format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		long UUID = Long.valueOf(format.format(new Date()));
		return UUID;
	}
}