package com.cn.tass.po;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class HSM {
	//加密机名称
	private String hsmName;
	//加密ip地址ַ
	private String ip;
	//加密机端口
	private int port;
	//加密机消息头长
	private int msglen = 0;
	
	public String getHsmName() {
		return hsmName;
	}
	public void setHsmName(String hsmName) {
		this.hsmName = hsmName;
	}
	public int getMsglen() {
		return msglen;
	}
	public void setMsglen(int msglen) {
		this.msglen = msglen;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
