package com.song.controler;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StockSN {

    public static JSONObject request(String code) {
        JSONObject result = null;
        try {
            String url = "http://hq.sinajs.cn/list=" + code;
            URL ur = new URL(url);
            HttpURLConnection uc = (HttpURLConnection) ur.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ur.openStream(), "GBK"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line);
                String [] arrayStr=line.split(",");
//                for (String s: arrayStr){
//                    System.out.print(s+"   ");
//                }
//                System.out.println();
                Map<String,String> map = new HashMap<>();

                map.put("nowPri",arrayStr[3]);
                map.put("buyOnePri",arrayStr[11]);
                map.put("buyTwoPri",arrayStr[13]);
                map.put("sellOnePri",arrayStr[21]);
                map.put("sellTwoPri",arrayStr[23]);
                map.put("time",arrayStr[31]);

                System.out.println(map);
                result = JSONObject.fromObject(map);
                System.out.println(result);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
