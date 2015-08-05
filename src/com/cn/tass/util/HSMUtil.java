package com.cn.tass.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.cn.tass.po.HSM;

public class HSMUtil {
	public static List<HSM> group = new ArrayList();

	// 读取配置文件
	static InputStream in = null;

	public static void getConfig() {
		in = HSMUtil.class.getClassLoader().getResourceAsStream(
				"config.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			Set<String> pnames = p.stringPropertyNames();
			for (String pname : pnames) {
				HSM hsm = null;
				if (pname.startsWith("group")) {
					hsm = new HSM();
				}
				while (!pname.startsWith("group")) {
					if (pname.startsWith("ip")) {
						hsm.setIp(p.getProperty(pname));
					}
					if (pname.startsWith("port")) {
						hsm.setPort(Integer.parseInt(p.getProperty(pname)));
					}
					group.add(hsm);
					break;
				}
				System.out.println(p.getProperty(pname));
			}
			System.out.println("*****************************");
			for (HSM hsm : group) {
				System.out.println(hsm);
			}
			System.out.println("++++++++++++++++++++++++++++++");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 添加加密机
	public static void addHsm(HSM hsm) {

	}

	// 删除加密机
	public static void deleteHsm(HSM hsm) {

	}

	// 修改加密机
	public static void updateHsm(HSM hsm) {

	}

	public static void main(String[] args) {
		HSMUtil.getConfig();
	}

}
