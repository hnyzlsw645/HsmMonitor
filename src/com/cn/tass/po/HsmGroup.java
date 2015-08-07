package com.cn.tass.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 加密机分组
 * @author lenovo
 *
 */
public class HsmGroup {
	//加密机组名
	private String groupName;
	//加密机个数
	private int hsmCount = 0;
	//加密机
	private List<HSM> hsm = new ArrayList<HSM>();

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getHsmCount() {
		return hsmCount;
	}
	public void setHsmCount(int hsmCount) {
		this.hsmCount = hsmCount;
	}
	public List<HSM> getHsm() {
		return hsm;
	}
	public void setHsm(List<HSM> hsm) {
		this.hsm = hsm;
	}
	

}
