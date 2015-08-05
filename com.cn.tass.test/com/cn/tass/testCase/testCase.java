package com.cn.tass.testCase;

import junit.framework.TestCase;

import com.cn.hsm.HsmEngine;

public class testCase extends TestCase{
	public void testHsmEngine() throws Exception {
		HsmEngine hsm = new HsmEngine("192.168.0.124",8080);
		
		hsm.main(null);
		
	}

}
