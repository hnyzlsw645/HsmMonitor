package com.cn.tass.testCase;

import java.util.ArrayList;

import cn.tass.baseapi.SJY42A_IC.hardLib;
import cn.tass.exceptions.TAException;

public class test {

    public static void main(String[] args) {
        hardLib instance = null;
        try {
            instance = hardLib.getInstance(
                    "{[LOGGER];logsw=error,debug,info,warn;logPath=./;[HOST 1];hsmModel=SJY42A_IC;host=192.168.19.100;}");
        } catch (TAException e) {
            e.printStackTrace();
        }

        String info = null;
        try {
            info = instance.getDeviceInfo();
        } catch (TAException e) {
            e.printStackTrace();
        }
        System.out.println(info);

        byte[] random = null;
        try {
            random = instance.generateRandom(35);
        } catch (TAException e) {
            e.printStackTrace();
        }
        if (random != null)
            hardLib.printBuf("\nRandom", random);

        /*RSA密钥备份与恢复*/
        byte[] rsakey = null;
        try {
            rsakey = instance.backupRsaKey(3);
            hardLib.printBuf("\nRsaKey", rsakey);
            
            instance.restoreRsaKey(11, rsakey);
        } catch (TAException e) {
            e.printStackTrace();
        }
        
        /*DES密钥备份与恢复*/
        ArrayList<String> deskey = null;
        try {
            deskey = instance.backupDesKey(3);
            System.out.println("\nDesKey:"+deskey.get(0));
            System.out.println("\nKeyCV:"+deskey.get(1));
            
            instance.restoreDesKey(11, deskey.get(0), deskey.get(1));
        } catch (TAException e) {
            e.printStackTrace();
        }
    }
}
