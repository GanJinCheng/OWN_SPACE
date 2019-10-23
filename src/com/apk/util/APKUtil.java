package com.apk.util;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
 
import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.UseFeature;

public class APKUtil {
	public static void main(String[] arg){
		String filePath = "D:\\soapui\\LCDP_ZEMSO东莞1.8.apk";
		ApkFile apkFile;
		try {
			apkFile = new ApkFile(new File(filePath));
			ApkMeta apkMeta = apkFile.getApkMeta();
			System.out.println(apkMeta.getName());
			System.out.println(apkMeta.getPackageName());
			System.out.println(apkMeta.getVersionCode());
			System.out.println(apkMeta.getVersionName());
			for (UseFeature feature : apkMeta.getUsesFeatures()) {
				System.out.println(feature.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Map<String,Object> readApk(File file){
		Map<String,Object> resMap=new HashMap<String,Object>();
		ApkFile apkFile = null;
		try {
			apkFile = new ApkFile(file);
			ApkMeta apkMeta = apkFile.getApkMeta();
	        resMap.put("versionCode", apkMeta.getVersionCode());
	        resMap.put("versionName", apkMeta.getVersionName());      
	        for (UseFeature feature : apkMeta.getUsesFeatures()) {
	            System.out.println(feature.getName());
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resMap;
	}
		
	public static Map<String,Object> readApk(String apkUrl){
		return readApk(new File(apkUrl));
	}
}
