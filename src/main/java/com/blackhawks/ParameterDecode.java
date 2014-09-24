package com.blackhawks;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by devuser on 9/24/2014.
 */
public class ParameterDecode {

    public ParameterDecode( URL url) throws UnsupportedEncodingException {
        try {
            splitQuery( url );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> query_pairs = new LinkedHashMap<String, String>();


    public static void splitQuery(URL url) throws UnsupportedEncodingException {
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
       // return query_pairs;
    }

    public static String getNewQueryParam( String s){
        return query_pairs.get(s);
    }

}







