package com.cn.tass.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class JsonUtil {
	/**
	 * 将数据转换为json字符串
	 * 
	 * @param key
	 *            key
	 * @param value
	 *            value
	 * @return json字符串
	 */
	public static String createJsonString(String key, Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}

	/**
	 * 客户端获取json字符串
	 * @param urlStr  json字符串
	 * @return  json内容
	 */
	public static String getJsonContent(String urlStr) {
		try {
			// 获取HttpURLConnection连接对象
			URL url = new URL(urlStr);
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();
			// 设置连接属性
			httpConn.setConnectTimeout(3000);
			httpConn.setDoInput(true);
			httpConn.setRequestMethod("GET");
			// 获取相应码
			int respCode = httpConn.getResponseCode();
			if (respCode == 200) {
				return ConvertStream2Json(httpConn.getInputStream());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将输入流转换为Json字符串
	 * @param inputStream 输入流
	 * @return json字符串
	 */
	private static String ConvertStream2Json(InputStream inputStream) {
		String jsonStr = "";
		// ByteArrayOutputStream相当于内存输出流
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		// 将输入流转移到内存输出流中
		try {
			while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer, 0, len);
			}
			// 将内存流转换为字符串
			jsonStr = new String(out.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	/**
	 * 获取json字符串中的Person对象
	 * @param jsonStr json字符串
	 * @return  Person对象
	 */
	public static Person getPerson(String jsonStr) {
		Person person = new Person();
		try {
			// 将json字符串转换为json对象
			JSONObject jsonObj = new JSONObject().getJSONObject(jsonStr);
			// 得到指定json key对象的value对象
			JSONObject personObj = jsonObj.getJSONObject("person");
			// 获取指定对象的所有属性
			person.setId(personObj.getInt("id"));
			person.setName(personObj.getString("name"));
			person.setAddress(personObj.getString("address"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return person;
	}

	/**
	 * 获取json字符串中Person对象数组
	 * @param jsonStr  json数组
	 * @return Person对象数组
	 */
	public static List<Person> getPersons(String jsonStr) {
		List<Person> list = new ArrayList<Person>();

		JSONObject jsonObj;
		try {
			// 将json字符串转换为json对象
			jsonObj = new JSONObject().getJSONObject(jsonStr);
			// 得到指定json key对象的value对象
			JSONArray personList = jsonObj.getJSONArray("persons");
			// 遍历jsonArray
			for (int i = 0; i < personList.size(); i++) {
				// 获取每一个json对象
				JSONObject jsonItem = personList.getJSONObject(i);
				// 获取每一个json对象的值
				Person person = new Person();
				person.setId(jsonItem.getInt("id"));
				person.setName(jsonItem.getString("name"));
				person.setAddress(jsonItem.getString("address"));
				list.add(person);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	/**
	 * 测试程序
	 * @param args
	 */
	public static void main(String[] args) {
		//key
		String key = "name";
		String value = "zhangsan";
		String json = JsonUtil.createJsonString(key, value);
		System.out.println(json);
		String jsonStr1="{\"person\":{\"loginname\":\"zhangfan\",\"password\":\"userpass\",\"email\":\"10371443@qq.com\"},{\"loginname\":\"zf\",\"password\":\"userpass\",\"email\":\"822393@qq.com\"}}";  
		String jsonStr = "{'person' : {'id':'1','name':'zhangsan','address':'12344'}'person1': {'id':'2','name':'lisi','address':'123455'}}";
		List<Person> list = JsonUtil.getPersons(jsonStr1);

	}

}
